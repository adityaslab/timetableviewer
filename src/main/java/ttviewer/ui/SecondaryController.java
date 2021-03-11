package ttviewer.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import ttviewer.ui.App;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}