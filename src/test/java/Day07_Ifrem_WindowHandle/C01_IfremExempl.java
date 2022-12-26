package Day07_Ifrem_WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IfremExempl {
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
    public void ifraemExam() throws InterruptedException {
        //        Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
//        Verify the Bolded text contains "Editor"
        WebElement boldedText = driver.findElement(By.tagName("h3"));
        String text = boldedText.getText();
        Assert.assertTrue(text.contains("Editor"));
//        Locate the text box
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.id("tinymce"));

        //        Delete the text in the text box
        Thread.sleep(3000);
        textBox.clear();
        // textBox.findElement(By.tagName("p")).clear();

//        Type "Hi everyone"
        textBox.sendKeys("hi everyone");
//        Verify the text Elemental Selenium text is displayed on the page.
        WebElement elemental = driver.findElement(By.partialLinkText("Elemental"));
        Assert.assertTrue(elemental.isDisplayed());
    }

}
