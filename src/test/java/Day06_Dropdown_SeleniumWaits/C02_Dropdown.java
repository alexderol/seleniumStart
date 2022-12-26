package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    WebDriver driver;

    @Before

    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void SelectByIndex() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement dropdown = driver.findElement(By.xpath("//select[@name=\"country\"]"));
        //locat edilen dropdown select obj dönüştür
        Select select = new Select(dropdown);
        select.selectByIndex(2);
        //yukarıda index girdik yani 0 dan başlar kaçtane select varsa artık


    }

    @Test
    public void SelectByValue() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement dropdown = driver.findElement(By.xpath("//select[@name=\"country\"]"));

        Select select = new Select(dropdown);
        select.selectByValue("TURKEY");


    }

    @Test
    public void SelectByVisibleText() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement dropdown = driver.findElement(By.xpath("//select[@name=\"country\"]"));

        Select select = new Select(dropdown);
        select.selectByVisibleText("NEPAL");


    }

    @Test
    public void multipleSelect() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        System.out.println(select.isMultiple());//birden fazla seçime izin veriyor mu
        select.selectByValue("apple");
        select.selectByIndex(3);
    }

    @Test
    public void getOptions() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");

        Select select = new Select(driver.findElement(By.name("country")));

        //getOqtions metodu select  elemetinin tüm seceneklerini bir liste içerisinde bize verir
        List<WebElement> options = select.getOptions();///select get optionsi liste ekledik
        for (WebElement w : options) {//listin elemanlarını text olarak yazdırdık
            System.out.println(w.getText());

        }

    }

    @Test
    public void getFirstSelectedOption() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByIndex(3);//grape
        select.selectByIndex(2);//orange
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println(selectedOption.getText());//seçilmişlerin ilki yani index olarak en öndeki

    }

    @Test
    public void getAllSelectedOptions() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByValue("banana");
        select.selectByValue("apple");
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        selectedOptions.stream().forEach(t -> System.out.println(t.getText()));
    }


}
