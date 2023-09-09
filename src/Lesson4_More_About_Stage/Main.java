package Lesson4_More_About_Stage;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setOpacity(0.1);//window opacity
//        primaryStage.setAlwaysOnTop(true);//always on top
        primaryStage.setX(50);//distance to left-top screen
        primaryStage.setY(50);
        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("x cor = " + newValue.doubleValue());
            }
        });
        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("y cor = " + newValue.doubleValue());
            }
        });
        primaryStage.show();
    }
}
