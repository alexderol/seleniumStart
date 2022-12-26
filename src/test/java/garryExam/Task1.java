package garryExam;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class Task1 extends BaseTest {
//*
//        1- https://www.amazon.com/ sayfasına gidelim.
//            2- Arama kutusunu locate edelim.
//            3- "Samsung headphones" ile arama yapalım.
//   4- Bulunan sonuç sayısını yazdıralım.
//            5- İlk ürünü tıklayalım.
//   6- Sayfadaki tüm ürün başlıklarını yazdıralım.
    @Test
    public void task1(){
        driver.get("https://www.amazon.com");
        WebElement searc = driver.findElement(By.id("twotabsearchtextbox"));
        searc.sendKeys("Samsung headphones", Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class=\"a-section a-spacing-small a-spacing-top-small\"])[1]"));
        System.out.println(sonuc.getText());
        WebElement ilk = driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]"));
        List<WebElement> ürünlist = driver.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
        ürünlist.forEach(t-> System.out.println(t.getText()));

    }


}
