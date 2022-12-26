package Day08_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

import javax.swing.*;

public class C02_Actions extends BaseTest {
    @Test
    public void doubleClick(){
        driver.get("https://demoqa.com/buttons");

        WebElement doublClickbutton = driver.findElement(By.id("doubleClickBtn"));
        //You have done a double click
        Actions action = new Actions(driver);
        action.doubleClick(doublClickbutton).perform();//perforrm olmadan olmaz perform uygula demek
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());
    }
    @Test
    public void rightClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        Actions action = new Actions(driver);
        action.contextClick(rightClick).perform();
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());
    }
@Test
    public void click(){
        driver.get("https://demoqa.com/buttons");
        WebElement clickButton = driver.findElement(By.xpath("//button[.='Click Me']"));
        Actions action = new Actions(driver);
        action.click(clickButton).perform();
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement wasington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));

        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement danmark = driver.findElement(By.id("box104"));
        WebElement soutkorea = driver.findElement(By.id("box105"));
        WebElement swedeen = driver.findElement(By.id("box102"));
        WebElement us = driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(madrid,spain).perform();
        actions.dragAndDrop(wasington,us).
                dragAndDrop(rome,italy).
                dragAndDrop(oslo,norway).
                dragAndDrop(stockholm,swedeen).
                dragAndDrop(copenhagen,danmark).
                dragAndDrop(seoul,soutkorea).perform();
        Thread.sleep(3000);

    }
    @Test
    public void moveTolucozum() throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement wasington = driver.findElement(By.id("box3"));
        WebElement us = driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(wasington).moveToElement(us).perform();



       Thread.sleep(3000);
    }


    @Test
    public void dragAndDropOffsetHorizontal() throws InterruptedException {
        driver.get("https://rangeslider.js.org/");
        WebElement slider = driver.findElement(By.xpath("(//div[@class=\"rangeslider__handle\"])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,300,0).perform();
        actions.dragAndDropBy(slider,-150,0).perform();
        actions.dragAndDropBy(slider,-300,0).perform();
        actions.dragAndDropBy(slider,700,0).perform();
        Thread.sleep(5000);



    }
    @Test
    public void dragAndDropOffsetVertical() throws InterruptedException {
        driver.get("https://rangeslider.js.org/");
        WebElement slider = driver.findElement(By.xpath("(//div[@class=\"rangeslider__handle\"])[7]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,0,50).build();
        actions.dragAndDropBy(slider,0,-60).perform();
       ///yap verticalı
        Thread.sleep(5000);



    }


}
