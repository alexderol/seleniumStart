package Day09_Scroll_cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import java.util.List;
import java.util.Set;

public class C4_Cookies extends BaseTest {
    @Test
    public void cookies() {
//        Go to URL: https://kitchen.applitools.com/ingredients/cookie
//        Get Cookie.
//        Find the total number of cookies.
//        Print all the cookies.
//        Add Cookie.
//        Edit Cookie.
//        Delete Cookie.
//        Delete All Cookies.
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        Cookie cookie = driver.manage().getCookieNamed("protein");
        Assert.assertEquals("chicken", cookie.getValue());

        Cookie coo = new Cookie("nakamura", "fenerbahce");

        Set<Cookie> list = driver.manage().getCookies();
        //System.out.println(list.stream().count());
        int adet = list.size();
        System.out.println(adet);
        System.out.println(driver.manage().getCookies());
        driver.manage().addCookie(coo);
        System.out.println(driver.manage().getCookies());
        for (Cookie w : list) {
            System.out.println(w.getName());
            System.out.println(w.getValue());

        }
        //edit cookie
        System.out.println("edit cookiesssssssssssssssssss");
        Cookie edited = new Cookie(coo.getName(), "erol");
        driver.manage().addCookie(edited);
        Assert.assertEquals(edited.getValue(), driver.manage().getCookieNamed(coo.getName()).getValue());
        System.out.println(driver.manage().getCookieNamed(edited.getName()).getValue());


    }

    @Test
    public void deleteCookies() {
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        Cookie eklenenCookie = new Cookie("drinks","ayran");
        driver.manage().addCookie(eklenenCookie);
        driver.manage().deleteCookie(eklenenCookie);
        Assert.assertNull("cookie hala var ",driver.manage().getCookieNamed(eklenenCookie.getName()));

        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies());// hepsi silinmix


    }
}
