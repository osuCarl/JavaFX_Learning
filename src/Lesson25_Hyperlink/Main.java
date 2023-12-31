package Lesson25_Hyperlink;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();

        Hyperlink link = new Hyperlink("www.oracle.com", new Button("website"));
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HostServices host = Main.this.getHostServices();
                host.showDocument(link.getText());
            }
        });

        box.getChildren().add(link);

        Scene scene = new Scene(box);
        primaryStage.setTitle("JavaFX");
        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(500);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
