package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Bos {
    @Test
    public void test() {

        //git->https://amazon.com
        //arama butonuna "noel tree"+enter
        //açılan sayfalardan ikinci sayfa git
        //begendigin noel agacını sec
        //sepete ekle
        //sepete git
        //hesap girişi yap
        //ödeme sa

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebElement arama = driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("noel tree" + Keys.ENTER);

        WebElement enpahalısı = driver.findElement(By.xpath("//*[.='$50 to $100']"));
        enpahalısı.click();


        WebElement safya2 = driver.findElement(By.xpath("//a[@aria-label=\"Go to page 2\"]"));
        safya2.click();

        WebElement secim = driver.findElement(By.xpath("(//div[@class=\"a-section aok-relative s-image-square-aspect\"])[1]"));
        secim.click();

        WebElement sepeteEkle = driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]"));
        sepeteEkle.click();





    }
}
