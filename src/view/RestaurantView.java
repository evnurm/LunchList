package view;

import backend.DayMenu;
import backend.LunchOption;
import backend.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.io.IOException;

/**
 * Created by evnurm on 17.7.2017.
 */
public class RestaurantView extends VBox {

    private Restaurant res;
    @FXML public Label resName;
    @FXML public VBox optionsContainer;

    public RestaurantView(Restaurant restaurant, int dayIdx){


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("RestaurantView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        res = restaurant;

        resName.setText(res.getName());

        DayMenu[] menus = res.getDayMenus();

        if(menus.length != 0){

            DayMenu dayMenu = menus[dayIdx];
            if(dayMenu.getLunchOptions().length != 0){
                for (LunchOption lo : dayMenu.getLunchOptions()) {
                    LunchOptionContainer loc = new LunchOptionContainer(lo);
                    optionsContainer.getChildren().add(loc);
                }
            } else {
                optionsContainer.getChildren().add(new Label("Ravintola on suljettu."));
            }

        } else {
            optionsContainer.getChildren().add(new Label("Ruokalistaa ei kyetty noutamaan."));
        }
    }
}
