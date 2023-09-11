package Lesson15_setManaged_setVisible_setOpacity;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    static boolean isManaged = false;
    static boolean isVisible = false;
    static double opacityValue = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");

        Button b5 = new Button("b3.setManaged(false)");
        Button b6 = new Button("b3.setVisible(false)");
        Button b7 = new Button("b3.setOpacity(0)");

//        b3.setManaged(false);
//        b3.setVisible(false);
//        b3.setOpacity(0);

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: skyblue;");

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(b1,b2,b3,b4);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(b5,b6,b7);

        ap.getChildren().addAll(hbox, vbox);
        AnchorPane.setTopAnchor(vbox, 100.0);
        AnchorPane.setLeftAnchor(vbox, 20.0);

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setManaged(isManaged);
                new Print(hbox);
                if(isManaged) {
                    isManaged = false;
                    b5.setText("b3.setManaged(false)");
                }else {
                    isManaged = true;
                    b5.setText("b3.setManaged(true)");
                }
            }
        });
        b6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setVisible(isVisible);
                new Print(hbox);
                if(isVisible) {
                    isVisible = false;
                    b6.setText("b3.setVisible(false)");
                }else {
                    isVisible = true;
                    b6.setText("b3.setVisible(true)");
                }
            }
        });
        b7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b3.setOpacity(opacityValue);
                new Print(hbox);
                if(opacityValue == 0) {
                    opacityValue = 1;
                    b7.setText("b3.setOpacity(1.0)");
                }else {
                    opacityValue = 0;
                    b7.setText("b3.setOpacity(0.0)");
                }
            }
        });
    }
}

class Print {
    Print(HBox hbox) {
        System.out.println("Current children number in HBox = " + hbox.getChildren().size());
    }
}
