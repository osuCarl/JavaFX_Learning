package Lesson13_AnchorPane;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");

        AnchorPane ap= new AnchorPane();
//        b1.setLayoutX(100);
//        b1.setLayoutY(100);
        //Parents take over child, similar to response layout in html
//        AnchorPane.setTopAnchor(b1, 10.0);
//        AnchorPane.setLeftAnchor(b1, 10.0);
//        AnchorPane.setRightAnchor(b1, 10.0);
//        AnchorPane.setBottomAnchor(b1, 10.0);

//        ap.setPadding(new Insets(10, 20, 30, 40));

//        ap.getChildren().addAll(b1);

        Group g1 = new Group();
        Group g2 = new Group();
        g1.getChildren().addAll(b1, b2);
        g2.getChildren().addAll(b3, b4);

        ap.getChildren().addAll(g1, g2);

        AnchorPane.setTopAnchor(g1, 100.0);
        AnchorPane.setLeftAnchor(g1, 100.0);
        //the below layout is related to b1's direct father: g1
        //b1's grandfather ap can't control b1
        b1.setLayoutX(100);
        b1.setLayoutY(100);

        AnchorPane.setTopAnchor(g2, 200.0);
        AnchorPane.setLeftAnchor(g2, 200.0);


        ap.setStyle("-fx-background-color: skyblue;");
        ap.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("click");
            }
        });

        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
