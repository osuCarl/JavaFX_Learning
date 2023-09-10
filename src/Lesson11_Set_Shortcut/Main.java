package Lesson11_Set_Shortcut;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn1 = new Button();
        btn1.setText("Press \"ctrl + alt + a\"");
        btn1.setLayoutX(100);
        btn1.setLayoutY(100);
        btn1.setPrefWidth(400);
        btn1.setPrefHeight(50);
        btn1.setStyle("-fx-font-size: 22px");
        //single left click
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //call a method
                play();
            }
        });
        Group root = new Group();
        root.getChildren().add(btn1);
        Scene scene = new Scene(root);

        //first method, compatibility issue existed
        KeyCombination kc1 = new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN, KeyCombination.ALT_DOWN);
        Mnemonic mnemonic1 = new Mnemonic(btn1, kc1);
        scene.addMnemonic(mnemonic1);

        //second method, rarely use
        KeyCombination kc2 = new KeyCharacterCombination("A", KeyCombination.CONTROL_DOWN, KeyCombination.ALT_DOWN);
        Mnemonic mnemonic2 = new Mnemonic(btn1, kc2);
        scene.addMnemonic(mnemonic2);

        //third method, not introduced please refer to doc

        //fourth method, recommended
        //SHORTCUT_DOWN is recognized as ""ctrl" on Windows or "meta" on macOS
        KeyCombination kc4 = new KeyCodeCombination(KeyCode.Y, KeyCombination.SHORTCUT_DOWN);
        scene.getAccelerators().put(kc4, new Runnable() {
            @Override
            public void run() {
                System.out.println("run method");
                //call method in click event
                play();
                System.out.println(Thread.currentThread().getName());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");
        primaryStage.show();
    }
    public static void play() {
        System.out.println("single click");
    }
}

