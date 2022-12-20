package Day01_SeleniumMaven;

import org.junit.*;

public class C02_junitAnnotations {


    // 1. Test
    // 2. Test
    // 3. Test
    // 4. Test(gelistirme asamsında bu yuzden rapora dali olmasin)

    // her testimizden once sonra calismasi gereken kod bloklarimiz (methodlarimiz) mevcut
    //tum testlerin oncesinde ve sonrasinda calismasi gereken methodlarimiz mevcut


    @Test
    public void test01() {
        System.out.println("1. Test yapılıyor.........");
    }

    @Test
    public void test02() {
        System.out.println("2. Test yapılıyor.........");
    }

    @Test
    public void test03() {
        System.out.println("3. Test yapılıyor.........");
    }

    @Test
    @Ignore
    public void test04() {
        System.out.println("4. Test yapılıyor.........");
    }

    @Before
    public void beforeEach(){
        System.out.println("method öncesi kod blogu calisti");
    }
    @After
    public void afterEach(){
        System.out.println("method sonrasi kod blogu calisti");
    }

    @BeforeClass
    public static void beforeAll(){                     ///beforclass ve afterclass lar static olmalı
        System.out.println("methodların oncesinde calisacak");
    }
    @AfterClass
    public static void afterAll(){
        System.out.println("methodlarin sonrasinda calisacak");
    }

}
