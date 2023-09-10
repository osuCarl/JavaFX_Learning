package Lesson9_Button_Background_Border;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button();
        btn1.setText("btn1");
        btn1.setLayoutX(100);
        btn1.setLayoutY(100);
        btn1.setPrefWidth(400);
        btn1.setPrefHeight(50);

//        //set font style
//        btn1.setFont(Font.font("Times New Roman", 40));
//        btn1.setTextFill(Paint.valueOf("00FF00"));
//        //set background
//        BackgroundFill bgf = new BackgroundFill(Paint.valueOf("8FBC8F"), new CornerRadii(20), Insets.EMPTY);
//        Background bg = new Background(bgf);
//        btn1.setBackground(bg);
//        //set border
//        BorderStroke bds = new BorderStroke(Paint.valueOf("8A2BE2"),BorderStrokeStyle.DOTTED, new CornerRadii(20), new BorderWidths(5));
//        Border bd = new Border(bds);
//        btn1.setBorder(bd);

        //use css style, recommended
        btn1.setStyle(
                        "-fx-background-color: skyblue;" +
                        "-fx-border-radius: 20;" +
                        "-fx-text-fill: red"
        );
        //click event
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //what to do after click
                Button btn = (Button)event.getSource();
                System.out.println(btn.getText());
                System.out.println("you clicked the button");
            }
        });

        Group root = new Group();
        root.getChildren().add(btn1);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");
        primaryStage.show();
    }
}
