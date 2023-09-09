package Lesson6_ScreenUse;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Screen screen = Screen.getPrimary();
        Rectangle2D rec1 = screen.getBounds();
        Rectangle2D rec2 = screen.getVisualBounds();
        System.out.println("screen.getDpi() = " + screen.getDpi());
        System.out.println(rec1.toString());
        System.out.println(rec2.toString());
    }
}
