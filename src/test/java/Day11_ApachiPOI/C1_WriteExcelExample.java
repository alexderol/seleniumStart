package Day11_ApachiPOI;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C1_WriteExcelExample extends BaseTest {
    @Test
    public void writeExcel () throws IOException {
//        Store the path of the file as string and open the file.
//        Open the workbook.
//                Open the first worksheet.
//                Go to the first row.
//        Create a cell on the 3rd column (2nd index) on the first row.
//        Write “POPULATION” on that cell.
//                Create a cell on the 2nd row 3rd cell(index2), and write data.
//        Create a cell on the 3rd row 3rd cell(index2), and write data.
//        Create a cell on the 4th row 3rd cell(index2), and write data.
//        Write and save the workbook.
//                Close the file.
//        Close the workbook.
//                Collaps
        String path = "src\\test\\java\\resources\\excelfile (1).xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet2 = workbook.getSheetAt(1);//ikinci sayfayı aççtık
        //ilk satır
        Row row1 = sheet2.getRow(0);

        Cell row1Cell3 = row1.createCell(2);//3. hücreye bir alan oluşturduk
        row1Cell3.setCellValue("POPULATION");//oluşturulan hücreye değerini yazdık artık 3 hücre population oldu
        sheet2.getRow(1).createCell(2).setCellValue("Rusyanin populasyonu");//
        sheet2.getRow(2).createCell(2).setCellValue("Cin populasyonu");//
        sheet2.getRow(3).createCell(2).setCellValue("ABD populasyonu");//
        //shetler obj olarak elimide şuan ama hala excel dosyasına yazılmadı...yazma işlemi aşağıdaki gibi yapıyoruz
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);//değişikler excel dosyasına yazıldı

        fileInputStream.close();//streamleri kapatıyoruz
        fileOutputStream.close();

        workbook.close();//workbooku da kapatıyoruz....









    }



}
