package Lesson2_Life_Cycle_of_Application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        Application.launch(Main2.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("This is start method");
    }
}
