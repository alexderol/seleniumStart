package Day09_Scroll_cookies_Files;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C1_ScrollActions extends BaseTest {

    @Test
    public void scrollPageUpDown() throws InterruptedException {
        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        actions.sendKeys(Keys.PAGE_UP).perform();

        actions.sendKeys(Keys.PAGE_UP).perform();

    }
    @Test
    public void scrollArrowUpDown() throws InterruptedException {
        driver.get("https://amazon.com");
        Actions actions = new Actions(driver);
//page up ile farkı arrow dah minnak hareketler yapar
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        actions.sendKeys(Keys.ARROW_DOWN).perform();

        actions.sendKeys(Keys.ARROW_UP).perform();

        actions.sendKeys(Keys.ARROW_UP).perform();

    }






}
