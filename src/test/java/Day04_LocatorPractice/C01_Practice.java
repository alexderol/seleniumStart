package Day04_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Practice {
    //Navigate to website  https://testpages.herokuapp.com/styled/index.html
// Under the ORIGINAL CONTENTS
// Click on Alerts
// Print the URL
// Navigate back
// Print the URL
// Click on Basic Ajax
// Print the URL
// Enter value  20 and Enter
// And then verify Submitted Values is displayed open page
// Close driver.
    WebDriver driver;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

       @After
     public void tearDown(){
        driver.quit();
     }
     @Test
     public void teest1(){
        driver.findElement(By.xpath("//a[@id=\"alert\"]")).click();
        String Alerturl = driver.getCurrentUrl();
        System.out.println("Alerturl = " + Alerturl);
        driver.navigate().back();
        String backUrl = driver.getCurrentUrl();
        System.out.println("backUrl = " + backUrl);
        driver.findElement(By.xpath("//a[@id=\"basicajax\"]")).click();
        String basicAjaxurl = driver.getCurrentUrl();
        System.out.println("basicAjaxurl = " + basicAjaxurl);
        driver.findElement(By.xpath("//input[@id=\"lteq30\"]")).sendKeys("20" + Keys.ENTER);
        WebElement value = driver.findElement(By.xpath("//p[.=\"Submitted Values\"]"));
        Assert.assertTrue(value.isDisplayed());
    }
}
