package Day05_LocatorsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class C03_ChromeOptions {
    @Test
    public void chromeOptions() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("headless");//code çalıştı ancak açılan bir pencere yok
        options.addArguments("start-maximized");//chrome büyük başlatır
        WebDriver driver = new ChromeDriver();

    }
}
