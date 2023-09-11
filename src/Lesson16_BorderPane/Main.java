package Lesson16_BorderPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("b1");

        AnchorPane ap1 = new AnchorPane();
        ap1.setPrefWidth(100);
        ap1.setPrefHeight(100);
        ap1.setStyle("-fx-background-color: skyblue;");

        AnchorPane ap2 = new AnchorPane();
        ap2.setPrefWidth(100);
        ap2.setPrefHeight(100);
        ap2.setStyle("-fx-background-color: yellow;");

        AnchorPane ap3 = new AnchorPane();
        ap3.setPrefWidth(100);
        ap3.setPrefHeight(100);
        ap3.setStyle("-fx-background-color: orange;");

        AnchorPane ap4 = new AnchorPane();
        ap4.setPrefWidth(100);
        ap4.setPrefHeight(100);
        ap4.setStyle("-fx-background-color: blue;");

        AnchorPane ap5 = new AnchorPane();
        ap5.setPrefWidth(100);
        ap5.setPrefHeight(100);
        ap5.setStyle("-fx-background-color: red;");

        BorderPane bor = new BorderPane();
        bor.setStyle("-fx-background-color: gray;");
        bor.setTop(ap1);
        bor.setBottom(ap2);
        bor.setLeft(ap3);
        bor.setRight(ap4);
        bor.setCenter(ap5);


//        don't use this
//        bor.getChildren().addAll(ap1, ap2, ap3, ap4, ap5);

//        bor.setPadding(new Insets(10));
//        BorderPane.setMargin(ap1, new Insets(10));
//        BorderPane.setAlignment(ap1, Pos.BOTTOM_CENTER);

//        Button bu = (Button)bor.getTop();
//        System.out.println(bu.getText());

        Scene scene = new Scene(bor);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
