package Lesson10_Double_Click_Key_Detect;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

        btn1.setStyle("-fx-font-size: 40px");

        //mouse click event
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                //double left click
                if(event.getClickCount() == 2 && event.getButton().name().equals(MouseButton.PRIMARY.name())) {
                    System.out.println("Double click");
                    System.out.println(event.getButton().name());
                }
            }
        });
        //when press a key
        btn1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //if pressed A
                if(event.getCode().getName().equals(KeyCode.A.name())) {
                    System.out.println(event.getCode().getName());
                }
            }
        });
        //when the key is released
//        btn1.setOnKeyReleased(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                System.out.println(event.getCode().getName());
//            }
//        });

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
