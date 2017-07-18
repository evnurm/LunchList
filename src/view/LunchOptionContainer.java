package view;

import backend.LunchOption;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class LunchOptionContainer extends VBox {

    public LunchOptionContainer(LunchOption lo){

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("lunchOptionContainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }


        for(String component: lo.getComponents()){
            this.getChildren().add(new Label(component));
        }

    }


}
