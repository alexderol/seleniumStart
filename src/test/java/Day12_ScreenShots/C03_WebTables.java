package Day12_ScreenShots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03_WebTables extends BaseTest {
    @Test
    public void webTableExample(){
//        Go to URL: http://demo.guru99.com/test/web-table-element.php
//        To find third row of table
//        To get 3rd row's 3nd column data
//        Get all the values of a Dynamic Table
        driver.get("http://demo.guru99.com/test/web-table-element.php");
//tablo
        WebElement table = driver.findElement(By.className("dataTable"));

        WebElement row3 = table.findElement(By.xpath("(.//tr)[3]"));
        //table da xpath "." kullanarak sadece table da arama yapmak istediğimizi söyledik
        System.out.println("row3.getText() = " + row3.getText());
//webelementin altında arama yaparken xpath . koymalıyım yoksa noktasız olarak koyarsak tüm
// sayfanın yazılanına gider aşağıda ki gibi sayfadaki td 3 e gider ancak aşağıdaki gibi yaparsak sadece row3 deki td 3 e gider
        WebElement row3Cell3 = row3.findElement(By.xpath(".//td[3]"));
        System.out.println("row3Cell3.getText() = " + row3Cell3.getText());

        int satirSayisi = table.findElements(By.xpath(".//tr")).size();
        int sutunSayisi = row3.findElements(By.xpath(".//td")).size();

        for (int i=1;i<=satirSayisi;i++){
            for (int j = 1; j <=sutunSayisi ; j++) {
                //her satınırn sütunu
                By locator= By.xpath(".//tr["+i+"]//td["+j+"]");
                WebElement tableData = table.findElement(locator);

                System.out.print(tableData.getText()+" ");
            }
            System.out.println();
        }


    }




}
