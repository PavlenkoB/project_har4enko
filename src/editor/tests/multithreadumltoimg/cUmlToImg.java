package editor.tests.multithreadumltoimg;

import Classes.Architecture;
import editor.services.functions;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by
 * User: godex_000
 * Date: 14.09.2014.
 * Time: 18:00
 */
class SomeRun           //Нечто, реализующее интерфейс Runnable
        implements Runnable        //(содержащее метод run())
{
    cUmlToImg cUmlToImg;
    private Integer id;
    private String umlText;

    public SomeRun(cUmlToImg cUmlToImg) {
        this.cUmlToImg = cUmlToImg;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void run() {
        if (cUmlToImg.getCount() <= 0) {
            System.out.println((System.currentTimeMillis() - cUmlToImg.timeout)/1000+" seconds");
            return;
        }
        int pos;
        synchronized (cUmlToImg.lock) {
            pos = cUmlToImg.count;
            cUmlToImg.decreaseCount();
        }
        this.umlText = cUmlToImg.architectureArrayList.get(pos-1).getUsecase();
        cUmlToImg.architectureArrayList.get(pos-1).setPreview(functions.drawClassImageThread(this.umlText, id));
        cUmlToImg.progressBar.setProgress(cUmlToImg.progressBar.getProgress()+1/cUmlToImg.architectureArrayList.size());
        System.out.println("Thread " + id + " end" + pos);
        SomeRun someRun = this;
        Thread thread = new Thread(someRun);
        thread.start();
    }
}

public class cUmlToImg implements Initializable {
    public final Object lock = new Object();
    public long timeout;
    public Integer count;
    public ProgressBar progressBar; // прогрес бар
    public Label lProgress;         // текст прогреса
    public TextField tfThreads;     // количество потоков
    public ArrayList<Architecture> architectureArrayList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int s = 0; s < 30; s++) {
            architectureArrayList.add(new Architecture());
            architectureArrayList.get(s).setUsecase("package \"Сервісний додаток\"{\n" +
                    "package \"Сервісів\"{\n" +
                    "package \"Інтерфейс сервісів\"{\n" +
                    "}\n" +
                    "package \"Типи повідомлень\"{\n" +
                    "}\n" +
                    "}\n" +
                    "package \"Бізнес\"{\n" +
                    "package \"Фасад програми\"{\n" +
                    "}\n" +
                    "package \"Бізнес-процес\"{\n" +
                    "}\n" +
                    "package \"Бізнес-компоненти\"{\n" +
                    "}\n" +
                    "}\n" +
                    "package \"Доступу до даних\"{\n" +
                    "package \"Агенти сервісів\"{\n" +
                    "}\n" +
                    "package \"Компоненти доступу до даних\"{\n" +
                    "}\n" +
                    "}\n" +
                    "}");
        }


    }

    public void progress_start(ActionEvent actionEvent) {
//Создание потока
        Thread myThready = new Thread(new Runnable() {
            public void run() //Этот метод будет выполняться в побочном потоке
            {

            }
        });
        myThready.start();    //Запуск потока
    }

    public void bStopConvert(ActionEvent actionEvent) {
        for (int s = 0;s<threads.size();s++){
            threads.get(s).stop();
        }
    }

    public Integer getCount() {
        return count;
    }

    public synchronized void decreaseCount() {
        this.count--;
    }
    ArrayList<Thread> threads= new ArrayList<>();
    ArrayList<SomeRun> runs = new ArrayList<>();
    public void bStartConvert(ActionEvent actionEvent) {
        count = new Integer(architectureArrayList.size());
        timeout = System.currentTimeMillis();
        threads.clear();
        runs.clear();
        for (int s = 0; s < Integer.parseInt(tfThreads.getText()); s++) {
            runs.add(new SomeRun(this));
            runs.get(s).setId(s);
            threads.add(new Thread(runs.get(s)));
            threads.get(s).start();
        }
    }
}
