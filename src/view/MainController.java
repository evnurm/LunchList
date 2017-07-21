package view;

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
    @FXML private VBox mainContainer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for(int i = 0; i < 7; i++){
            navbar.getChildren().add(new DayButton(weekdays[i], i));
        }

     mainContainer.getChildren().add(new MenusContainer(0));

    }

}
