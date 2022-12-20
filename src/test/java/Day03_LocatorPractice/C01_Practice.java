package Day03_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
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

//    Go to https://www.linkedin.com/
//    When we write an e-mail without the @ sign in the e-mail box and press enter.
//    Let's test the "Invalid email address" warning.
    WebDriver driver;

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://linkedin.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @After
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void xPathPractice() throws InterruptedException {
        WebElement email =driver.findElement(By.xpath("//input[@id='session_key']"));
        email.sendKeys("ueauiauia.com"+ Keys.ENTER);
        String uyarı= driver.findElement(By.xpath("//p[@class='alert-content']")).getText();

        Thread.sleep(3000);

        Assert.assertTrue(uyarı, email.isDisplayed());


    }











}
