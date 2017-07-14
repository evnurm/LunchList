package view;

/**
 * Created by evnva on 14.7.2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox vbox = new VBox();
        Label title = new Label("LunchList");
        vbox.getChildren().add(title);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
