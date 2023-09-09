package Lesson4_More_About_Stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage s1 = new Stage();
        Stage s2 = new Stage();
        Stage s3 = new Stage();
        Stage s4 = new Stage();
        Stage s5 = new Stage();
        s1.setTitle("s1");
        s2.setTitle("s2");
        s3.setTitle("s3");
        s4.setTitle("s4");
        s5.setTitle("s5");
        s1.initStyle(StageStyle.DECORATED);//default style
        s2.initStyle(StageStyle.TRANSPARENT);
        s3.initStyle(StageStyle.UNDECORATED);
        Group group = new Group();
        s3.setScene(new Scene(group));
        s4.initStyle(StageStyle.UNIFIED);
        s5.initStyle(StageStyle.UTILITY);
        s1.show();
        s2.show();
        s3.show();
        s4.show();
        s5.show();
        Platform.exit();

    }
}
