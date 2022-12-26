package Day07_Ifrem_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BaseTest;

import java.time.Duration;
import java.util.List;

public class C02_IfreamExam extends BaseTest {


    @Test
    public void test(){
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidiniz.
// Web sitesini maximize yapınız.
// İkinci emojiye tıklayınız.
// Tüm ikinci emoji öğelerine tıklayınız.
// Parent iframe geri dönünüz.
// Formu doldurun (Formu istediğiniz metinlerle doldurun) apply button'a basınız.

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.switchTo().frame("emoojis");//ifreamin içine gir
        WebElement secondEmojiTab = driver.findElement(By.xpath("//a[contains(@href,'nature' )]"));
        secondEmojiTab.click();

        List<WebElement> emojilist = driver.findElements(By.xpath("//div[@id='nature']//img"));
        emojilist.forEach(WebElement::click);// her bir img elemtine tıklanıyor

        driver.switchTo().defaultContent();//ifreamin içinden çıktı

        WebElement text = driver.findElement(By.id("text"));
        text.sendKeys("text");

        WebElement nature = driver.findElement(By.id("nature"));
        nature.sendKeys("nature");

        WebElement food = driver.findElement(By.id("food"));
        food.sendKeys("food");

        WebElement activities = driver.findElement(By.id("activities"));
        activities.sendKeys("activities");

        WebElement places = driver.findElement(By.id("places"));
        places.sendKeys("");

        WebElement objects = driver.findElement(By.id("objects"));
        objects.sendKeys("objects");

        WebElement applyButton = driver.findElement(By.id("send"));
        applyButton.click();



    }
}
