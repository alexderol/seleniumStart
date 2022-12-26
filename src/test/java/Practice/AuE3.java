package Practice;

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

public class AuE3 {
    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter incorrect email address and password
        7. Click 'login' button
        8. Verify error 'Your email or password is incorrect!' is visible
         */
        driver.get("http://automationexercise.com");
        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();
        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys("bualabula@gamil.com");
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("1452");
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@style=\"color: red;\"]")).isDisplayed());



    }
}
