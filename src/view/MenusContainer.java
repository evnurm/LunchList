package view;

import backend.AmicaDecoder;
import backend.Restaurant;
import backend.SodexoDecoder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MenusContainer extends VBox{

    @FXML private VBox container;

    public MenusContainer(int day){

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MenusContainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        Restaurant[] restaurants = MainController.restaurants;

        for(Restaurant res: restaurants){
            container.getChildren().add(new RestaurantView(res,day));
        }

    }
}
