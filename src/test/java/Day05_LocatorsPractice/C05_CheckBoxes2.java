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

public class C05_CheckBoxes2 {
    //    Go to URL: https://demoqa.com/
//    Click on Elements.
//    Click on Checkbox.
//    Verify if Home checkbox is selected.
//    Verify that "You have selected" is visible.

    WebDriver driver;
    @Before

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        WebElement elementClick= driver.findElement(By.xpath("(//div[@class=\"avatar mx-auto white\"])[1]"));
        elementClick.click();

        WebElement checkBox= driver.findElement(By.xpath("//span[@class=\"text\"]"));
        checkBox.click();
        if (!checkBox.isSelected()){
            checkBox.click();
        }
        WebElement result = driver.findElement(By.xpath("//div[@id=\"result\"]"));
        Assert.assertTrue(result.isDisplayed());

    }
    }


