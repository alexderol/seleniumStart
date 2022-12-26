package Day09_Scroll_cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Set;

public class HomWork extends BaseTest {
    @Test
    public void test1() throws AWTException {
//        https://api.jquery.com/ sitesine gidelim
        driver.get("https://api.jquery.com/");
//        arama alanina json yazalim
        WebElement search = driver.findElement(By.cssSelector("[aria-label='search input']"));
        search.sendKeys("json");

//        Enter islemini robot class kullanrak yapalim
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }
    @Test
    public void test2(){
//        Go to URL: http://facebook.com
        driver.get("http://facebook.com");
//        getCookies,
        Set<Cookie> all = driver.manage().getCookies();

        System.out.println("tüm cookiciklerin sayısı= "+all.size()+"\n cookicikler kimlermiş --> "+all);
//        addCookie,
        Cookie ekle = new Cookie("ıvır","zıvır");
        driver.manage().addCookie(ekle);
//        deleteCookieNamed,
        driver.manage().deleteCookieNamed(ekle.getName());
//        deleteAllCookies.
       driver.manage().deleteAllCookies();
       all=driver.manage().getCookies();

        System.out.println("kalan cookicik var mı--> "+all.size());

    }

}
