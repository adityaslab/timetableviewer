package ttviewer.ui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ttviewer.reader.ClassInfo;
import ttviewer.reader.SpreadsheetReader;

import java.util.ArrayList;
import java.util.HashMap;

public class ConfigController {
    @FXML
    private ComboBox<String> comb;
    public static String[] batches={"CS29","CS23","CS211","CS25","CS22","CS210","CS28","CS26","CS24","CS21","CS27"};

    @FXML
    private Button b0, b1, b2, b3, b4;

    @FXML
    public Label l0, l1, l2, l3, l4;
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

        ArrayList<Integer> arr=new ArrayList<>();
        for(int u=9;u<17;u++){
            if(a==null) {
                System.out.println("It is sunday");
                break;
            }
            ClassInfo temp=a.get(u);
            if(temp==null)
                continue;
            System.out.println(temp.toString());
            arr.add(temp.getTime(u));
        }
        //b0.setText((a.get(arr.get(0))).toString());
        System.out.println("array is"+arr);
        Button[] barray={b0,b1,b2,b3,b4};
        Label[] larray={l0,l1,l2,l3,l4};
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
            //if((a.get(arr.get(i)))==null)
            //    continue;
            barray[i].setText((a.get(arr.get(i))).toStr());
            String pre="",suff;
            if(arr.get(i)<10)
                pre="0";
            if(arr.get(i)<12)
                suff="AM";
            else
                suff="PM";
            larray[i].setText(pre+""+arr.get(i)+":00 "+suff);
        }
        //ClassInfo pr=a.get(9);
        //b0.setText(print.toString());
    }
}
