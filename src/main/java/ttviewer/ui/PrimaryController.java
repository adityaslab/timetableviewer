package ttviewer.ui;

import java.io.IOException;
import javafx.fxml.FXML;
import ttviewer.ui.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("config");
    }
}
