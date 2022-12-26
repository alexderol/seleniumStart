package Day06_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HomeWork {
    //test1
    //  https://demoqa.com/select-menu sitesine gidin
    // - <select> elementini locate edin
    //<select> elementinin seceneklerini yazdirin
    //Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
    //  * Yellow (index)
    //  * Purple (value)
    //  * Black  (text)
    //  seceneklerini secin

/*
test2
- https://demoqa.com/select-menu sitesine gidin
- Multiple select yapabileceginiz <select> elementini locate edin
- Birden fazla secim yapip secimlerinizi DOGRULAyin
 */

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
    public void Test1() {
        driver.get("https://demoqa.com/select-menu");
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        select.selectByIndex(3);
        select.selectByValue("4");
        select.selectByVisibleText("Black");


    }

    @Test
    public void Test2() {
        driver.get("https://demoqa.com/select-menu");
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        System.out.println(select.isMultiple());
    }

    @Test
    public void Test3() {
//        https://demoqa.com/select-menu sitesine gidin
//        multiple <select> elementini locate edin
//        getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
//        Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
        driver.get("https://demoqa.com/select-menu");
        Select select = new Select(driver.findElement(By.name("cars")));
        //getoption yazdırdık
        List<WebElement> listofOptions = select.getOptions();
        listofOptions.forEach(t -> System.out.println(t.getText()));

        //getfirstoption yazdırdık
        select.selectByIndex(2);
        select.selectByIndex(3);
        WebElement selected = select.getFirstSelectedOption();
        System.out.println(selected.getText());
        // getFirstSelectedOption() yazdırdık
        List<WebElement> list = select.getAllSelectedOptions();
        list.forEach(t -> System.out.println(t.getText()));

    }

    @Test
    public void Test4() {
        // Go to URL: https://the-internet.herokuapp.com/dropdown

        driver.get("https://the-internet.herokuapp.com/dropdown ");
        Select select = new Select(driver.findElement(By.xpath("//select[@id=\"dropdown\"]")));


        // Create method selectByIndexTest and Select Option 1 using index .
        selectByIndexTest4(1, select);
        //Create method selectByValueTest Select Option 2 by value.
        selectByValueTest4("2", select);

        // Create method selectByVisibleTextTest Select Option 1 value by visible text.
        selectByVisibleTextTest4("Option 2", select);

        //Create method printAllTest Print all dropdown value.
        printAllTest4("value", select);

        // Verify the dropdown has Option 2 text.
        dropDownHasOptinsTest4(select);

        //Create method printFirstSelectedOptionTest Print first selected option.
        printFirstSelectedOptionTest4(select);


        //Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        Assert.assertEquals("Expected Is Not Equal Actual", 3, select.getOptions().size());


    }

    /*
    amazona git
    istediğin ürünü
    yeni pencerede aç

     */
    @Test
    public void win() {
        driver.get("https://amazon.com");
        WebElement ele = driver.findElement(By.xpath("(//a[@class=\"a-link-normal\"])[1]"));
        String s = ele.getAttribute("href");

        driver.switchTo().newWindow(WindowType.WINDOW).get(s);
    }

    private String printFirstSelectedOptionTest4(Select select) {
        select.selectByIndex(2);
        select.selectByIndex(1);
        return select.getFirstSelectedOption().getText();
    }

    private void dropDownHasOptinsTest4(Select select) {
        Assert.assertTrue((select.getOptions().stream().anyMatch(t -> t.getText().contains("Option 2"))));

    }

    private void printAllTest4(String value, Select select) {
        select.getOptions().forEach(t -> System.out.println(t.getAttribute("value")));
    }

    private void selectByVisibleTextTest4(String text, Select select) {
        select.selectByVisibleText(text);
    }

    private void selectByValueTest4(String value, Select select) {
        select.selectByValue(value);
    }

    private void selectByIndexTest4(int index, Select select) {
        select.selectByIndex(index);
    }

    @Test
    public void Test5() {
//        Launch the browser.
//        Open "https://demoqa.com/select-menu".
        driver.get("https://demoqa.com/select-menu");
//        Select the Standard Multi-Select using the element id.
        Select select = new Select(driver.findElement(By.id("cars")));
//        Verifying that the element is multi-select.
        System.out.println(select.isMultiple());
//        Select 'Opel' using the index and deselect the same using index.
        select.selectByIndex(3);
        select.selectByIndex(3);
//        Select 'Saab' using value and deselect the same using value.
        select.selectByValue("saab");
        select.deselectByValue("saab");
//        Deselect all the options.
        select.deselectAll();
//        Close the browser.

    }

    @Test
    public void Test6() throws InterruptedException {
//        Go to URL: http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
//        Click "Alert with OK" and click 'click the button to display an alert box:’
        driver.findElement(By.xpath("//button[@onclick=\"alertbox()\"]")).click();
        Thread.sleep(2000);

//        Accept Alert(I am an alert box!) and print alert on console.
        driver.switchTo().alert().accept();
//        Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        driver.findElement(By.xpath("(//a[@data-toggle=\"tab\"])[2]")).click();
        driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
//        Cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
//        Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
        driver.findElement(By.xpath("(//a[@data-toggle=\"tab\"])[3]")).click();
        driver.findElement(By.xpath("//button[@onclick=\"promptbox()\"]")).click();
//        And then sendKeys «BootcampCamp» (Please enter your name)
        driver.switchTo().alert().sendKeys("Erol");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
//        Finally print on console this message "Hello BootcampCamp How are you today" assertion these message.
        System.out.println(driver.findElement(By.xpath("//p[@id=\"demo1\"]")).getText());

    }


    @Test
    public void test7() {
//        Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");
//        Find the number of iframes on the page.
        List<WebElement> listOfframes = driver.findElements(By.xpath("//iframe"));
        System.out.println(listOfframes.size());
//        Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.cssSelector("[src='Jmeter720.png']")).click();
//        Exit the iframe and return to the main page.
        driver.switchTo().defaultContent();

    }

    @Test
    public void test8() {
//        Go to URL: https://testproject.io/
        driver.get("https://testproject.io/");
//        Selenium’s 4 newWindow() method to open a new Window for TestProject’s Blog page.
        driver.switchTo().newWindow(WindowType.WINDOW).get("  https://blog.testproject.io/");
//        https://blog.testproject.io/


    }

    @Test
    public void test9() {
//        Go to URL: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");
        String mainWin = driver.getWindowHandle();
//        Click on the windows - "WindowButton"

        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("tabButton")).click();

//        Click on all the child windows.
        Set<String> handlesss = driver.getWindowHandles();
        Iterator<String> it = handlesss.iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            if (mainWin.equals(driver.getWindowHandle())){
                //        Print the heading of the parent window in the console.
                System.out.println(driver.getTitle());

                //        Print the text present on all the child windows in the console.
            }else System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        }


    }

}









