package ttviewer.ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class TestController{
    @FXML
    private ComboBox<String> combi;
    @FXML
    private Label lab;

    public static String[] batches={"CS29","CS23","CS211","CS25","CS22","CS210","CS28","CS26","CS24","CS21","CS27"};
    @FXML
    public void initialize() {
        combi.setItems(FXCollections.observableArrayList(batches));
    }


    @FXML
    private void buttonPress(){
        System.out.println("Button pressed");
    }


}
