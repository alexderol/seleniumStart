package Day07_Ifrem_WindowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C03_WindowHandle extends BaseTest {
//    Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
//    Print the existing windowHandles ids by clicking all the links on the page.
//    Click on the links that open a new page.
//    Close other pages other than the home page.
//    Set the driver back to the main page.
    public void windowHandle(){
        driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");
        String homePageId = driver.getWindowHandle();

        List<WebElement> links = driver.findElements(By.xpath("//a[@target='_blank']"));
        //target olanları bulduk çünkü yeni sayfa açtıranlar lazım

        links.get(0).click();
        links.get(1).click();
        Set<String> windows = driver.getWindowHandles();//açılan pencerelerin id lerini sete ekledik
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()){//her windowsu teker teker kapatacak hasnext kalmadığı zaman döngü bitecek
            driver.switchTo().window(iterator.next());//swith ettiğimiz id kullılarak oanki sekmeye siwitch ediyor

            if(iterator.next().equals(homePageId)){//ana windowa eyşit olursa contiune de diğerlerini kapat
                continue;}
            driver.close();

            //day6 seleniumwaita bak

        }


    }

}
