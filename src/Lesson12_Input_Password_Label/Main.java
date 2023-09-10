package Lesson12_Input_Password_Label;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        //label
        Label label = new Label("This is label:");
        label.setLayoutX(100);
        label.setLayoutY(80);
        //label click event
        label.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //left click
                if(event.getButton().equals(MouseButton.PRIMARY)) {
                    System.out.println("label clicked");
                }
            }
        });

        //input
        TextField text = new TextField();
//        text.setText("This is text");
        text.setLayoutX(100);
        text.setLayoutY(100);

        text.setPrefWidth(400);
        text.setPrefHeight(100);

        text.setStyle("-fx-font-family: SansSerif;" +
                "-fx-text-fill: red;" +
                "-fx-font-size: 28px; " +
                "-fx-border-color: black;" +
                "-fx-border-radius: 5px;" +
                "-fx-border-width: 10px;");

        Tooltip tip = new Tooltip();
        tip.setText("This is tip");
        text.setTooltip(tip);

        text.setPromptText("Please enter a text");
        text.setFocusTraversable(false);
        //set input limit, use listener
        text.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.length() > 7) {
                    text.setText(oldValue);
                }
            }
        });
        //listen selected text
        text.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });
        //enter event
        text.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("click");
            }
        });

        //password input
        PasswordField pText = new PasswordField();
        pText.setLayoutX(100);
        pText.setLayoutY(300);

        pText.setPrefWidth(400);
        pText.setPrefHeight(100);

        root.getChildren().addAll(text, pText, label);

        primaryStage.show();
    }
}
