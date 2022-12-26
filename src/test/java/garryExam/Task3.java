package garryExam;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Task3 extends BaseTest {
    /*
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    ● Bir method oluşturun: acceptAlert
        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" olduğunu test edin.
    ● Bir method oluşturun: dismissAlert
        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfuly" içermediğini test edin.
    ● Bir method oluşturun: sendKeysAlert
        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin içerdiğini doğrulayın.
 */@Test
    public void task3(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickForjsAlert = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
        clickForjsAlert.click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");
        WebElement seconBtton = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        seconBtton.click();
        driver.switchTo().alert().dismiss();

        Assert.assertFalse(driver.findElement(By.id("result")).getText().contains("succesfuly"));

        WebElement lastButton = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        clickForjsAlert.click();
       ///driver.switchTo().alert().sendKeys("erol");
        driver.switchTo().alert().accept();

        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("erol"));




    }
}
