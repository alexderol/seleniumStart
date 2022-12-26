package Day04_LocatorPractice;

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

public class C02_CSS_Selector {
    //http://the-internet.herokuapp.com/add_remove_elements/
// Click on the "Add Element" button 100 times.
// Write a function that takes a number, and clicks the "Delete" button.
// Given number of times, and then validates that given number of buttons was deleted.
// 1. Method: createButtons(100)
// 2. Method: DeleteButtonsAndValidate()
    WebDriver driver;
    @Before

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        creatElement(100);
       deleteButtonsAndValidate(20);


    }
    public void creatElement(int amount){
        WebElement add = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < amount; i++) {
            add.click();
        }
    }

    public void deleteButtonsAndValidate(int amount){
        List<WebElement> listOfDeleetButtons = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silinmedenOncekiSayı= listOfDeleetButtons.size();
        for (int i = 0; i < amount; i++) {
            listOfDeleetButtons.get(i).click();
        }

        List<WebElement> listAfter = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int silindiktenSonrakiSayı= listAfter.size();

        Assert.assertEquals(silinmedenOncekiSayı-amount,silindiktenSonrakiSayı);




    }




}
