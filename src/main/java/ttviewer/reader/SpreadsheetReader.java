package ttviewer.reader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;


import java.io.IOException;
import java.sql.Time;
import java.util.*;

public class SpreadsheetReader {
    public static HashMap<Integer,String> classes=new HashMap<>();
    public static String[] day={"Sat","Sun","Mon","Tue","Wed","Thu","Fri"};
    public static int dayOfWeek, hour, min;
    /*
    This function finds the cell of day asked and cell of subsequent day and return them in an ArrayList
    required day is passed as an integer
     */
    public static ArrayList<HSSFCell> findDay(HSSFSheet sheet,String[] day,int i){
        ArrayList<HSSFCell> ar= new ArrayList<>();
        int totalrow=sheet.getPhysicalNumberOfRows();
        int j=0;
        for(;j<totalrow;j++){
            HSSFRow row=sheet.getRow(j);
            if(row==null)
                continue;
            HSSFCell cell=row.getCell(0);
            String cellval=cell.getStringCellValue();
            if(day[i].equals(cellval)){
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

    public static void updateValues(){
        Calendar calender=Calendar.getInstance();
        dayOfWeek=calender.get(Calendar.DAY_OF_WEEK);
        hour=calender.get(Calendar.HOUR);
        min=calender.get(Calendar.MINUTE);
        System.out.println(hour+":"+min);
    }

    public static void main(String[] args){
        //loc here contains location of the timetable file
        //Sting loc=args[0]
        String loc="/home/thinkpad/Downloads/t.xls";
        String sem="BTECH 2 SEM";
        String batch="CS210";

        try (HSSFWorkbook wb=File2Workbook.readF(loc)){
            int sheetsno=wb.getNumberOfSheets();
            int i=0;
            for(;i<sheetsno;i++){
                String nm=wb.getSheetName(i);
                if(sem.equals(nm)){
                    break;
                }
            }
            updateValues();

            HSSFSheet sheet= wb.getSheetAt(i);
            ArrayList<HSSFCell> dayrow=findDay(sheet,day,dayOfWeek);



            for(int q=dayrow.get(0).getRowIndex();q<dayrow.get(1).getRowIndex();q++) {

                HSSFRow r=sheet.getRow(q);
                if(r==null) {
                    continue;

                }
                for(int rlhour=9, p = 1; p <= r.getLastCellNum(); p++){
                    HSSFCell c=r.getCell(p);
                    if(c==null)
                        continue;
                    String cellv=c.getStringCellValue();
                    if(cellv.toLowerCase().contains(batch.toLowerCase())){
                        classes.put(rlhour,cellv);
                    }
                    rlhour++;
                }



            }
            //printing values of hashmap
            for(int u=9;u<17;u++){
                System.out.println(u+", "+classes.get(u));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
