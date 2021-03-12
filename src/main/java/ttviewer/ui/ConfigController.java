package ttviewer.ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ttviewer.reader.ClassInfo;
import ttviewer.reader.SpreadsheetReader;

import java.util.HashMap;

public class ConfigController {
    @FXML
    private ComboBox<String> comb;
    public static String[] batches={"CS29","CS23","CS211","CS25","CS22","CS210","CS28","CS26","CS24","CS21","CS27"};

    @FXML
    public Button b0, b1, b2, b3, b4;

    @FXML
    public TextField path;

    @FXML
    public void initialize() {
        comb.setItems(FXCollections.observableArrayList(batches));
    }


    @FXML
    private void bPress(){

        String ab=comb.getValue();
        System.out.println(ab);
        String p=path.getText();
        HashMap<Integer, ClassInfo> a=SpreadsheetReader.mainfunc(ab+" "+p);
//        if(a==null)
//            System.out.println("wrong path to spreadsheet");
        for(int u=9;u<17;u++){
            ClassInfo temp=a.get(u);
            if(temp==null)
                continue;
            System.out.println(temp.toString());
        }
        //ClassInfo pr=a.get(9);
        //b0.setText(print.toString());

    }
}
