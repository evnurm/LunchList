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

    // array holding the codes for Amica restaurants.
    private String[] amica = {"0190", "0199", "3579"};



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AmicaDecoder ad = new AmicaDecoder();

        try {

            for(String code: amica){
                Restaurant res = ad.parseJSON("fi",code);
                mainContainer.getChildren().add(new RestaurantView(res,3));
            }

            Restaurant cs = new SodexoDecoder().parseJSON("fi","142");
            mainContainer.getChildren().addAll(new RestaurantView(cs,3));

        } catch(Exception e){e.printStackTrace();}

    }
}
