package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_KeyDownKeyUp extends TestBase {
    //        WebElement element = driver.findElement(By.xpath("//*[@id='droppable']"));
//        Rectangle rect = element.getRect();
//        int x = rect.getX();
//        int y = rect.getY();
//        System.out.println("X koordinatı: " + x);
//        System.out.println("Y koordinatı: " + y); webelementin yaklasik koordinatlari


    //Google anasayfasına gidelim
//arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

                //driver.findElement(By.xpath("//body[@jsmodel='hspDDf']"));

//arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement searchBox=driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        Actions actions=new Actions(driver);
        actions.keyDown(searchBox, Keys.SHIFT). //Arama Kutusunda Schift tusuna bastik
        sendKeys("selenium").
                keyUp(Keys.SHIFT).//Schift tusunu serbest birak
        sendKeys("java",Keys.ENTER).perform();


    }
    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenim",Keys.SHIFT,"-java",Keys.ENTER);
    /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */
    }

    @Test
    public void test03() {
        //google sayfasına gidelim
// Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
// Sayfayı bekleyin
// Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
//Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım

        //google sayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();
        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        //searchBox.sendKeys("Selenium", Keys.ENTER);
        searchBox.sendKeys("Selenium");
        searchBox.submit();
        // Sayfayı bekleyin
        warten(3);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim

        //Sayfa yenilendigi icin tekrar locate almamiz gerekti
        //StaleElementReferenceException daha once locate'ini aldigimiz weblementin locate'i sayfa
        //yenilendigi icin degismis ve onceden aldigimiz locate ile isleme devam edince bu exeption'i aldik.
        driver.findElement(By.xpath("//*[@class='gLFyf']"))
                .sendKeys(Keys.CONTROL,"a");//--> Metni kesebilmemiz icin once ctrl+a ile secmemiz gerekir
        driver.findElement(By.xpath("//*[@class='gLFyf']"))
                .sendKeys(Keys.CONTROL,"x");
        warten(3);
        /*
        Alternatif--> WebElement aramaKutusu1 = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu1.sendKeys(Keys.CONTROL,"a","x");
         */
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım

        /* Alternatif-->
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.COMMAND,"a", Keys.COMMAND,"x");
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
         driver.navigate().back();
         driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.COMMAND,"v");
         */
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);//-->Kestiğimiz metni ctrl+v tusu ile tekrar arama kutusuna yapıştırdık ve arattık


    }
}
