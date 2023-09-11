package Lesson18_GridPane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
        Button b5 = new Button("button5");
        Button b6 = new Button("button6");
        Button b7 = new Button("button7");
        Button b8 = new Button("button8");

        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: skyblue;");

        //set position of child
//        grid.add(b1, 0, 0);
        grid.add(b2, 1, 0);
        grid.add(b3, 2, 0);
        grid.add(b4, 3, 0);
        grid.add(b5, 0, 1);
        grid.add(b6, 1, 1);
        grid.add(b7, 2, 1);
        grid.add(b8, 3, 3);

        //set spacing
        grid.setHgap(10);
        grid.setVgap(10);
        //set padding
        grid.setPadding(new Insets(10));
        //set margin
//        GridPane.setMargin(b1, new Insets(10));
        //set alignment
        grid.setAlignment(Pos.CENTER);

        //another way to add child
//        GridPane.setConstraints(b1, 1, 1);
//        grid.getChildren().addAll(b1);

        //another way to add child
        GridPane.setColumnIndex(b1, 1);
        GridPane.setRowIndex(b1, 1);
        grid.getChildren().addAll(b1);

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();
    }
}
