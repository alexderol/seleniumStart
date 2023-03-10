package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Alerts {
    WebDriver driver;

    @Before

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void alerts() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        WebElement idInput = driver.findElement(By.name("cusid"));
        idInput.sendKeys("123456");
        driver.findElement(By.name("submit")).click();

        driver.switchTo().alert().accept();

    }
}
