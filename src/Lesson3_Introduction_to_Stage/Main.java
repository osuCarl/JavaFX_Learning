package Lesson3_Introduction_to_Stage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX");
        primaryStage.getIcons().add(new Image("/Lesson3_Introduction_to_Stage/favicon.png"));
//        primaryStage.setIconified(true); //minimize
//        primaryStage.setMaximized(true); //maximize
//        primaryStage.close(); //close window
//        primaryStage.setHeight(500);
//        primaryStage.setWidth(500);
//        primaryStage.setResizable(false);   //set change window size
//        primaryStage.setMaxHeight(1000);
//        primaryStage.setMaxWidth(1000);
//        primaryStage.setMinHeight(300);
//        primaryStage.setMinWidth(300);

//        System.out.println("width = " + primaryStage.getWidth());
//        System.out.println("height = " + primaryStage.getHeight());
        //get width and height dynamically
        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue.doubleValue());
            }
        });
        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue.doubleValue());
            }
        });
//        primaryStage.setFullScreen(true);   //fullscreen, must set scene
        Group group = new Group();
        primaryStage.setScene(new Scene(group));
        primaryStage.show();


    }
}
