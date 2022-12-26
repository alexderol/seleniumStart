package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomWork {
@Test
    public void test1(){
        //https://id.heroku.com/login sayfasına gidiniz.
//Bir mail adresi giriniz.
//Bir password giriniz.
//Login butonuna tıklayınız.
//"There was a problem with your login." text görünür ise "Kayıt Yapılamadı" yazdırınız.
//Eğer yazı görünür değilse "Kayıt Yapıldı" yazdırınız.
//Tüm sayfaları kapatınız.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://id.heroku.com/login");
        driver.findElement(By.cssSelector("input[id=\"email\"]")).sendKeys("ebikgabik@gmail.com");
        driver.findElement(By.cssSelector("input[id=\"password\"]")).sendKeys("190787");
        driver.findElement(By.cssSelector("button[name=\"commit\"]")).click();
        WebElement element = driver.findElement(By.xpath("//div[.='There was a problem with your login.']"));

        Assert.assertTrue(element.isDisplayed());


    }
    @Test
    public void test2(){
        //Navigate to https://testpages.herokuapp.com/styled/index.html
        // Click on Calculate under Micro Apps.
        // Type any number in the first input.
        // Type any number in the second input.
        // Click on Calculate.
        // Get the result.
        // Print the result.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//a[@id=\"calculatetest\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"number1\"]")).sendKeys("45");
        driver.findElement(By.xpath("//input[@id=\"number2\"]")).sendKeys("55");
        driver.findElement(By.xpath("//input[@id=\"calculate\"]")).click();
        WebElement result = driver.findElement(By.xpath("//span[@id=\"answer\"]"));
        System.out.println("result = " + result);


    }

}
