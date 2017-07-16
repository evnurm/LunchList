package view;

import backend.AmicaDecoder;
import backend.DayMenu;
import backend.LunchOption;
import backend.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Valtteri on 16.7.2017.
 */
public class MainController implements Initializable {

    @FXML public ListView list;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AmicaDecoder ad = new AmicaDecoder();

        try {
            Restaurant res = ad.parseJSON("fi", "0190");

            for(DayMenu dm: res.getDayMenus()){
                for(LunchOption lo: dm.getLunchOptions()){
                    for(String component: lo.getComponents()){
                        list.getItems().add(new Label(component));
                    }
                }
            }

        } catch(Exception e){}

    }
}
