package garryExam;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Set;

public class Task5 extends BaseTest {
    @Test
    public void task5() {
        /*
    ● https://the-internet.herokuapp.com/windows adresine gidin.
    ● Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
    ● Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
    ● Click Here butonuna basın.
    ● Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın.
    ● Sayfadaki textin "New Window" olduğunu doğrulayın.
    ● Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
*/
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement text = driver.findElement(By.xpath("//*[.='Opening a new window']"));
        Assert.assertTrue(text.isDisplayed());
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        String firstPageHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("target=\"_blank\"")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();

        String secondWindowHandle = "";

        for (String each : allWindowHandles) {
            if (!each.equals(firstPageHandle)) {
                secondWindowHandle = each;
            }

        }
        driver.switchTo().window(secondWindowHandle);
        Assert.assertTrue(driver.getTitle().contains( "New Window"));
        driver.switchTo().window(firstPageHandle);
        Assert.assertTrue(driver.getTitle().contains("The Internet") );

    }


}

