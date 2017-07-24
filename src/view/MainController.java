package view;

import backend.Restaurant;
import backend.Restaurants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Valtteri on 16.7.2017.
 */

public class MainController extends VBox implements Initializable {


    public static Restaurant[] restaurants = Restaurants.getRestaurants();

    @FXML private HBox navbar;
    @FXML private GridPane mainContainer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for(int i = 0; i < 7; i++){
            navbar.getChildren().add(new DayButton(weekdays[i], i));
        }

        displayMenus(0);
    }

    /** Loads the menus for the given day into the UI.*/
    public void displayMenus(int day){
        mainContainer.getChildren().clear();

        for(int i = 0; i < restaurants.length; i++){
            RestaurantView rw = new RestaurantView(restaurants[i], day);

            int l = restaurants.length;

            mainContainer.setConstraints(rw,i%(l-1),i/(l-1));
            mainContainer.getChildren().add(rw);
        }
    }

}
