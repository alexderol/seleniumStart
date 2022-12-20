package Day02_WebElementLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://linkedin.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void idLocators() throws InterruptedException {
        WebElement email = driver.findElement(By.id("session_key"));
        email.sendKeys("Clarusway selenium dersinden selamlar");


    }

    @Test
    public void nameLocator() throws InterruptedException {
        WebElement password = driver.findElement(By.name("session_password"));
        password.sendKeys("1907");
        driver.findElement(By.className("sign-in-form__password-visibility-toggle-button")).click();
        Thread.sleep(3000);

    }

    @Test
    public void classNameLocator() {
        WebElement email = driver.findElement(By.className("input__input"));
        email.sendKeys("Class locator Test ");

    }

    @Test
    public void tagLocator() {
        List<WebElement> emaillist = driver.findElements(By.tagName("input"));
        WebElement email = emaillist.get(1);//burada findelemets list döndüğü için listten web elemente atadık
        email.sendKeys("yaz bakalım ");
    }

    @Test
    @Ignore
    public void linkTextLocator() {

    }

    @Test
    public void absoluteXpath() {
        WebElement email = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/div[1]/input"));
        email.sendKeys("oldu mu gülüm ");
    }

    @Test
    public void relativeXpathLocator() {
        WebElement email = driver.findElement(By.xpath("//input[@id='session_key']"));
        email.sendKeys("al sana xpath");

    }

    @Test
    public void multiableAttributeXpath() {
        WebElement email = driver.findElement(By.xpath("//input[@class='input__input'][@name='session_key']"));
        email.sendKeys("al sana xpath");

    }

    @Test
    public void andOrXpath() {
        WebElement email = driver.findElement(By.xpath("//input[@id='session_key'and @name='session_key']"));
        email.sendKeys("al sana AND li xpath");
        WebElement pass = driver.findElement(By.xpath("//input[@id='session_password' or name='session_password']"));
        pass.sendKeys("1907");

    }
    @Test
    public void containsXpath() {
        WebElement email = driver.findElement(By.xpath("//input[contains(@id,'session') and contains(@name,'key')]"));
        email.sendKeys("al sana CONTAİNS  li xpath");
        WebElement pass = driver.findElement(By.xpath("//input[@id='session_password' or name='session_password']"));
        pass.sendKeys("1907");


    }

    ////button[contains(text(), 'Oturum açın')]
    @Test
    public void textXpath() {
        WebElement oturumAç = driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]"));
        oturumAç.click();




    }






}
