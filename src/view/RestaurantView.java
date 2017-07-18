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

    public RestaurantView(Restaurant restaurant){


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

        DayMenu monday = res.getDayMenus()[0];
        for(LunchOption lo: monday.getLunchOptions()){
            LunchOptionContainer loc = new LunchOptionContainer(lo);
            optionsContainer.getChildren().add(loc);
        }

    }
}
