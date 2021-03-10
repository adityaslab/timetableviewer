package ttviewer.reader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SpreadsheetReader {
    /*
    This function reads the .xls spreadsheet file
     */
    public static void main(String[] args){
        //loc here contains location of the timetable file
        //Sting loc=args[0]
        String loc="/home/thinkpad/Downloads/t.xls";
        String sem="BTECH 2 SEM";
        String day="Mon";
        try (HSSFWorkbook wb=File2Workbook.readF(loc)){
            int sheetsno=wb.getNumberOfSheets();
            int i=0;
            for(;i<sheetsno;i++){
                String nm=wb.getSheetName(i);
                if(sem.equals(nm)){
                    System.out.println("this works");
                    break;
                }

            }
            HSSFSheet sheet= wb.getSheetAt(i);
            int totalrow=sheet.getPhysicalNumberOfRows();
            for(int j=0;j<totalrow;j++){
                HSSFRow row=sheet.getRow(j);
                if(row==null)
                    continue;
                HSSFCell cell=row.getCell(0);
                String cellval=cell.getStringCellValue();

                if(day.equals(cellval)){
                    System.out.println("Its tuesday today!!!");
                }

                int lastcelln=row.getLastCellNum();

            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
