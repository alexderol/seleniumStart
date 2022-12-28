package Day09_Scroll_cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C11_AssertElementTrick extends BaseTest {
    @Test
    public void trick() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\erolp\\Downloads\\interview.pdf");//upload için sendkeysle yolunu verdik yolladı
        WebElement uploadButtonc = driver.findElement(By.id("file-submit"));
        List<WebElement> uploadudMassagelist = driver.findElements(By.tagName("h3"));

        Assert.assertEquals("upload mesaage görüntülenemedi",1,uploadudMassagelist.size());

        WebElement uploadMassege = uploadudMassagelist.get(0);
        Assert.assertTrue(uploadMassege.isDisplayed());

        Assert.assertEquals("bir yanlışlık var","File Uploader",uploadMassege.getText());



    }
}
