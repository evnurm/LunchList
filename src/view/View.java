package view;/**
 * Created by Valtteri on 15.7.2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class View extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        try{
            primaryStage.setTitle("Lunch List");
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setScene(scene);
            primaryStage.show();


        } catch(Exception e){}
    }
}
