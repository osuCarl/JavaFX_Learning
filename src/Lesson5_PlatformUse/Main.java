package Lesson5_PlatformUse;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //JavaFX Application Thread
        System.out.println(Thread.currentThread().getName());
        //runLater() runs at the end of start
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //JavaFX Application Thread, same thread
                System.out.println(Thread.currentThread().getName());
                System.out.println("in runLater");
                int i = 1;
                while(i <= 10) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("i = " + i);
                    i++;
                }
            }
        });
        System.out.println("below runLater");
    }
}
