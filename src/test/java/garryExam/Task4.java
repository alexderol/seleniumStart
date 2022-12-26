package garryExam;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class Task4 extends BaseTest {
    @Test
    public void task4(){
        /*
    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
    1. Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
    2. Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın.
    3. Visible Text (Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın.
    4. Tüm dropdown değerleri(value) yazdırın.
    5. Dropdown'un boyutunu bulun, Dropdown'da 4 öğe varsa konsolda True, değilse False yazdırın.
*/
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dorp = driver.findElement(By.id("dropdown"));
        Select select = new Select(dorp);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //en son seçilen yazdırıldı 27 de
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> alloptionlist = select.getOptions();
        alloptionlist.forEach(t-> System.out.println(t.getText()));
        ////alloptionlist.size()==4?"True":"False"
        if(alloptionlist.size()==4) System.out.println("true");
        else System.out.println("false");

        Assert.assertFalse(select.getOptions().size()==4);



    }
}
