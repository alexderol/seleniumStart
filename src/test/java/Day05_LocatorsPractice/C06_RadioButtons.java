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

public class C06_RadioButtons {
    //    Go to URL:  https://www.facebook.com/
//    Click on Create an Account button.
//    Then click on the radio buttons.
    WebDriver driver;
    @Before

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        WebElement hesapOlustur = driver.findElement(By.xpath("//a[contains(@data-testid,'registration-form')]"));
        hesapOlustur.click();

        WebElement kadinRadio = driver.findElement(By.xpath("//input[@name=\"sex\" and @value='1']"));
        WebElement erkekRadio = driver.findElement(By.xpath("//input[@name=\"sex\" and @value='2']"));

        kadinRadio.click();
        erkekRadio.click();

        Assert.assertTrue(!kadinRadio.isSelected());
        Assert.assertTrue(erkekRadio.isSelected());


    }
}
