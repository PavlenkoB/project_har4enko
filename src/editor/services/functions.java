package editor.services;

import Classes.Architecture;
import Classes.Task;
import editor.classes.DerbyDBManager;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by godex_000 on 22.05.2014.
 */
public class functions {
    /**
     * Отримання індифікатору зі спец строки
     * @param in_string - Вхідна строка з якої нербхідно отримати ID
     * @return
     */
    public static Integer get_ID(String in_string) {
        Integer out_int;
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        out_int=Integer.parseInt(out_string);
        return out_int;
    }

    /**
     * Отримання імені зі спец строки
     * @param in_string - Вхідна строка з якої необхідно отримати Імя
     * @return
     */
    public static String get_NAME(String in_string) {
        String out_string = "";
        int line_pos = 0;
        while ((in_string.charAt(line_pos) != '|') == true) {
            line_pos++;
        }
        line_pos++;
        while (line_pos < in_string.length()) {
            out_string = out_string + Character.toString(in_string.charAt(line_pos));
            line_pos++;
        }
        return out_string;
    }

    /**
     * Збереження задачі в базу
     * @param task - Обєкст класу задача
     * @param derby_DB_connection - Підключення до БД
     * @return
     */
    public static boolean task_done_save_to_DB(Task task, DerbyDBManager derby_DB_connection) {
        boolean result = false;
        try {
            derby_DB_connection.executeUpdate("INSERT INTO TASK (NAME,DESCRIPTION) VALUES ('" + task.getName() + "','" + task.getDescription() + "')");
            task.setId(last_id_from_table_DB("TASK", derby_DB_connection));
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Отримати максимальний(останій) ID з таблиці
     *
     * @param table_name          Імя таблиці
     * @param derby_DB_connection Підключення до БД
     * @return максимальни ID з таблиці
     */
    public static Integer last_id_from_table_DB(String table_name, DerbyDBManager derby_DB_connection) {
        Integer last_id = null;
        ResultSet rs_tmp;
        try {
            rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM " + table_name);
            rs_tmp.next();
            last_id = rs_tmp.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return last_id;
    }

    /**
     * Збереження готової архітектури в базу
     * @param task_id - номер задачі
     * @param arch_in - Архітектура для збереження
     * @param derby_DB_connection - Підключення до БД
     * @return - чи вдалося зберегти
     * @throws SQLException
     */
    public static boolean arch_done_save_to_DB(int task_id, Architecture arch_in, DerbyDBManager derby_DB_connection) throws SQLException {//Зберегти архітектуру в БД
        boolean result = false;
        ResultSet rs_tmp;
        if (arch_in.getDescription() == null) arch_in.setDescription("");
        if (arch_in.getUsecase() == null) arch_in.setUsecase("");
        //Добавить в базу
        //TODO Нові патерни модулі і сама архітектура
        derby_DB_connection.executeUpdate("INSERT INTO ARCH_DONE (TASK_ID,ARCH_ID) VALUES (" + task_id + "," + arch_in.getId() + ")");
        arch_in.setId_done(functions.last_id_from_table_DB("ARCH_DONE", derby_DB_connection));

        for (int s_lay = 0; s_lay < arch_in.getLayers().size(); s_lay++) {
            derby_DB_connection.executeUpdate("INSERT INTO LAY_DONE (ARCH_DONE_ID,LAY_ID) VALUES (" + arch_in.getId_done() + "," + arch_in.getLayers().get(s_lay).getId() + ")");
            arch_in.getLayers().get(s_lay).setId_done(functions.last_id_from_table_DB("LAY_DONE", derby_DB_connection));
            for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                derby_DB_connection.executeUpdate("INSERT INTO MODULE_DONE (LAY_DONE_ID,MOD_ID,PATTERN_ID) VALUES (" + arch_in.getLayers().get(s_lay).getId_done() + "," + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId() + "," + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getSelected_pattern().getId() + ")");
                arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId_done(functions.last_id_from_table_DB("MODULE_DONE", derby_DB_connection));
            }
        }

        System.out.printf("Arch save successful");
        return result;
    }

    /**
     * Отримати контролер вікна
     * @param element - елемент віна
     * @return
     */
    public static Stage get_stage_by_element(Node element) {
        return (Stage) element.getScene().getWindow();
    }

    /**
     * Прибирання а базі
     * @param derby_DB - підключення до бази
     */
    public static void clread_DB(DerbyDBManager derby_DB) {
        //Уборка в базе
        ArrayList<Integer> arch_id = new ArrayList<>();
        ArrayList<Integer> lay_id = new ArrayList<>();
        ArrayList<Integer> mod_id = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = derby_DB.executeQuery("SELECT * FROM ARCHITECTURE");
            while (rs.next()) {
                arch_id.add(rs.getInt("ID"));
            }
            rs = derby_DB.executeQuery("SELECT * FROM LAYER");
            while (rs.next()) {
                Boolean svyazan = false;
                for (int s = 0; s < arch_id.size(); s++) {
                    if (rs.getInt("ARCH_ID") == arch_id.get(s))
                        svyazan = true;
                }
                if (svyazan == true)
                    lay_id.add(rs.getInt("ID"));
                else {
                    derby_DB.executeUpdate("DELETE FROM LAYER WHERE ID=" + rs.getInt("ID"));
                }
            }

            rs = derby_DB.executeQuery("SELECT * FROM MODULE");
            while (rs.next()) {
                Boolean svyazan = false;
                for (int s = 0; s < lay_id.size(); s++) {
                    if (rs.getInt("LAY_ID") == lay_id.get(s))
                        svyazan = true;
                }
                if (svyazan == true)
                    mod_id.add(rs.getInt("ID"));
                else {
                    derby_DB.executeUpdate("DELETE FROM MODULE WHERE ID=" + rs.getInt("ID"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * З тексту генерирует картинку
     *
     * @param class_text - текст на базе которого генерируе картнку
     * @return картинка javaFX
     */
    public static javafx.scene.image.Image draw_class_image(String class_text) {
        Image class_image = null;
        if (class_text != null) {
            FileWriter out_data = null;
            try {
                out_data = new FileWriter("class.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            StringReader stringReader = new StringReader(class_text);
            BufferedReader bufferedReader = new BufferedReader(stringReader);
            try {
                out_data.flush();
                out_data.write("@startuml");

                out_data.write("\n");
                out_data.write("skinparam backgroundColor transparent\n" +//Прозрачный фон
                        "skinparam roundCorner 10");                        //Скругленые углы
                out_data.write("\n");
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    out_data.write(line);
                    out_data.write("\n");
                }
                out_data.write("\n");
                out_data.write("@enduml");
                bufferedReader.close();
                out_data.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] cmd = new String[0];
            FileSearch fileSearch = new FileSearch();
            fileSearch.searchDirectory(new File(System.getProperty("user.dir")), "plantuml.jar");
            if(fileSearch.getResult().size()>0)
            cmd = new String[]{"cmd", "/C", fileSearch.getResult().get(0)+" -charset utf-8 class.txt"};     //запустить отрисовку
            Process p = null;
            try {
                p = Runtime.getRuntime().exec(cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting for batch file ...");
            try {
                p.waitFor();                                                            //Ждать пока отрисует
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Batch file done.");
            BufferedImage bufferedImage;
            try {
                bufferedImage = ImageIO.read(new File("class.png"));
                class_image = SwingFXUtils.toFXImage(bufferedImage, null);


            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.print("class_text_null");
        }

        return class_image;
    }

    /**
     * Копіювання файлу використовуючи потоки
     * @param source з якого файлу копіювати
     * @param dest куди копіювати
     * @throws IOException
     */
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static String read_lines_from_file(File read_it) {
        String everything=null;
        try {
        BufferedReader br = null;

            br = new BufferedReader(new FileReader(read_it));

        StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
             everything = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return everything;
    }

    /**
     * Зчитати весь текст з файлу що всередені самої програми
     * @param URI шлях отриманий за допомогою getClass().getResource(url).toURI()
     * @return Текст з файлу
     */
    public static String read_lines_from_file(URI URI) {
        String everything=null;
        try {
            BufferedReader br = null;

            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(URI))));

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return everything;
    }
}
