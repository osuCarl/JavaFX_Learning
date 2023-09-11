package Lesson14_HBox_Vbox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane ap= new AnchorPane();
        AnchorPane ap2 = new AnchorPane();
        ap.setStyle("-fx-background-color: skyblue;");
        ap2.setStyle("-fx-background-color: yellow;");
        //all notes can set width and height
        ap2.setPrefWidth(300);
        ap2.setPrefHeight(300);
        ap.getChildren().add(ap2);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
