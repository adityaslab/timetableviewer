package ttviewer.reader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class SpreadsheetReader {
    public static String[] day={"Sat","Sun","Mon","Tue","Wed","Thu","Fri"};
    /*
    This function finds the cell of day asked and cell of subsequent day and return them in an ArrayList
    required day is passed as an integer
     */
    public static ArrayList<HSSFCell> findDay(HSSFSheet sheet,String[] day,int i){
        ArrayList<HSSFCell> ar=new ArrayList<HSSFCell>();
        int totalrow=sheet.getPhysicalNumberOfRows();
        int j=0;
        for(;j<totalrow;j++){
            HSSFRow row=sheet.getRow(j);
            if(row==null)
                continue;
            HSSFCell cell=row.getCell(0);
            String cellval=cell.getStringCellValue();
            if(day[i].equals(cellval)){
                System.out.println("Its Wednesday today!!!");
                System.out.println(cell.getStringCellValue());
                ar.add(cell);
                break;

            }
        }

        for(;j<totalrow;j++) {
            HSSFRow row = sheet.getRow(j);
            if (row == null)
                continue;
            HSSFCell cell = row.getCell(0);
            String cellval = cell.getStringCellValue();
            if (day[i + 1].equals(cellval)) {
                System.out.println(cell.getStringCellValue());
                ar.add(cell);
                break;

            }
        }
        return ar;
    }


    public static void main(String[] args){
        //loc here contains location of the timetable file
        //Sting loc=args[0]
        String loc="/home/thinkpad/Downloads/t.xls";
        String sem="BTECH 2 SEM";

        try (HSSFWorkbook wb=File2Workbook.readF(loc)){
            int sheetsno=wb.getNumberOfSheets();
            int i=0;
            for(;i<sheetsno;i++){
                String nm=wb.getSheetName(i);
                if(sem.equals(nm)){
                    break;
                }
            }
            Calendar calender=Calendar.getInstance();
            int dayOfWeek=calender.get(Calendar.DAY_OF_WEEK);
            System.out.println(dayOfWeek);
            HSSFSheet sheet= wb.getSheetAt(i);
            ArrayList<HSSFCell> dayrow=findDay(sheet,day,dayOfWeek);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
