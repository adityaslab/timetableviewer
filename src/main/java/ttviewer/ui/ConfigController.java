package ttviewer.ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ConfigController {
    @FXML
    private ComboBox<String> comb;
    public static String[] batches={"CS29","CS23","CS211","CS25","CS22","CS210","CS28","CS26","CS24","CS21","CS27"};

    @FXML
    public void initialize() {
        comb.setItems(FXCollections.observableArrayList(batches));
    }

    public String getBatch(){
        return comb.getValue();
    }


    @FXML
    private void bPress(){
        String ab=comb.getValue();
        System.out.println(ab);
    }
}
