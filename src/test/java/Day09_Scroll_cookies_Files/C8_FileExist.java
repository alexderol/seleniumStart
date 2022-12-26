package Day09_Scroll_cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import utilities.BaseTest;

import java.io.File;

public class C8_FileExist extends BaseTest {
    @Test
    public void fileExist(){
        // C:\Users\erolp\Desktop\fileExist.png

        System.out.println(System.getProperty("user.home")); // C:\Users\erolp
        String homePath = System.getProperty("user.home");// home yolu atandı
        String filePath = "\\Desktop\\fileExist.png";// dosyanın kalan yolu atandı

        String fullPath = homePath+filePath;//yollar birleştirildi

        File image = new File(fullPath);//path file a çevirdik

        Assert.assertTrue(image.exists());// exist metoduyla varolup olmadığını kontrol ettik

        File varMı = new File("\\C:\\Users\\erolp\\Desktop\\New folder");
        Assert.assertTrue(varMı.exists());



    }



}
