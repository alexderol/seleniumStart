package Day10;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFDialogsheet;
import org.junit.Assert;
import org.junit.Test;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C2_ApachePoiTask {
    @Test
    public  void apachePoiTask() throws IOException {
//        Add the excel file on the resources folder.
//        Open the file.
//        Open the workbook using file input stream.
//        Open the first worksheet.
//        Go to first row.
//        Go to first cell on that first row and print.

        String path = "src\\test\\java\\resources\\excelfile (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheetAt(0);
        Row sheet1row1 = sheet1.getRow(0);
        Cell row1cell1 = sheet1row1.getCell(0);

        System.out.println(row1cell1);

//        Go to second cell on that first row and print.
//        Go to 2nd row first cell and assert if the data equal to Russia.

        Cell row1cell2 = sheet1row1.getCell(1);
        Row sheet1Row2 = sheet1.getRow(1);
        Cell row2Cell1 = sheet1Row2.getCell(0);
        System.out.println("row1cell2 = " + row1cell2);
        Assert.assertEquals("Rusya", row2Cell1.toString());
//        Go to 3rd row 2nd cell-chain the row and cell.
        Cell row3Cell2 = sheet1.getRow(2).getCell(1);
        System.out.println("row3Cell2 = " + row3Cell2);
//        Find the number of used row.
        System.out.println("sheet1.getPhysicalNumberOfRows() = " + sheet1.getPhysicalNumberOfRows());// satır sayısını direk veriri
        System.out.println("sheet1.getLastRowNum() = " + sheet1.getLastRowNum());// son satırın indeksini verir
//        Print country, area key value pairs as map object.
        int totalRows = sheet1.getPhysicalNumberOfRows();
        Map<String, String> countryList = new HashMap<>();

        for (int row = 1; row < totalRows; row++) {
            String country = sheet1.getRow(row).getCell(0).toString();

            // her satırdaki ülkeyi yazdırdık
            System.out.println((row + 1) + " satir = " + country);
            String area = sheet1.getRow(row).getCell(1).toString();/// satır sütun hücre olarak düşünü olayı

            System.out.println("country = "+country+ " Area = "+area);

            countryList.put(country,area);//mapa attık
            System.out.println("countryList = " + countryList);
        }


    }


}
