package Classes;

import editor.classes.DerbyDBManager;
import editor.classes.Modals;
import editor.classes.resultInfo;
import editor.services.ImageConverter;
import editor.services.drawUml;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */

/**
 * <p>
 * Architecture is class contains application architecture
 * with layers, modules and theirs patterns
 * <p/>
 * <p>
 * Architecture это класс архитектура приложения
 * с слоями, модулями и паттернами
 * </p>
 */
public class Architecture implements Cloneable {
    private Integer id;                                          // id in DB
    private String name;                                         // name of architecture
    private ArrayList<Layer> layers = new ArrayList<Layer>();   //array fo layers
    private String description;                                 // architecture description
    private Integer idDone;                                    //TODO
    private Integer taskId;                                    //TODO
    private String usecase;                                     // plantuml text of architecture
    private javafx.scene.image.Image preview;                   //architecture preview

    public Architecture() {
        this.id = 0;
        this.name = new String();
        this.layers = null;
        this.description = new String();
        this.idDone = 0;
        this.taskId = 0;
        this.usecase = new String();
    }


    public Architecture(Integer id, String name, Integer idDone, Integer taskId) {
        this.id = id;
        this.name = name;
        this.idDone = idDone;
        this.taskId = taskId;
        this.layers = null;
        this.description = new String();
    }

    public Architecture(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public Architecture(Integer id, String name, ArrayList<Layer> layers, String description, Integer idDone, Integer taskId) {
        this.id = id;
        this.name = name;
        this.layers = layers;
        this.description = description;
        this.idDone = idDone;
        this.taskId = taskId;
    }

    public Architecture(Integer id, String name, ArrayList<Layer> layers, String description, String usecase) {
        this.id = id;
        this.name = name;
        this.layers = layers;
        this.description = description;
        this.usecase = usecase;
    }


    /**
     * @param arch_id
     * @param derby_DB_connection
     * @return
     */
    //TODO опис функції
    public static Architecture arch_load_from_DB(Integer arch_id, DerbyDBManager derby_DB_connection) {
        Architecture archOut = new Architecture();
        ResultSet rs_arch, rs_lay, rs_mod, rs_pat = null;
        int s_lay = 0, s_mod = 0, s_pat = 0;
        try {
            rs_arch = derby_DB_connection.executeQuery("SELECT * FROM ARCHITECTURE WHERE ID=" + arch_id);
            rs_arch.next();
            archOut = new Architecture(rs_arch.getInt("ID"), rs_arch.getString("NAME"), rs_arch.getString("DESCRIPTION"));
            archOut.setUsecase(rs_arch.getString("USECASE"));
            /*Зчитати превю*/

            ImageIcon image = null;
            //TODO конект не тот(
            Connection con = derby_DB_connection.getCon();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ARCHITECTURE WHERE ID=" + arch_id);
            if (rs.next()) {
                Blob photo = rs.getBlob("PREVIEW");
                if (photo != null) {
                    ObjectInputStream ois = null;
                    try {
                        ois = new ObjectInputStream(photo.getBinaryStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        image = (ImageIcon) ois.readObject();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    archOut.setPreview(ImageConverter.AWTImgtoFXImg(image.getImage()));
                } else {
                    archOut.setPreview(null);
                }
            }
            s.close();

            if (archOut.getPreview() == null || archOut.getPreview().getHeight() < 20) {
                archOut.setPreview(new Image("res/img/preview-not-available.jpg"));
            }


            //Выбрать все Слои даной архитектуры
            rs_lay = derby_DB_connection.executeQuery("SELECT * FROM LAYER WHERE ARCH_ID=" + arch_id);
            while (rs_lay.next()) {
                archOut.getLayers().add(new Layer(rs_lay.getInt("ID"), rs_lay.getInt("ARCH_ID"), rs_lay.getString("NAME"), rs_lay.getString("DESCRIPTION")));
                rs_mod = derby_DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + rs_lay.getInt("ID"));
                s_mod = 0;
                while (rs_mod.next()) {
                    archOut.getLayers().get(s_lay).getModules().add(new Module(rs_mod.getInt("ID"), rs_mod.getInt("LAY_ID"), rs_mod.getString("NAME"), rs_mod.getString("DESCRIPTION")));
                    rs_pat = derby_DB_connection.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + rs_mod.getInt("ID"));
                    ObservableList<String> items = FXCollections.observableArrayList();
                    while (rs_pat.next()) {//Все патерны что подходят модулю в кнопку
                        archOut.getLayers().get(s_lay).getModules().get(s_mod).getAvilablePatterns().add(Pattern.patternLoadFromDB(rs_pat.getInt("ID"), derby_DB_connection));
                        items.add(rs_pat.getString("ID") + "|" + rs_pat.getString("NAME"));
                    }
                    s_mod++;
                }
                s_lay++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Arch load end->" + archOut.getName());
        return archOut;
    }

    /**
     * Зберіга архітектуру в базу
     *
     * @param arch_in             Архітектура яку потрібно зберегти
     * @param derby_DB_connection Підключення до БД
     * @return чи вдалося зберегти
     */
    public static resultInfo arch_save_to_DB(Architecture arch_in, DerbyDBManager derby_DB_connection) {
        resultInfo result = new resultInfo();
        try {
            //получить оригинал
            Architecture arch_old = arch_load_from_DB(arch_in.getId(), derby_DB_connection);
            ArrayList<Module> modules_old = new ArrayList<>();
            ArrayList<Module> modules_new = new ArrayList<>();
            ArrayList<Layer> layers_old = new ArrayList<>();
            ArrayList<Layer> layers_new = new ArrayList<>();

            //arch_in=arch_load_from_DB(arch_old.getId(),derby_DB_connection);//загрузить архитекутур уже с новыми слоями и модулями
            //Удалить не существующие слои
            for (int i = 0; i < arch_old.getLayers().size(); i++) {//Перебор слойов в старой
                boolean save = false;
                for (int s = 0; s < arch_in.getLayers().size(); s++) {
                    //сравниваем если в новой такой слой
                    try {
                        if (arch_in.getLayers().get(s).getId().equals(arch_old.getLayers().get(i).getId())) {
                            save = true; //если остался то нужно сохранить
                        }
                    } catch (NullPointerException e) {

                    }
                }
                if (save == false) {
                    System.out.printf("DELETE FROM LAYER WHERE ID=" + arch_old.getLayers().get(i).getId());
                    derby_DB_connection.executeUpdate("DELETE FROM LAYER WHERE ID=" + arch_old.getLayers().get(i).getId());
                }
            }
            //Удалить не существующие модули
            for (int l_o = 0; l_o < arch_old.getLayers().size(); l_o++) {
                for (int m_o = 0; m_o < arch_old.getLayers().get(l_o).getModules().size(); m_o++) {
                    boolean save = false;
                    for (int l_n = 0; l_n < arch_in.getLayers().size(); l_n++) {
                        for (int m_n = 0; m_n < arch_in.getLayers().get(l_n).getModules().size(); m_n++) {
                            //System.out.printf("\n"+String.valueOf(l_o)+"|"+String.valueOf(m_o)+"|"+String.valueOf(l_n)+"|"+String.valueOf(m_n));
                            if (arch_in.getLayers().get(l_n).getModules().get(m_n).getId() != null) {
                                if (arch_old.getLayers().get(l_o).getModules().get(m_o).getId().intValue() == arch_in.getLayers().get(l_n).getModules().get(m_n).getId().intValue())
                                    save = true;
                            }
                        }
                    }
                    if (save == false) {
                        derby_DB_connection.executeUpdate("UPDATE PATERNS SET MOD_ID=-1 WHERE MOD_ID=" + arch_old.getLayers().get(l_o).getModules().get(m_o).getId());
                        System.out.printf("DELETE FROM MODULE WHERE ID=" + arch_old.getLayers().get(l_o).getModules().get(m_o).getId());
                        derby_DB_connection.executeUpdate("DELETE FROM MODULE WHERE ID=" + arch_old.getLayers().get(l_o).getModules().get(m_o).getId());
                    }
                }
            }

            ResultSet rs_tmp;
            if (arch_in.getDescription() == null) arch_in.setDescription("");
            if (arch_in.getUsecase() == null) arch_in.setUsecase("");
            if (arch_in.getId() == null || arch_in.getId() == 0) {//Добавить в базу
                //Нові патерни модулі і сама архітектура
                PreparedStatement preparedStatement = derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                preparedStatement.setString(1, arch_in.getName());
                preparedStatement.setString(2, arch_in.getUsecase());
                preparedStatement.setString(3, arch_in.getDescription());
                preparedStatement.executeUpdate();

                rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM ARCHITECTURE");
                rs_tmp.next();
                arch_in.setId(rs_tmp.getInt(1));
                try {
                    save_arch_img_update(arch_in, derby_DB_connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int s_lay = 0; s_lay < arch_in.getLayers().size(); s_lay++) {
                    derby_DB_connection.executeUpdate("INSERT INTO LAYER (ARCH_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getId() + ",'" + arch_in.getLayers().get(s_lay).getName() + "','" + arch_in.getLayers().get(s_lay).getDescription() + "')");
                    //TODO
                    /*PreparedStatement preparedStatement=derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                    preparedStatement.setString(1,arch_in.getName());
                    preparedStatement.setString(2,arch_in.getUsecase());
                    preparedStatement.setString(3,arch_in.getDescription());
                    preparedStatement.executeUpdate();*/
                    rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM LAYER");
                    rs_tmp.next();

                    if (derby_DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + rs_tmp.getInt(1)).next() == false) {
                        System.out.println("Шар '" + arch_in.getLayers().get(s_lay).getName() + "' не містить модулів");
                        Modals.showInfoApplicationModal("Увага", "Шар '" + arch_in.getLayers().get(s_lay).getName() + "' не містить модулів");
                    }

                    arch_in.getLayers().get(s_lay).setId(rs_tmp.getInt(1));
                    for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                        derby_DB_connection.executeUpdate("INSERT INTO MODULE (LAY_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getLayers().get(s_lay).getId() + ",'" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "','" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "')");

                        //TODO
                    /*PreparedStatement preparedStatement=derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                    preparedStatement.setString(1,arch_in.getName());
                    preparedStatement.setString(2,arch_in.getUsecase());
                    preparedStatement.setString(3,arch_in.getDescription());
                    preparedStatement.executeUpdate();*/
                        rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM MODULE");
                        rs_tmp.next();
                        arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId(rs_tmp.getInt(1));
                        if (derby_DB_connection.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + rs_tmp.getInt(1)).next() == false) {
                            System.out.println("Module '" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "' don`t have patterns");
                            Modals.showInfoApplicationModal("Увага", "Модуль '" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "' не містить патернів");
                        }
                    }
                }
            } else {
                //якщо змінти дані про архітектуру
                derby_DB_connection.executeUpdate("UPDATE ARCHITECTURE " + "SET NAME='" + arch_in.getName() + "',USECASE='" + arch_in.getUsecase() + "',DESCRIPTION='" + arch_in.getDescription() + "' WHERE ID=" + arch_in.getId());
                //TODO
                    /*PreparedStatement preparedStatement=derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                    preparedStatement.setString(1,arch_in.getName());
                    preparedStatement.setString(2,arch_in.getUsecase());
                    preparedStatement.setString(3,arch_in.getDescription());
                    preparedStatement.executeUpdate();*/
                try {
                    save_arch_img_update(arch_in, derby_DB_connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int s_lay = 0; s_lay < arch_in.getLayers().size(); s_lay++) {
                    if (arch_in.getLayers().get(s_lay).getId() == null || arch_in.getId() == 0) {
                        // Якщо шар новий то створити нові моудул і сам шар
                        derby_DB_connection.executeUpdate("INSERT INTO LAYER (ARCH_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getId() + ",'" + arch_in.getLayers().get(s_lay).getName() + "','" + arch_in.getLayers().get(s_lay).getDescription() + "')");
                        //TODO
                    /*PreparedStatement preparedStatement=derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                    preparedStatement.setString(1,arch_in.getName());
                    preparedStatement.setString(2,arch_in.getUsecase());
                    preparedStatement.setString(3,arch_in.getDescription());
                    preparedStatement.executeUpdate();*/
                        rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM LAYER");
                        rs_tmp.next();
                        arch_in.getLayers().get(s_lay).setId(rs_tmp.getInt(1));
                        for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                            derby_DB_connection.executeUpdate("INSERT INTO MODULE (LAY_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getLayers().get(s_lay).getId() + ",'" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "','" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "')");
                            //TODO
                    /*PreparedStatement preparedStatement=derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                    preparedStatement.setString(1,arch_in.getName());
                    preparedStatement.setString(2,arch_in.getUsecase());
                    preparedStatement.setString(3,arch_in.getDescription());
                    preparedStatement.executeUpdate();*/
                            rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM MODULE");
                            rs_tmp.next();
                            arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId(rs_tmp.getInt(1));
                        }
                    } else {
                        // якщо змінили дані про шар
                        derby_DB_connection.executeUpdate("UPDATE LAYER " + "SET NAME='" + arch_in.getLayers().get(s_lay).getName() + "',ARCH_ID=" + arch_in.getId() + ",DESCRIPTION='" + arch_in.getLayers().get(s_lay).getDescription() + "' WHERE ID=" + arch_in.getLayers().get(s_lay).getId());
                        if (derby_DB_connection.executeQuery("SELECT * FROM MODULE WHERE LAY_ID=" + arch_in.getLayers().get(s_lay).getId()).next() == false) {
                            System.out.println("Шар '" + arch_in.getLayers().get(s_lay).getName() + "' не містить модулів");
                            Modals.showInfoApplicationModal("Увага", "Шар '" + arch_in.getLayers().get(s_lay).getName() + "' не містить модулів");
                        }
                        //TODO
                    /*PreparedStatement preparedStatement=derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                    preparedStatement.setString(1,arch_in.getName());
                    preparedStatement.setString(2,arch_in.getUsecase());
                    preparedStatement.setString(3,arch_in.getDescription());
                    preparedStatement.executeUpdate();*/
                        for (int s_mod = 0; s_mod < arch_in.getLayers().get(s_lay).getModules().size(); s_mod++) {
                            if (arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId() == null || arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId() == 0) {
                                // якщо модуль новий
                                derby_DB_connection.executeUpdate("INSERT INTO MODULE (LAY_ID,NAME,DESCRIPTION) VALUES (" + arch_in.getLayers().get(s_lay).getId() + ",'" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "','" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "')");
                                //TODO
                    /*PreparedStatement preparedStatement=derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                    preparedStatement.setString(1,arch_in.getName());
                    preparedStatement.setString(2,arch_in.getUsecase());
                    preparedStatement.setString(3,arch_in.getDescription());
                    preparedStatement.executeUpdate();*/
                                rs_tmp = derby_DB_connection.executeQuery("SELECT MAX(ID) FROM MODULE");
                                rs_tmp.next();
                                arch_in.getLayers().get(s_lay).getModules().get(s_mod).setId(rs_tmp.getInt(1));
                            } else {
                                // якщо модуль редагований
                                derby_DB_connection.executeUpdate("UPDATE MODULE " + "SET NAME='" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "',DESCRIPTION='" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getDescription() + "' WHERE ID=" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId());
                                //rs_tmp=derby_DB_connection.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId());
                                if (derby_DB_connection.executeQuery("SELECT * FROM PATERNS WHERE MOD_ID=" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getId()).next() == false) {
                                    System.out.println("Module '" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "' don`t have patterns");
                                    Modals.showInfoApplicationModal("Увага", "Модуль '" + arch_in.getLayers().get(s_lay).getModules().get(s_mod).getName() + "' не містить патернів");
                                }
                                //TODO
                    /*PreparedStatement preparedStatement=derby_DB_connection.getCon().prepareStatement("INSERT INTO ARCHITECTURE (NAME,USECASE,DESCRIPTION) VALUES (?,?,?)");
                    preparedStatement.setString(1,arch_in.getName());
                    preparedStatement.setString(2,arch_in.getUsecase());
                    preparedStatement.setString(3,arch_in.getDescription());
                    preparedStatement.executeUpdate();*/
                            }
                        }
                    }
                }
            }
            result.setStatus(true);
            System.out.println("Arch save successful");

        } catch (SQLException e) {
            result.setComment(e);
            e.printStackTrace();
        }
        return result;
    }

    //TODO опис функції
    private static void save_arch_img_update(Architecture architecture, DerbyDBManager derbyDBManager) throws Exception {
        Connection con;
        con = derbyDBManager.getCon();

        PreparedStatement ps;
        ps = con.prepareStatement("UPDATE ARCHITECTURE SET PREVIEW=" + "?" + " WHERE ID=" + architecture.getId());

        Blob blob = con.createBlob();
        ImageIcon ii = new ImageIcon(ImageConverter.FXimgToAWTimg(architecture.getPreview()));

        ObjectOutputStream oos;
        oos = new ObjectOutputStream(blob.setBinaryStream(1));
        oos.writeObject(ii);
        oos.close();
        ps.setBlob(1, blob);
        ps.execute();
        blob.free();
        ps.close();
    }

    /**
     * Генерувати текст архітектури щоб потім його перетворити в картинку
     *
     * @param architecture - Архітектура
     * @return
     */
    public static String arch_uml_text_gen(Architecture architecture) {
        architecture.getName();
        String class_text = new String();
        //class_text += "title Архітектура \""+architecture.getName()+"\"\n";//Заголовок
        class_text += "left to right direction\n";//Зверху вниз
        class_text += "package \"" + architecture.getName() + "\"{\n";
        for (int s_lay = 0; s_lay < architecture.getLayers().size(); s_lay++) {
            class_text += "package \"" + architecture.getLayers().get(s_lay).getName() + "\"{\n";
            for (int s_mod = 0; s_mod < architecture.getLayers().get(s_lay).getModules().size(); s_mod++) {
                class_text += "package \"" + architecture.getLayers().get(s_lay).getModules().get(s_mod).getName() + "\"{\n";
                /*if (architecture.getLayers().get(s_lay).getModules().get(s_mod).getSelectedPattern() != null)
                    class_text += architecture.getLayers().get(s_lay).getModules().get(s_mod).getSelectedPattern().getUmlText() + "\n";
                class_text += "package \"" + architecture.getLayers().get(s_lay).getModules().get(s_mod).getName() + "\"{\n";*/
                if (architecture.getLayers().get(s_lay).getModules().get(s_mod).getSelectedPattern() != null) {
                    String temp = new String(architecture.getLayers().get(s_lay).getModules().get(s_mod).getSelectedPattern().getUmlText() + "\n");
                    temp = temp.replace("path.", architecture.getLayers().get(s_lay).getModules().get(s_mod).getName() + ".");
                    class_text += temp;
                }
                class_text += "}\n";
            }
            class_text += "}\n";
        }
        class_text += "}\n";
        return class_text;
    }

    /**
     * Генерирует картинку архитектуры с выбраными патернами
     *
     * @param architecture архитектура для которой сделать картинку
     * @return картинка архитектуры с патернами внутри
     */
    public static javafx.scene.image.Image arch_image_gen_with_patterns(Architecture architecture) {
        return drawUml.draw_class(arch_uml_text_gen(architecture));
    }

    /**
     * Генерирует можливі варіанти архітектур
     * з різними патернами
     *
     * @param origin_arch - Оригінальна архітектура
     * @param modules_arr - Список модулів даної архітектури
     * @return Список сгенерированых архитектур
     */
    public static ArrayList<Architecture> gen_arch_done_pre_combine(Architecture origin_arch, ArrayList<Module> modules_arr) {
        ArrayList<Architecture> return_Architectures = new ArrayList<>();
        ArrayList<Integer> modd_arr_sellected = new ArrayList<>();
        //Все устанавливаем в 1
        for (int s_mod = 0; s_mod < modules_arr.size(); s_mod++) {
            modd_arr_sellected.add(s_mod, 0);
            try {
                modules_arr.get(s_mod).setSelectedPattern(modules_arr.get(s_mod).getAvilablePatterns().get(0).clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return_Architectures = gen_arch_done_combine(return_Architectures, origin_arch, modules_arr, modd_arr_sellected);
        return return_Architectures;
    }

    /**
     * @param return_Architectures
     * @param origin_arch
     * @param modules_arr
     * @param modd_arr_sell        -
     */
    //TODO опис функції
    private static ArrayList<Architecture> gen_arch_done_combine(ArrayList<Architecture> return_Architectures, Architecture origin_arch, ArrayList<Module> modules_arr, ArrayList<Integer> modd_arr_sell) {
        //save
        Architecture tmp_arch = new Architecture();
        try {
            tmp_arch = origin_arch.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        int s_add = 0;
        for (int s_lay = 0; s_lay < tmp_arch.getLayers().size(); s_lay++) {
            for (int s_mod = 0; s_mod < tmp_arch.getLayers().get(s_lay).getModules().size(); s_mod++) {
                for (int s_copy = 0; s_copy < modules_arr.size(); s_copy++) {
                    if (tmp_arch.getLayers().get(s_lay).getModules().get(s_mod).getId().intValue() == modules_arr.get(s_copy).getId().intValue()) {//если ИД моделя совпадает то записать ему патерн
                        try {
                            tmp_arch.getLayers().get(s_lay).getModules().get(s_mod).setSelectedPattern(new Pattern());
                            tmp_arch.getLayers().get(s_lay).getModules().get(s_mod).setSelectedPattern(modules_arr.get(s_copy).getAvilablePatterns().get(modd_arr_sell.get(s_copy)).clone());
                        } catch (CloneNotSupportedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                s_add++;
            }
        }
        return_Architectures.add(tmp_arch);//сохраняем архитекутуры вариант
        modd_arr_sell.set(modd_arr_sell.size() - 1, modd_arr_sell.get(modd_arr_sell.size() - 1) + 1);//к последнему добавить +1
        for (int ta = modd_arr_sell.size() - 1; ta >= 0; ta--) {//провиряем не вышол кто за границы доступных патернов
            if (modd_arr_sell.get(ta) > modules_arr.get(ta).getAvilablePatterns().size() - 1 && ta == 0) {//если все патерны попробованы
                return return_Architectures;
            }
            if (modd_arr_sell.get(ta) > modules_arr.get(ta).getAvilablePatterns().size() - 1) {
                modd_arr_sell.set(ta, 0);
                modd_arr_sell.set(ta - 1, modd_arr_sell.get(ta - 1) + 1);
            }
        }
        gen_arch_done_combine(return_Architectures, origin_arch, modules_arr, modd_arr_sell);
        return return_Architectures;
    }

    public javafx.scene.image.Image getPreview() {
        return preview;
    }

    public void setPreview(javafx.scene.image.Image preview) {
        this.preview = preview;
    }

    /**
     * Клонувати архітектуру
     *
     * @return Клон Архитектури
     * @throws CloneNotSupportedException
     */
    public Architecture clone() throws CloneNotSupportedException {
        Architecture a_return = new Architecture();//(Architecture) super.clone();

        a_return.id = this.id;
        a_return.name = this.name;
        ArrayList<Layer> layers = new ArrayList<>(this.layers.size());
        for (Layer item : this.layers) {
            layers.add(item.clone());
        }
        a_return.layers = layers;
        a_return.description = this.description;
        a_return.idDone = this.idDone;
        a_return.taskId = this.taskId;
        a_return.usecase = this.usecase;
        //TODO картинку тоже клонировать
        a_return.preview = this.preview;


        return a_return;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Layer> getLayers() {
        return layers;
    }

    public void setLayers(ArrayList<Layer> layers) {
        this.layers = layers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdDone() {
        return idDone;
    }

    public void setIdDone(Integer idDone) {
        this.idDone = idDone;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getUsecase() {
        return usecase;
    }

    public void setUsecase(String usecase) {
        this.usecase = usecase;
    }
        /*}
    }*/
}


