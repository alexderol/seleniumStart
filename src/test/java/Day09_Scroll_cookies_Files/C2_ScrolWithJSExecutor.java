package Day09_Scroll_cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C2_ScrolWithJSExecutor extends BaseTest {
    @Test
    public void scrolWithJsExecutor() throws InterruptedException {
//        go to url : https://api.jquery.com/dblclick/
//        double click on the blue square at the bottom of the page and then write the changed color.
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);
        WebElement clickcYapılacakYer = driver.findElement(By.cssSelector("body>div"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",clickcYapılacakYer);
        //jse ile clik yapılacak yere kadar scrol yaptı geldi yani
        System.out.println("colour before = "+clickcYapılacakYer.getCssValue("background-color"));
        //tıklanmadan önceki rengi için yazdık yukarıyı
        Actions act = new Actions(driver);
        act.doubleClick(clickcYapılacakYer).perform();
        System.out.println("colour after = "+clickcYapılacakYer.getCssValue("background-color"));
        Thread.sleep(2000);



    }


}
