package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuE1 {
//
//    1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//            3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'New User Signup!' is visible
@Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationexercise.com");
//        String homePage = driver.getCurrentUrl();
//        String execptedurl ="https://automationexercise.com/home";
//     //  Verify that home page is visible successfully
//       Assert.assertTrue(homePage);
        driver.findElement(By.xpath("//i[@class=\"fa fa-lock\"]"));
       //
        WebElement newUserVisiable = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertTrue(newUserVisiable.isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nakamura");
        driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("ebikgabik@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
       WebElement enterAccountİnf= driver.findElement(By.xpath("//b[.='Enter Account Information']"));
       Assert.assertTrue(enterAccountİnf.isDisplayed());

//9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@name='title']")).click();
        driver.findElement(By.xpath("//input[@class=\"form-control\"]")).sendKeys("1907ttütkükt,,,");
        driver.findElement(By.xpath("//option[.='22']")).click();
        driver.findElement(By.xpath("//option[.='May']")).click();
        driver.findElement(By.xpath("//option[.='1985']")).click();

//10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@name=\"newsletter\"]")).click();

//            11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@name=\"optin\"]")).click();

//            12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("erol");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("demir");
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("demirAşşşş");
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Akhisar");
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Manisa");
        driver.findElement(By.xpath("//option[.='Canada']")).click();
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("gördes");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("soveller");
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("45200");
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("5459336565");

//13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='mobile_number']")).click();
//            14. Verify that 'ACCOUNT CREATED!' is visible
      WebElement creat=  driver.findElement(By.xpath("//b[.='Account Created!']"));
      Assert.assertTrue(creat.isDisplayed());


//15. Click 'Continue' button
        driver.findElement(By.xpath("//a[.='Continue']")).click();
//16. Verify that 'Logged in as username' is visible
        WebElement loggedName=driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]"));
        Assert.assertTrue(loggedName.isDisplayed());
//17. Click 'Delete Account' button
        driver.findElement(By.xpath("//i[@class=\"fa fa-trash-o\"]")).click();
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement delete= driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        Assert.assertTrue(delete.isDisplayed());
        driver.quit();






    }
}
