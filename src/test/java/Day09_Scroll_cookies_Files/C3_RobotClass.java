package Day09_Scroll_cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C3_RobotClass extends BaseTest {
    @Test
    public void robotClass () throws AWTException, InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement dosyaSec = driver.findElement(By.id("uploadfile_0"));
        dosyaSec.sendKeys("C:\\Users\\erolp\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\RobotClassIcin.txt");//bir file oluşturduk onu senledik
        //burada dosya gönder tuşunu click yapmadık sendkeys ile gönderdik buraya dikkat


        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);//ctrl tuşuna basılı tutuyoruz şuan
        robot.keyPress(KeyEvent.VK_S);//s tuşuna basılı tutuyoruz yani toplamda ctrl+s yapmış olduk yani save dedik
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);// ctrl tuşu bırakıldı
        robot.keyRelease(KeyEvent.VK_S);//s harfini de bırakmış olduk
        robot.keyPress(KeyEvent.VK_ENTER);//Enter tuşuna bastık
        robot.keyRelease(KeyEvent.VK_ENTER);//Enter tuşunu bıraktık

        Thread.sleep(5000);

        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        Thread.sleep(5000);



    }
}
