package Day12_ScreenShots;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshots extends BaseTest {
    @Test
    public void getPageScreenShot() throws IOException {
        driver.get("https://n11.com");

        File kaynak = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//aldığımız screenshotu istediğimiz yere kaydediyoruz
        FileHandler.copy(kaynak, new File("test-output\\Screenshots\\n11Screenshot.png"));


    }

    @Test
    public void getElementScreenShot() throws IOException {
//        Go to URL: https://opensource-demo.orangehrmlive.com/
//        Saving the image to  the path.
//        Getting screenshot of Orange HRM Logo.
//        Getting screenshot of  Orange HRM Page Section.

        driver.get(" https://opensource-demo.orangehrmlive.com/");

        WebElement logo = driver.findElement(By.cssSelector("[alt=\"company-branding\"]"));
        File loogoScreenshot = logo.getScreenshotAs(OutputType.FILE);
        String date =  new SimpleDateFormat("yyyy-MM-dd/hh-mm-ss").format(new Date());//tarihi formatladık
        String path = "test-output\\Screenshots\\logoScreenshot"+ date +  ".png";
        FileUtils.copyFile(loogoScreenshot,new File(path));

        ///buraya bak tekrar screenshotlar olmadı






    }
    @Test
    public void takeSomeSS() throws IOException {
        driver.get("https://amazon.com");
        WebElement amazonLogo= driver.findElement(By.cssSelector("[id=\"nav-logo-sprites\"]"));
        File logoSS = amazonLogo.getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyy/MM/dd_hh/mm/ss").format(new Date());
        String path = "test-output\\Screenshots\\amazonSS"+date+".png";
        FileUtils.copyFile(logoSS,new File(path));
    }
}
