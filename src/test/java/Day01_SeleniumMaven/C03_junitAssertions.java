package Day01_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_junitAssertions {

    //    Go to Amazon homepage.
//    Do the following tasks by creating 3 different test methods.
//    1- Test if the URL contains Amazon.
//    2- Test if the title does not contain Facebook.
//    3- Test that the Amazon logo appears in the upper left corner.

    WebDriver driver;



    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();//setproperty yerine
        driver= new ChromeDriver();

    }

    @After
    public void after(){
        driver.quit();


    }
    @Test
    public void urlTest(){
        driver.get("https://www.amazon.com");
        String url= driver.getCurrentUrl();
        Assert.assertTrue( "url 'amazon' içermiyor",url.contains("amazon"));//url amazon içeriyor mu true  or false
        // message kısmı test failed olursa fırlatacağı mesaj

    }

    @Test
    public void titleTest(){
        driver.get("https://www.amazon.com");
        String title= driver.getTitle();
        Assert.assertFalse( title.contains("Facebook"));//title Facebook içermiyor mu true  or false
    }@Test
    public void logoTest(){
        driver.get("https://amazon.com");
        WebElement element=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertNotNull(element);


    }















}
