package Day09_Scroll_cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C9_FileDownload extends BaseTest {
    @Test
    public void fileDownload() throws InterruptedException {
//        Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
//        Login page valid credentials.
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        WebElement loginbutton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        loginbutton.click();
//        Download sample CSV file.
        WebElement pim = driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]"));
        pim.click();
        WebElement config = driver.findElement(By.xpath("//span[text()='Configuration ']"));
        config.click();
        WebElement dataImport = driver.findElement(By.linkText("Data Import"));
        dataImport.click();
        WebElement download = driver.findElement(By.className("download-link"));
        download.click();
//        Verify if the file downloaded successfully.
        Thread.sleep(5000);
//benim yaptığım alttta
        File indiMi = new File("\\C:\\Users\\erolp\\Downloads\\importData.csv");// sağ tarafı string yapıp aşağıda Files.exist(Paths.get(strigi buraya yazabilirdik)) Assert içinde
        Assert.assertTrue(indiMi.exists());
        //hocannı yaptığı burada
        String inendosyaYolu= "\\C:\\Users\\erolp\\Downloads\\importData.csv";
        Assert.assertTrue(Files.exists( Paths.get(inendosyaYolu)));


    }

}
