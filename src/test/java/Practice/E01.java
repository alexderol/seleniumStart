package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E01 {
    WebDriver driver;

    @Before
    public void first() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test

    public void trendyolTest() {
        driver.get("https://trendyol.com");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("trendyol"));
    }

    @Ignore
    public void facebookTest() {
        driver.get("https://facebook.com");
        String pSrc = driver.getPageSource();
        Assert.assertFalse(pSrc.contains("sıradaki"));

    }

    @Test
    public void facebookImgTest() {
        driver.get("https://facebook.com");
        WebElement img = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
        Dimension dim = img.getSize();

        int w = dim.getWidth();
        int h = dim.getHeight();
        System.out.println(w+" <-W  H-> "+h);
        Assert.assertNull(img);



    }


    @After
    public void end() {
        driver.quit();
    }


}
