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

import java.time.Duration;
import java.util.List;

public class C04_CheckBoxes {
   WebDriver driver;
    @Before

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        //    Go to https://the-internet.herokuapp.com/checkboxes

//    Locate the elements of checkboxes.
       /*
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));
        */
        List<WebElement>boxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));
        WebElement box1 = boxes.get(0);
        WebElement box2 = boxes.get(1);
        //    Then click on checkbox 1 if box is not selected.
        //    Then click on checkbox 2 if box is not selected.
        if(!box1.isSelected()){//box1 seçili değilse
            box1.click();
        }
        if(!box2.isSelected()){
            box2.click();
        }
//    Then verify that checkbox 1 is checked.
        Assert.assertTrue(box1.isSelected());
        Assert.assertTrue(box2.isSelected());


    }
}

