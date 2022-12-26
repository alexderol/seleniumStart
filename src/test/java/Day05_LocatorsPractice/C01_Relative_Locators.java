package Day05_LocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_Relative_Locators {

    // Go to http://www.bestbuy.com
// Verify that the page title contains "Best" Also, using Relative Locator.
// LogoTest  Verify if the BestBuy logo is displayed.
// mexicoLinkTest  Verify if the link is displayed.

    WebDriver driver;

    @Before

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.bestbuy.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        Assert.assertTrue(driver.getTitle().contains("Best"));

        //logo locaet ediliyor
        By logoLocator = RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[.='Hello!']"));//1.adım RelativeLocattor with ile By tagnamleri getir sonra onun üstünde byXpath ile yerini göster
        WebElement logo = driver.findElement(logoLocator);//2
        Assert.assertTrue(logo.isDisplayed());//3

        //mexico Link locaet edilip kontro ediliyor
        By mexicoLinkLocator = RelativeLocator.with(By.tagName("a")).toRightOf(By.xpath("//div[@lang='en']//a[@class='us-link']"));
        WebElement mexicoLink = driver.findElement(mexicoLinkLocator);
        Assert.assertTrue(mexicoLink.isDisplayed());


    }
}
