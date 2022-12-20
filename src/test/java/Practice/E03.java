package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E03 {
    static WebDriver driver;

    @BeforeClass
    public static void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
//amazona git sepete ekle sepete git ödemeye çalış hatalı giriş yap ekrandaki hatayı sorgula
    @AfterClass
    public static void stop() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement searBar = driver.findElement(By.id("twotabsearchtextbox"));
        searBar.sendKeys("kids smart watches girls" + Keys.ENTER);
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
        driver.findElement(By.xpath("//span[@id=\"acrCustomerReviewText\"]")).click();
        ;
        driver.navigate().back();
        driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]")).click();
        driver.findElement(By.xpath("//a[@class=\"nav-a nav-a-2 nav-progressive-attribute\"]")).click();
        driver.findElement(By.name("proceedToRetailCheckout")).click();
        driver.findElement(By.xpath("//input[@id=\"ap_email\"]")).sendKeys("burayakadar geldik süper.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
        String kontrol="There was a problem";
        WebElement result= driver.findElement(By.xpath("//*[.='There was a problem']"));

        Assert.assertTrue(result.isDisplayed());


    }

}
