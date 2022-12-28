package Day11_ApachiPOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.BaseTest;

import java.io.*;

public class C2_WriteExcelTask extends BaseTest {
    @Test
    public void changeExcelData() throws IOException {
//        Create an object of File class to open xlsx file.
//        Create an object of FileInputStream class to read excel file.
//        Create an object of FileInputStream class to read excel file.
//        Creating workbook instance that refers to .xlsx file.
//        Creating a Sheet object.
//        Get all rows in the sheet.
//        Create a row object to retrieve row at index 3.
//        Create a cell object to enter value in it using cell Index.
//        Write the data in excel using output stream.

        String path = "src/test/java/resources/excelData.xlsx";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet informaitionData = workbook.getSheet("informationData");
        int totalRowsUsed = informaitionData.getLastRowNum() - informaitionData.getFirstRowNum();//son rowdan ilk rowu çıkarıp
        System.out.println("total rows ="+ totalRowsUsed);//11
        Row row5 = informaitionData.createRow(4);
        row5.createCell(0).setCellValue("erol");
        row5.createCell(1).setCellValue("Demir");
        row5.createCell(2).setCellValue("erol@gmail");
        row5.createCell(3).setCellValue("Erkek");
        row5.createCell(4).setCellValue("123456985522");
        row5.createCell(5).setCellValue("Adress");

        FileOutputStream fos = new FileOutputStream(path);//excel dosyasına buradakı değişiklleri yazdırmak için fileoutput yaptık
        workbook.write(fos);

        fis.close();
        fos.close();
        workbook.close();

        //burada for kullanarak diğer celleri doldur ödev bu olsun




    }
}
