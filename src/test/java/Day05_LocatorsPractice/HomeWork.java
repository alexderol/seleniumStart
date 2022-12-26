package Day05_LocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HomeWork {

    //Go to URL: https://demoqa.com/radio-button
//Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.
//Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
    WebDriver driver;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/radio-button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        WebElement leftButton = driver.findElement(By.xpath("//label[@for=\"yesRadio\"]"));
        if (!leftButton.isSelected()) leftButton.click();
        WebElement leftResult = driver.findElement(By.xpath("//p[@class=\"mt-3\"]"));
        System.out.println("leftResult.getText() = " + leftResult.getText());


        WebElement midButton = driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]"));
        if (!midButton.isSelected()) midButton.click();
        WebElement midResult = driver.findElement(By.xpath("//p[@class=\"mt-3\"]"));
        System.out.println("midResult.getText() = " + midResult.getText());

        WebElement rightButton = driver.findElement(By.xpath("//label[@class=\"custom-control-label disabled\"]"));
        rightButton.click();
        Assert.assertFalse(rightButton.isSelected());


    }
/*
    @Test
    public void ftest() {
        driver.navigate().to("https://demoqa.com/radio-button");
        List<WebElement> radioLabels = driver.findElements(By.className("custom-control-label"));
        List<WebElement> radioButtons = driver.findElements(By.xpath("//*[@type='radio']"));
        for (int i = 0; i < radioButtons.size(); i++) {
            radioLabels.get(i).click();
            System.out.println(radioButtons.get(i).isSelected() ? "seçildi" : "SEÇİLMEDİ!!!");
            WebElement text = driver.findElement(By.className("text-success"));
            System.out.println("text.getText() = " + text.getText());
        }
    }
    */

}





