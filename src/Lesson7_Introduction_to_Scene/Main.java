package Lesson7_Introduction_to_Scene;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //load pictures in java
        URL url = getClass().getClassLoader().getResource(".//Lesson3_Introduction_to_Stage/favicon.png");
        String path = url.toExternalForm();

        Button button = new Button("button");
        button.setCursor(Cursor.HAND);

        //jump to webpage
        HostServices host = getHostServices();
        host.showDocument("https://www.baidu.com");

        Group group = new Group();
        group.getChildren().add(button);
        Scene scene = new Scene(group);
        scene.setCursor(Cursor.cursor(path));
        primaryStage.setScene(scene);

        primaryStage.setHeight(500);
        primaryStage.setWidth(500);
        primaryStage.setTitle("JavaFX");
        primaryStage.show();
    }
}
