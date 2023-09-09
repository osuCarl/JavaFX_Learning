package Lesson2_Life_Cycle_of_Application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main1 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("This is start method");
    }
}
