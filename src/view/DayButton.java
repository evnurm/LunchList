package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.IOException;

/** Controller class for DayButton. */
public class DayButton extends Label {

    private String title;
    private int idx;

    public DayButton(String title, int index){

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("lunchOptionContainer.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        idx = index;
        this.title = title;
    }
    /** onClick handler for the DayButton. */
    public void click(){
        MainController.setDayIndex(idx);
    }





}
