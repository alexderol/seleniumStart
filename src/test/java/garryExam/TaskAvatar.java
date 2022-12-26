package garryExam;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;
public class TaskAvatar extends BaseTest {
    @Test
    public void avatar(){
        driver.get("https://megavideos.online/tr/movie/76600/avatar-the-way-of-water");
       WebElement play=  driver.findElement(By.xpath("//span[@aria-live=\"polite\"]"));

    }

    @Override
    public void tearDown() {

    }
}
