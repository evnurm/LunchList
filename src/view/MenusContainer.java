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


        String[] amica = {"0190", "0199", "3579"};
        AmicaDecoder ad = new AmicaDecoder();

        try {

            for(String code: amica){
                Restaurant res = ad.parseJSON("fi",code);
                container.getChildren().add(new RestaurantView(res,day));
            }

            Restaurant cs = new SodexoDecoder().parseJSON("fi","142");
            container.getChildren().addAll(new RestaurantView(cs, day));

        } catch(Exception e){e.printStackTrace();}
    }
}
