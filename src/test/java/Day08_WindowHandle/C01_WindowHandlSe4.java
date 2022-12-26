package Day08_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowHandlSe4 extends BaseTest {
// https://testproject.io/

    // https://blog.testproject.io/
    @Test
    public void newWindow() {
        //Ana sekmemizde usl i siyaret ediyoruz
        driver.get("https://testproject.io/");
///yeni pencereye switch ediliyor
        driver.switchTo().newWindow(WindowType.WINDOW);
        //yeni pencerede açılıyor
        driver.get(" https://blog.testproject.io/");


    }

    @Test
    public void newTab() {
        driver.get("https://testproject.io/");

        driver.switchTo().newWindow(WindowType.TAB).get("https://amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void handleWindows() {
        //ana sekme
        driver.get("https://amazon.com");

        // getWindowHandle()            getWindowsHandles()
        //-tek deger döndürür           --çoklu deger döndürür
        //string dönüyor                --set

        String homePageHandle = driver.getWindowHandle();//ana sayfanın id sini stringe atadık

        driver.switchTo().newWindow(WindowType.TAB);
        // yeni sekmedeki amazon tr yi açtık
        driver.get("https://amazon.com.tr");
        // yeni pencere açtık
        driver.switchTo().newWindow(WindowType.WINDOW);
        //yeni pencerede google açtık
        driver.get("https://google.com");

        Set<String> handles = driver.getWindowHandles();//tüm pencerelerin id lerini handle ile set e attık
        Iterator<String> it = handles.iterator();//set üzerinde gezinmek için iterator oluşturduk

        while (it.hasNext()) {
            //driver.switchTo().window(id) aslında bunu yapmış oluyor id burada it
            String currentTab = it.next();
            driver.switchTo().window(currentTab);//swithe id leri sayesinden geçiş yapıyoruz
            System.out.println(driver.getTitle());//gezinilen title yazdırıloryor
            //1 . yol
            if (!currentTab.equals(homePageHandle)) {
            driver.close();//ana sayfayı kapatma dedik yani ana sayfa dışındakileri kapat
            }

           /* //2. yol
            if (!driver.getTitle().contains("Spend")){
                driver.close();
            }*/
        }


    }


}
