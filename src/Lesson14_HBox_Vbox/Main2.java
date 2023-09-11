package Lesson14_HBox_Vbox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1= new Button("button1");
        Button b2= new Button("button2");
        Button b3= new Button("button3");

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: skyblue;");
        //horizontal layout
        HBox box = new HBox();
        box.setStyle("-fx-background-color: yellow;");
        box.setPrefWidth(400);
        box.setPrefHeight(400);
        box.setPadding(new Insets(10));
        //spacing between children
        box.setSpacing(10);
        //set margin of child
        HBox.setMargin(b1, new Insets(10));
        //set alignment
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(b1, b2, b3);
        ap.getChildren().add(box);

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
