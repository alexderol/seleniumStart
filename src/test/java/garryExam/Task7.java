package garryExam;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task7 extends BaseTest {
    @Test
    public void task7(){
        /*
    1- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
    2- Çizili alan üzerinde sağ click yapalım.
    3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    4- Tamam diyerek Alert'i kapatalım.
    5- Elemental Selenium linkine tıklayalım.
    6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
 */
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement cızgı = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cızgı).perform();
        driver.switchTo().alert().accept();
        WebElement element = driver.findElement(By.cssSelector("[target=\"_blank\"]"));
        element.click();
        driver.switchTo().newWindow(WindowType.WINDOW).get("http://elementalselenium.com/");
        Assert.assertTrue(driver.findElement(By.xpath("//h1[.='Elemental Selenium']")).getText().contains("Elemental Selenium"));



    }



}
