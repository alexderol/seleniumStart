package Day03_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice {
    //    Create the driver with BeforeClass and make it static inside the class.
//    Go to http://www.google.com
// 1   Type "Green Mile" in the search box and print the number of results.
// 2   Type "Premonition" in the search box and print the number of results.
// 3   Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
//    Close with AfterClass.
    static WebDriver driver;

    @BeforeClass
    public static void creatDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();

    }

    @Test
    public void test1() {
        driver.get("https://google.com");
        WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        search.sendKeys("Green Mile"+ Keys.ENTER);
        String result=driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println("result = " + result);
    }
    @Test
    public void test2() {
        driver.get("https://google.com");
        WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        search.sendKeys("Premonition"+ Keys.ENTER);
        WebElement result= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("result.getText() = " + result.getText());
    }
    @Test
    public void test3() {
        driver.get("https://google.com");
        WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf']"));
        search.sendKeys("The Curious Case of Benjamin Button"+ Keys.ENTER);
        WebElement result= driver.findElement(By.id("result-stats"));
        System.out.println("result.getText() = " + result.getText());
    }



}
