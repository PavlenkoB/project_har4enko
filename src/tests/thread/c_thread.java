package tests.thread;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.Random;
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
    ProgressBar progressBar;
    Label progressLabel;

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public void setProgressLabel(Label progressLabel) {
        this.progressLabel = progressLabel;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        int s4 = 0;
        final int wide = 1000;
        while (s4 < wide) {
            try {
                Thread.sleep(100); // спать 1000 милисекунд.

                //Platform.setImplicitExit(false);


                //System.out.println(L_Progress.getText());
                //L_Progress.setText(String.valueOf(s4));
                final int finalS = s4;
                Platform.runLater(new Runnable() {// вот эта обертка нада для нормальной роботы с javaFX
                    @Override
                    public void run() {
                        progressBar.setProgress(finalS * 0.001);
                        progressLabel.setText(String.valueOf(finalS) + '/' + wide);
                    }
                });
                s4 += randInt(1, 20);
            } catch (Exception e) {
                System.out.println("Что-то пошло не так, но бог здесь не причём, ибо его нет. Это просто какой-то косяк, который можно объяснить.");
            }
        }
        System.out.printf("Thread end");
    }
}


/*
public class main {
    static SomeRun mThing;    //mThing - объект класса, реализующего интерфейс Runnable


    public static void main(String[] args) {
        mThing = new SomeRun();

        Thread myThready = new Thread(mThing);    //Создание потока "myThready"
        myThready.start();                //Запуск потока
        myThready = new Thread(mThing);
        myThready.start();


        System.out.println("Главный поток завершён...");
    }

}*/
public class c_thread implements Initializable {
    static SomeRun mThing;    //mThing - объект класса, реализующего интерфейс Runnable
    public Label L_Progress;
    public ProgressBar progressBar;
    Thread myThready;    //Создание потока "myThready"

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void set_0(ActionEvent actionEvent) {
        progressBar.setProgress(0);
    }

    public void set_50(ActionEvent actionEvent) {
        progressBar.setProgress(0.50);
    }

    public void set_25(ActionEvent actionEvent) {
        progressBar.setProgress(0.25);
    }

    public void progress_start(ActionEvent actionEvent) {
//Создание потока
        Thread myThready = new Thread(new Runnable() {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                int s4 = 0;
                final int wide = 1000;
                while (s4 < wide) {
                    try {
                        Thread.sleep(100); // спать 1000 милисекунд.

                        Platform.setImplicitExit(false);
                        progressBar.setProgress(s4 * 0.001);


                        //System.out.println(L_Progress.getText());
                        //L_Progress.setText(String.valueOf(s4));
                        final int finalS = s4;
                        Platform.runLater(new Runnable() {// вот эта обертка нада для нормальной роботы с javaFX
                            @Override
                            public void run() {
                                L_Progress.setText(String.valueOf(finalS) + '/' + wide);
                            }
                        });
                        s4 += SomeRun.randInt(1, 20);
                    } catch (Exception e) {
                        System.out.println("Что-то пошло не так, но бог здесь не причём, ибо его нет. Это просто какой-то косяк, который можно объяснить.");
                    }
                }
                System.out.printf("Thread end");
            }
        });
        myThready.start();    //Запуск потока

    }

    public void progress_stop(ActionEvent actionEvent) {
        myThready.stop();
    }

    public void progress_start_tread(ActionEvent actionEvent) {
        mThing = new SomeRun();
        mThing.setProgressBar(progressBar);
        mThing.setProgressLabel(L_Progress);
        myThready = new Thread(mThing);    //Создание потока "myThready"
        myThready.start();
    }
}
