package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuE6 {
    @Test
    public void test() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Contact Us' button
        5. Verify 'GET IN TOUCH' is visible
        6. Enter name, email, subject and message
        7. Upload file
        8. Click 'Submit' button
        9. Click OK button
        10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        11. Click 'Home' button and verify that landed to home page successfully
         */
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"col-sm-4\"]")).isDisplayed());
        driver.findElement(By.xpath("//i[@class=\"fa fa-envelope\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.=\"Get In Touch\"]")).isDisplayed());
        driver.findElement(By.xpath("//input[@data-qa=\"name\"]")).sendKeys("ebik");
        driver.findElement(By.xpath("//input[@data-qa=\"email\"]")).sendKeys("ebik@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa=\"subject\"]")).sendKeys("yenilendi");
        driver.findElement(By.xpath("//textarea[@data-qa=\"message\"]")).sendKeys("burası yeniden yapılandırılırken mesaj haznesi");

        driver.findElement(By.xpath("//input[@data-qa=\"submit-button\"]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@style=\"display: block;\" and @class='status alert alert-success']")).isDisplayed());
        driver.findElement(By.xpath("//i[@class=\"fa fa-home\"]")).click();
        Assert.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());



    }
}
