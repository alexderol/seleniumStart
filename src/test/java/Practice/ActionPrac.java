package Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.security.Key;

public class ActionPrac extends BaseTest {
    @Test
    public void amazon() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement hello = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hello).perform();
        WebElement sign = driver.findElement(By.xpath("(//a[@data-nav-role=\"signin\"])[2]"));
        sign.click();
        WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
        email.sendKeys("45gereksiz@gmail.com"+Keys.ENTER);
        actions.sendKeys("ders4545").keyDown(Keys.TAB).keyDown(Keys.TAB).keyDown(Keys.ENTER).perform();
        Thread.sleep(3000);

    }
}
