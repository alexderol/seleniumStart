package Day09_Scroll_cookies_Files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C7_FileExist {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));//projenin rootunun yolunu veriri
        String projectRoot = System.getProperty("user.dir");// bulmak istediğimiz file projeyoulnu stringe atadık
        String filePath = "\\src\\test\\java\\resources\\fileExist.jpg";//istenilen file atıyoruz
        filePath = projectRoot + filePath;//

        System.out.println(Files.exists(Paths.get(filePath)));//path yolu doğru ise true döner yanlışsa false
        if (Files.exists(Paths.get(filePath))) System.out.println("dosya Bulundu");//
        else System.out.println("dosya bulunamadı");


    }


}