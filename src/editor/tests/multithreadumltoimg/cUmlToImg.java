package editor.tests.multithreadumltoimg;

import Classes.Architecture;
import editor.services.functions;
import javafx.application.Platform;
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
        extends Thread        //(содержащее метод run())
{
    cUmlToImg cUmlToImg;
    private Integer id;
    private String umlText;
    private volatile boolean mFinish = false;

    public SomeRun(cUmlToImg cUmlToImg) {
        this.cUmlToImg = cUmlToImg;
    }

    public void finish() {
        mFinish = true;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public void run() {
        if (mFinish)
            return;
        if (cUmlToImg.getCount() <= 0) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    cUmlToImg.lProgress.setText((System.currentTimeMillis() - cUmlToImg.timeout) / 1000 + " seconds");
                    cUmlToImg.progressBar.setProgress(1);
                }
            });
            return;
        }
        int pos;
        synchronized (cUmlToImg.lock) {
            cUmlToImg.decreaseCount();
            pos = cUmlToImg.count;
            this.umlText = cUmlToImg.architectureArrayList.get(pos).getUsecase();
        }
        cUmlToImg.architectureArrayList.get(pos).setPreview(functions.drawClassImageThread(this.umlText, id));

        cUmlToImg.progressBar.setProgress(((pos - cUmlToImg.architectureArrayList.size()) * -1.0) / cUmlToImg.architectureArrayList.size());
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
    ArrayList<SomeRun> threads = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int s = 0; s < 100; s++) {
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
        for (int s = 0; s < threads.size(); s++) {
            threads.get(s).finish();
        }
    }

    public Integer getCount() {
        return count;
    }

    public synchronized void decreaseCount() {
        this.count--;
    }

    public void bStartConvert(ActionEvent actionEvent) {
        count = new Integer(architectureArrayList.size());
        timeout = System.currentTimeMillis();
        threads.clear();
        for (int s = 0; s < Integer.parseInt(tfThreads.getText()); s++) {
            threads.add(new SomeRun(this));
            threads.get(s).setId(s);
            threads.get(s).start();
        }
    }
}
