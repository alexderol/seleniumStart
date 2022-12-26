package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuE5 {
    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'New User Signup!' is visible
        6. Enter name and already registered email address
        7. Click 'Signup' button
        8. Verify error 'Email Address already exist!' is visible
         */
        driver.get("http://automationexercise.com");
        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]")).click();
        WebElement obj = driver.findElement(By.xpath("//*[.=\"New User Signup!\"]"));
        Assert.assertEquals("New User Signup!",obj.getText());
        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("ebik");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("ebik@gmail.com");
        WebElement button =  driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]"));
        button.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.=\"Email Address already exist!\"]")).isDisplayed());
        driver.quit();


    }
}
