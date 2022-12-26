package Day05_LocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C02_Task {
    //https://www.teknosa.com/ adresine gidiniz.
// Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
// Sonuç sayısını yazdırınız.
// Çıkan ilk ürüne tıklayınız.
// Sepete ekleyiniz.
// Sepetime gite tıklayınız.
// Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
// Alışverişi tamamlayınız.
// Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
// Driver'ı kapatınız.
    WebDriver driver;

    @Before

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.teknosa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        WebElement arama = driver.findElement(By.name("s"));
        arama.sendKeys("oppo" + Keys.ENTER);

        WebElement sonuc = driver.findElement(By.className("plp-info"));
        System.out.println("sonuc = " + sonuc);

        WebElement ilkUrun = driver.findElement(By.className("prd-link"));
        ilkUrun.click();

        WebElement sepeteEkle = driver.findElement(By.xpath("//button[@id=\"addToCartButton\"]"));
        sepeteEkle.click();

        WebElement sepeteGit = driver.findElement(By.xpath("//a[@class=\"btn btn-secondary\"]"));
        sepeteGit.click();

        WebElement siparisOzet = driver.findElement(By.xpath("//div[@class=\"cart-sum-body\"]"));
        System.out.println("siparisOzet = " + siparisOzet.getText());

        WebElement tamamlaButton = driver.findElement(By.partialLinkText("Alışverişi Tamamla"));
        tamamlaButton.click();

        WebElement hosgeldiniz = driver.findElement(By.xpath("//div[@class=\"lrp-title\"]"));
        System.out.println("hosgeldiniz.getText() = " + hosgeldiniz.getText());


    }
}
