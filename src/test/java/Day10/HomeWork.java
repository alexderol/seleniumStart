package Day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class HomeWork extends BaseTest {
    @Test
    public void test1(){
//        Go to URL: https://www.monsterindia.com/seeker/registration
//        Upload file.
        driver.get("https://www.monsterindia.com/seeker/registration");
        WebElement upload = driver.findElement(By.className("uploadbox v2 uploadboxnew"));
        upload.sendKeys("C:\\Users\\erolp\\Downloads\\Mülakat Task - Amazon .pdf");
        Actions actions = new Actions(driver);
        WebElement devam =driver.findElement(By.cssSelector("[data-vv-name=\"resumeCopyText\"]"));
        actions.click(devam).sendKeys("ne yazayım yarim").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("ıvır Zıvır").sendKeys(Keys.TAB).
                sendKeys("45gereksiz@gmail.com").sendKeys(Keys.TAB).sendKeys("sifre4545").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("saha",Keys.ENTER).sendKeys(Keys.TAB).sendKeys("5",Keys.ENTER).sendKeys(Keys.TAB).sendKeys("2",Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys("java",Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB);



    }
}
