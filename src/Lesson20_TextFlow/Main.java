package Lesson20_TextFlow;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();

        Text t1 = new Text("text1");
        Text t2 = new Text("edvwvdwevewfv");
        Text t3 = new Text("123432151431");

//        t1.setStyle("-fx-font-size: 20px;-fx-fill: red;");
//        t2.setFont(Font.font("Helvetica", FontPosture.ITALIC, 40));
//        t3.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));

        TextFlow textFlow = new TextFlow();
//        textFlow.setStyle("-fx-background-color: skyblue;");
        //padding
//        textFlow.setPadding(new Insets(10));
        //alignment
//        textFlow.setTextAlignment(TextAlignment.CENTER);
        //line spacing
//        textFlow.setLineSpacing(20);

        textFlow.getChildren().addAll(t1,t2,t3, new Button("123"));

        Text t4 = new Text("qwertyu");
        TextFlow textFlow2 = new TextFlow();
        textFlow2.getChildren().add(t4);
        AnchorPane.setTopAnchor(textFlow, 100.0);
        AnchorPane.setLeftAnchor(textFlow, 100.0);
        an.getChildren().addAll(textFlow, textFlow2);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();

        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("This is AnchorPane width: " + newValue);
                System.out.println("This is TextFlow width: " + textFlow.getWidth());
            }
        });

        an.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                textFlow.setPrefWidth(newValue.doubleValue() - 100);
            }
        });
    }
}
