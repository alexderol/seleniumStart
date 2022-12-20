package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E04 {

    //youtube git game of throne dinle
    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://youtube.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearsDown() throws InterruptedException {
        Thread.sleep(7000);
        driver.quit();
    }
    @Test
    public void test(){
       WebElement search = driver.findElement(By.xpath("//input[@id=\"search\"]"));
       search.sendKeys("Game of Thrones Cello Cover - Break of Reality");
       driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
       driver.findElement(By.xpath("//*[.='Game of Thrones Cello Cover - Break of Reality']")).click();
    }

}
