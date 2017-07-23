package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
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
       VBox mc = (VBox) getParent().getParent().lookup("#mainContainer");
        mc.getChildren().clear();
        mc.getChildren().add(new MenusContainer(idx));
    }





}
