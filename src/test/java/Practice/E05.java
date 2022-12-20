package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E05 {
    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //sayfa açıldı mı kontrol et
        WebElement anasayfa= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(anasayfa.isDisplayed());
        //sign in e git user name gir
        WebElement sigIn = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        sigIn.click();
        WebElement signIniçi=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(signIniçi.isDisplayed());
        WebElement mailKutusu= driver.findElement(By.xpath("//input[@name='email']"));
        mailKutusu.sendKeys("erolldemir45@gmail.com");
        WebElement mailSifreKutusu = driver.findElement(By.xpath("//input[@name='password']"));
        mailSifreKutusu.sendKeys("1907");
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        WebElement loginOldunMu = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(loginOldunMu.isDisplayed());
        WebElement logOut = driver.findElement(By.xpath("//a[text()=' Logout']"));
        logOut.click();
        //tekrar ana sayfaya dönüldü mü kontrol
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        driver.quit();



    }
}
