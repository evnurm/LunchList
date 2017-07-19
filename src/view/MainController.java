package view;

import backend.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Valtteri on 16.7.2017.
 */

public class MainController implements Initializable {

    @FXML public VBox mainContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AmicaDecoder ad = new AmicaDecoder();

        try {
            Restaurant alvari = ad.parseJSON("fi", "0190");
            Restaurant cs = new SodexoDecoder().parseJSON("fi","142");
            mainContainer.getChildren().addAll(new RestaurantView(alvari), new RestaurantView(cs));

        } catch(Exception e){e.printStackTrace();}

    }
}
