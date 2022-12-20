package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E06_automationEx {
    //getBrowser
    static WebDriver driver;
    @Before
    public void luncBorwser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    //home page visiable?
    @Test
    public void test1(){
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

    }
    //click prduct button and visiable?
    @Test
    public void test2(){
        WebElement prductBttn = driver.findElement(By.xpath("//a[text()=' Products']"));
        prductBttn.click();
       //  driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
        WebElement allPrdct = driver.findElement(By.xpath("//img[@src='/static/images/shop/sale.jpg']"));
        Assert.assertTrue(allPrdct.isDisplayed());
        //go to searchbox and click searhc button



        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Tshirt");
       driver.findElement(By.xpath("//button[@id=\"submit_search\"]")).click();
        WebElement searchResult= driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchResult.isDisplayed());
    }
    @After
    public void tearsDown(){
        driver.quit();
    }






}
