package view;

import backend.Restaurant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.io.IOException;


/** Controller class for DayButton. */
public class DayButton extends VBox {

    private String title;
    private int idx;

    @FXML private Label dayName;

    public DayButton(String title, int index){

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DayButton.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        idx = index;
        dayName.setText(title);
  //      this.title = title;
    }
    /** onClick handler for the DayButton. */
    public void click(){
        GridPane grid = (GridPane) getParent().getParent().lookup("#mainContainer");
        Restaurant[] restaurants = MainController.restaurants;

        grid.getChildren().clear();


        for(int i = 0; i < MainController.restaurants.length; i++){
            RestaurantView rw = new RestaurantView(restaurants[i], idx);

            int l = restaurants.length;

            grid.setConstraints(rw, i % 3, i / 3);
            grid.getChildren().add(rw);

            MainController.active.dayName.setStyle("-fx-font-weight:normal;");
            dayName.setStyle("-fx-font-weight:bold;");
            MainController.active = this;
        }


    }





}
