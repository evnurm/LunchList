package view;

import backend.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Valtteri on 16.7.2017.
 */

public class MainController implements Initializable {


    @FXML private HBox navbar;
    @FXML public VBox mainContainer;

    // array holding the codes for Amica restaurants.
    private String[] amica = {"0190", "0199", "3579"};

    private static int dayIndex = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AmicaDecoder ad = new AmicaDecoder();

        try {

            for(String code: amica){
                Restaurant res = ad.parseJSON("fi",code);
                mainContainer.getChildren().add(new RestaurantView(res,dayIndex));
            }

            Restaurant cs = new SodexoDecoder().parseJSON("fi","142");
            mainContainer.getChildren().addAll(new RestaurantView(cs,3));

        } catch(Exception e){e.printStackTrace();}

    }

    /** Sets the index of the day whose menus will be displayed.*/
    public static Boolean setDayIndex(int idx){
        if(idx >= 0 && idx <= 6){
            dayIndex = idx;
            return true;
        } else {
            return false;
        }
    }
}
