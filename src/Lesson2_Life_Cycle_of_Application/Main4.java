package Lesson2_Life_Cycle_of_Application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main4 extends Application {
    public static void main(String[] args) {
        System.out.println("main = " + Thread.currentThread().getName());
        launch(args);
    }

    @Override
    public void init() {
        System.out.println("init = " + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("start = " + Thread.currentThread().getName());
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.out.println("stop = " + Thread.currentThread().getName());
    }
}
