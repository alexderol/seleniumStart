package Day01_SeleniumMaven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebdriverManagerTest {

        // Set Path.
        // Create chrome driver.
        // Maximize the window.
        // Open google home page https://www.google.com/
        // Verify that you are Google in the title.
        public static void main(String[] args) {
            //System.setPrperty() yerine artık bunu kullanacağız
            //webDriverManager classı kullanılarak chromedriver binary lerimizi indirdik
            WebDriverManager.chromedriver().setup();
            //driver obj oluştu
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            String title= driver.getTitle();
            if(title.equals("Google")) System.out.println("PASSED");
            else System.out.println("FAILED");

            driver.quit();






        }





}
