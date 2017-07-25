package view;

import backend.Restaurant;
import backend.Restaurants;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Calendar;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Valtteri on 16.7.2017.
 */

public class MainController extends VBox implements Initializable {

    private Calendar cal = Calendar.getInstance();

    public static Restaurant[] restaurants = Restaurants.getRestaurants();

    @FXML private HBox navbar;
    @FXML private GridPane mainContainer;

    public static DayButton active;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] weekdays = {"Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai", "Lauantai", "Sunnuntai"};

        for(int i = 0; i < 7; i++){
            DayButton db = new DayButton(weekdays[i],i);
            db.setId("db"+i);
            navbar.getChildren().add(db);
        }

        int dayIndex = cal.get(Calendar.DAY_OF_WEEK) - 2;
        if(dayIndex < 0){
            dayIndex = 6;
        }

        active = (DayButton) navbar.lookup("#db"+dayIndex);
        displayMenus(dayIndex);



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
