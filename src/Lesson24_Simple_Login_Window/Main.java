package Lesson24_Simple_Login_Window;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label l_name = new Label("Account: ");
        l_name.setStyle("-fx-font-size: 14px;");
        Label l_password = new Label("Password: ");
        l_password.setStyle("-fx-font-size: 14px;");

        TextField t_name = new TextField();
        PasswordField p_password = new PasswordField();

        t_name.setTooltip(new Tooltip("Please enter your account"));
        p_password.setTooltip(new Tooltip("Please enter your password"));

        t_name.setUserData("hello");
        p_password.setUserData("12345");

        Button login = new Button("Login");
        Button clear = new Button("Clear");

        GridPane gr = new GridPane();
        gr.setStyle("-fx-background-color: skyblue;");
        gr.setAlignment(Pos.CENTER);
        gr.setHgap(5);
        gr.setVgap(15);

        gr.add(l_name, 0, 0);
        gr.add(t_name, 1, 0);

        gr.add(l_password, 0, 1);
        gr.add(p_password, 1, 1);

        gr.add(clear, 0, 2);
        gr.add(login, 1, 2);
        GridPane.setMargin(login, new Insets(0,0,0,120));

        Scene scene = new Scene(gr);
        primaryStage.setScene(scene);
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login");
        primaryStage.show();



        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                t_name.setText("");
                p_password.setText("");
            }
        });
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = (String) t_name.getUserData();
                String password = (String) p_password.getUserData();

                if(name.equals(t_name.getText()) && password.equals(p_password.getText())) {
                    System.out.println("login successful");
                    MyWindow myWindow = new MyWindow(t_name.getText(), p_password.getText());
                    primaryStage.close();
                }else {
                    Text error = new Text("Invalid account or password!");
                    gr.add(error, 1,3);
                    //add animation
                    FadeTransition fade = new FadeTransition();
                    fade.setDuration(Duration.seconds(0.1));
                    fade.setNode(gr);
                    fade.setFromValue(0);
                    fade.setToValue(1);
                    fade.play();
                    System.out.println("login failed");
                }
            }
        });
    }
}


class MyWindow {
    private final Stage stage = new Stage();
    public MyWindow(String name, String password) {
        Text text = new Text("Account: " + name + " Password: " + password);

        BorderPane bor = new BorderPane();
        bor.setStyle("-fx-background-color: pink");

        bor.setCenter(text);

        Scene scene = new Scene(bor);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.setTitle("Login Successful");
        stage.show();
    }
}