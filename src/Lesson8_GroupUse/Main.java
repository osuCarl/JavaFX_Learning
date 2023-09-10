package Lesson8_GroupUse;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        btn1.setLayoutX(0);
        btn1.setLayoutY(10);
        btn1.setPrefWidth(50);
        btn1.setPrefHeight(50);

        btn2.setLayoutX(200);
        btn2.setLayoutY(10);

        btn3.setLayoutX(400);
        btn3.setLayoutY(10);
        Group group = new Group();
        //add listener on group, listens the node change
        group.getChildren().addAll(btn1, btn2, btn3);
        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("Current numbers: " + c.getList().size());
            }
        });

        //add click event
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button btn4 = new Button("btn4");
                group.getChildren().add(btn4);
            }
        });

//        group.getChildren().clear();

//        group.setAutoSizeChildren(false);

//        group.setOpacity(0.2);

//        System.out.println(group.contains(0, 0));//false
//        System.out.println(group.contains(0, 10));//true
//        System.out.println(group.contains(0, 20));//false

        Object[] obj = group.getChildren().toArray();
//        System.out.println(obj.length);
        for (Object o : obj) {
            Button bu = (Button)o;
            bu.setPrefHeight(30);
            bu.setPrefWidth(60);
        }
        
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
