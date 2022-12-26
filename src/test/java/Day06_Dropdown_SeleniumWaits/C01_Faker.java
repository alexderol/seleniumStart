package Day06_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

public class C01_Faker extends BaseTest {

    @Test
    public void fakerExample() throws InterruptedException {
        //faker obj oluştur
        Faker faker = new Faker();
        System.out.println( faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().fullAddress());

        driver.get("https://google.com");
        //String a = faker.name().name();
        driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys(faker.name().firstName());
        Thread.sleep(5000);
        faker.animal().name();
        System.out.println(faker.idNumber().invalid());

    }
}
