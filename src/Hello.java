import javafx.application.Application;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        primaryStage.show();
    }
}