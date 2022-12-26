package Day10;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C1_ExcelMethod {
    public static void main(String[] args) throws IOException {

        String path = "src\\test\\java\\resources\\excelfile (1).xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet1 = workbook.getSheetAt(0);
        Row row1 = sheet1.getRow(0);
        Cell cell1 = row1.getCell(0);

        System.out.println("Cell1 = "+ cell1.toString().toLowerCase());


    }
}
