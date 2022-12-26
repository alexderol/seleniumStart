package Day08_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C03_ActionHover extends BaseTest {
    @Test
    public void hoverOver(){
        driver.get("https://amazon.com");
        WebElement accountsAndLists = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountsAndLists).click(driver.findElement(By.id("nav_prefetch_yourorders"))).perform();
        //moveToElement parametrenin ortasına gider click e ise parametresini verdik
        Assert.assertEquals("Amazon Sign-In",driver.getTitle());
    }
    @Test
    public void keybordAction() throws InterruptedException {
        driver.get("https://demoqa.com/auto-complete");
        WebElement input = driver.findElement(By.xpath("//div[@class='auto-complete__value-container css-1hwfws3']"));
        input.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys("y").
                keyUp(Keys.SHIFT).sendKeys("ou are").
                keyDown(Keys.SHIFT).sendKeys(" e").
                keyUp(Keys.SHIFT).sendKeys("xceptional").
                perform();
        Thread.sleep(5000);

    }

}
