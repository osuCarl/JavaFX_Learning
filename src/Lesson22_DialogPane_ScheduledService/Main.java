package Lesson22_DialogPane_ScheduledService;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: skyblue;");

        Button button = new Button("click to show dialog");
        an.getChildren().add(button);
        AnchorPane.setTopAnchor(button, 100.0);
        AnchorPane.setLeftAnchor(button, 100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFx");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.show();


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DialogPane dialogPane = new DialogPane();
                dialogPane.setHeaderText("this is HeaderText");
                dialogPane.setContentText("this is ContentText");
                dialogPane.getButtonTypes().add(ButtonType.APPLY);
                dialogPane.getButtonTypes().add(ButtonType.CLOSE);

                Button close = (Button)dialogPane.lookupButton(ButtonType.CLOSE);
                Button apply = (Button)dialogPane.lookupButton(ButtonType.APPLY);

                ImageView im = new ImageView(new Image("favicon.png"));
                im.setFitWidth(20);
                im.setFitHeight(20);
                dialogPane.setGraphic(im);

                dialogPane.setExpandableContent(new Text("more information"));
                dialogPane.setExpanded(false);

                Scene sc = new Scene(dialogPane);
                Stage stage = new Stage();
                stage.setScene(sc);
                stage.initOwner(primaryStage);
                stage.setIconified(false);
                stage.setResizable(false);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setTitle("pop window");
                stage.show();


                apply.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println("clicked apply");
                    }
                });
                close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        stage.close();
                    }
                });
                //multitask
                myScheduledService my = new myScheduledService(dialogPane, stage);
                my.setDelay(Duration.millis(0));
                my.setPeriod(Duration.millis(1000));
                my.start();
            }
        });
    }
}


class myScheduledService extends ScheduledService<Integer> {
    int i = 5;
    private final DialogPane di;
    private final Stage stage;
    public myScheduledService(DialogPane di, Stage stage) {
        this.di = di;
        this.stage = stage;
    }
    @Override
    protected Task<Integer> createTask() {

        return new Task<Integer>(){

            @Override
            protected Integer call() throws Exception {
                //this is not JavaFX Application Thread, can't update UI
                //this is a new Thread so that complicated tasks can be assigned here
                System.out.println("call() = " + Thread.currentThread().getName());
                return i--;
            }

            @Override
            protected void updateValue(Integer value) {
                //this is JavaFX Application Thread, update UI here
                //param is the return value of call()
                System.out.println("updateValue() = " + Thread.currentThread().getName());
                System.out.println("value = " + value);

                if(value > 0) {
                    myScheduledService.this.di.setContentText("This window will automatically close in: " + value);
                }else {
                    myScheduledService.this.stage.close();
                    myScheduledService.this.cancel();
                }
            }
        };
    }
}
