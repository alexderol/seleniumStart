package Day09_Scroll_cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C10_FileUpload extends BaseTest {

    @Test
    public void fileUpload(){
//        Go to URL: https://the-internet.herokuapp.com/upload
//        Find the path of the file that you want to upload.
//        Click on Upload button.
//        Verify the upload message.
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec= driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\erolp\\Downloads\\importData.csv");//upload için sendkeysle yolunu verdik yolladı
        WebElement uploadButtonc= driver.findElement(By.id("file-submit"));
        WebElement uploadudMassage = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(uploadudMassage.isDisplayed());
        Assert.assertEquals("File Uploader",uploadudMassage.getText());

        //eger bir locater bulunmama ihtimali varsa asserte isEmpty kullanıp devam ettirebiliriz
        //cüneyt yazmıştı

    }

}
