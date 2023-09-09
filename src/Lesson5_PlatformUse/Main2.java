package Lesson5_PlatformUse;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Platform.setImplicitExit(false);//set false means the application will not terminate even all windows are closed
        System.out.println(Platform.isSupported(ConditionalFeature.FXML));
        System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));
        primaryStage.show();
//        Platform.exit();
    }
}
