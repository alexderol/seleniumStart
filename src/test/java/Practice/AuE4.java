package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AuE4  {
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
        6. Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible
        9. Click 'Logout' button
        10. Verify that user is navigated to login page
         */
        driver.get("http://automationexercise.com");
        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();
        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys("ebik@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("1907");
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).isDisplayed());
        driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();






    }
}
