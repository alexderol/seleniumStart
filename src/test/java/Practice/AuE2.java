package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuE2 {
    @Test
    public void test2(){
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter correct email address and password
        7. Click 'login' button
        8. Verify that 'Logged in as username' is visible
        9. Click 'Delete Account' button
        10. Verify that 'ACCOUNT DELETED!' is visible
         */



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://automationexercise.com");
        String homeURL="https://automationexercise.com/";
        String actuelUrl=driver.getCurrentUrl();
        Assert.assertEquals(homeURL,actuelUrl);
        WebElement signUp = driver.findElement(By.className("fa fa-lock"));
        signUp.click();
        WebElement account= driver.findElement(By.xpath("//*[.=\"Login to your account\"]"));
        Assert.assertTrue(account.isDisplayed());
        WebElement userName= driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]"));
        userName.sendKeys("erolldemir45@gamail.com");
        WebElement pass= driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]"));
        pass.sendKeys("1907");
        WebElement loginButton = driver.findElement(By.xpath("//button[data-qa=\"login-button\"]"));
        loginButton.click();
        WebElement logged = driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]"));
        Assert.assertTrue(logged.isDisplayed());
        WebElement deleteButton = driver.findElement(By.xpath("//i[@class=\"fa fa-trash-o\"]"));
        deleteButton.click();
        WebElement deletedId = driver.findElement(By.xpath("(//*[.='Account Deleted!'])[1]"));
        Assert.assertTrue(deletedId.isDisplayed());



    }
}
