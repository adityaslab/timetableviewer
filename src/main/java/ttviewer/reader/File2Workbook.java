package ttviewer.reader;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class File2Workbook{
    public File2Workbook(){}
    public static HSSFWorkbook readF(String file) throws IOException{
        try (FileInputStream xlsfile = new FileInputStream(file)) {
            return new HSSFWorkbook(xlsfile);
        }
    }
}
