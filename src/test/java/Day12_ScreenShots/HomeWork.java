package Day12_ScreenShots;

import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeWork extends BaseTest {
    @Test
    public void test1(){
//        Go to URL: https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");
//        Print the entire table
        WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));
//        Print All Rows
        List<WebElement> rowlist = table.findElements(By.xpath(".//tr"));
        rowlist.forEach(t-> System.out.println(t.getText()));
//        Print Last row data only
       WebElement lastRow= rowlist.get(rowlist.size()-1);
        System.out.println("lastRow = " + lastRow.getText());
//        Print column 5 data in the table body
        List<WebElement> colum5list = table.findElements(By.xpath(".//tr//td[5]"));
        colum5list.forEach(t-> System.out.println(t.getText()));
//        Write a method that accepts 2 parameters
        neMethodu(3,4);
//        parameter 1 = row number
//        parameter 2 = column number
//        printData(3,4); => prints
//        parameter 3 = table id
//        printData(3,4,"table1") => prints data in 3rd row 4th Column with table id
        printData(3,4,"table1");


    }

    private void printData(int r, int c, String id) {
        WebElement cell= driver.findElement(By.id(id)).findElement(By.xpath(".//tr["+r+"]//td["+c+"]"));
        System.out.println(cell.getText());
       // WebElement printData = driver.findElement(By.id("table1")).findElement(By.xpath(".//tr["+r+"]//td["+c+"]"));


    }

    private void neMethodu(int r, int c) {

        WebElement Istenen = driver.findElement(By.xpath(".//tr["+r+"]//td["+c+"]"));
        System.out.println("Istenen = " + Istenen.getText());
    }
@Test
    public void test2(){
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        WebElement table = driver.findElement(By.id("countries"));
       //baskentbul("Angola");
    //WebElement table = driver.findElement(By.cssSelector("[id=\"countries\"]"));
    List<WebElement> datalar = table.findElements(By.xpath(".//tr//td[3]"));
    List<WebElement> ulkeList = table.findElements(By.xpath(".//tr//td[2]"));


    Map<String,String> ulkeBaskent =new HashMap<>();
    for (int i = 1; i <= datalar.size(); i++) {
        ulkeBaskent.put(ulkeList.get(i).getText(), datalar.get(i).getText());
    }
    System.out.println(ulkeBaskent.get("Angola"));

}

    private void baskentbul(String ulke) {
        WebElement table = driver.findElement(By.id("countries"));
        List<WebElement> datalar = table.findElements(By.xpath(".//tr//td[3]"));
        List<WebElement> ulkeList = table.findElements(By.xpath(".//tr//td[2]"));

        Map<String,String> ulkeBaskent =new HashMap<>();
        for (int i = 1; i <= datalar.size(); i++) {
            ulkeBaskent.put(ulkeList.get(i).getText(),datalar.get(i).getText());
        }
        System.out.println(ulkeBaskent.get(ulke));


    }


}
