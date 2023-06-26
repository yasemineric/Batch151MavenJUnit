package techproed.day18_ScreenShot;

import net.bytebuddy.asm.MemberSubstitution;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {


    /*
    SCREENSHOT
           Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
       driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
       getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
       oranın yolunu belirtiriz.
     */
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        warten(1);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Ve ekran görüntüsünü alalım
        /*
        ilk olarak screenShot aldigimizda nereye kaydetmek istiyorsak oranin yolunu belirtelim.
        İkinci olarak TakesScreenShot arayüzünden obje oluşturuz
        -Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak getScreenShotAs methodu ile
dosya yolunu belirteceğiz




         */
        String ordnerPath = "src/test/java/techproed/ScreenShot/screenShot.png"; //screenShot.png bu kismi biz sonradan ekliyoruz
        TakesScreenshot ts = (TakesScreenshot) driver;
        //TakesScreenshot ts=driver yazinca alti kirmizi olur, üstüne gelince Caste. te tiklayip TypeCasting yapariz
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(ordnerPath));
        //FileUtils classi dosyalari okumaya yazmaya vs. yarayan  ve pekcok methodu var


        /*
        SCREENSHOT

Seleniumda tum ekran goruntusunu alabilmek icin
TakesScreenShot arayuzunden bir obje olusturup driver'a esitleriz.
Arayuzler farkli oldugu icin casting yapariz ve bu olusturdugumuz obje ile getSceenshotAs
methodu ile sayfanin resmini aliriz. Almis oldugumuz resmi projemizde nereye kaydedeceksek
oranin yolunu belirtiriz.

1.Adim:
Once Techproeducation sayfasina driver.get() ile gittik.
Cikan reklamin x isaretinden locate'i alip click ile locate'i aldigimiz x isaretine
basip kapattik.
Aldigimiz ekran goruntusunu kaydedecegimiz dosyayi belirledikten sonra o dosya yolunu
belirleriz. sol kosede B151MavenJUnit seviyesine gelip sagi tiklayinca New'den Directory'e geliriz
ya da techproed kismina gelip sagi tiklayinca yeni package olusturduk, adini TumSayfaResmi olarak
verdik. Daha sonra olusturdugumuz package uzerine gelip sagi tikladik ve Copy Path Reference'a bastik
devaminda cikan Path From Content Root'u sectik ve aldigimiz dosya yolunu asagidaki String'e
yapistirarak assign ettik.
String dosyaYolu= "src/test/java/techproed/TumSayfaResmi";

2.Adim:
Goruntuyu kaydedecegimiz dosya yolunu bu sekilde belirledikten sonra TakesSceerShot arayuzunden
obje olusturduk ve driver arayuzune esitledik.
TakesScreenShot ts= driver; boyle yazinca kizarma belirdi.
Bunun uzerine TakseScreenShot ts= (TakesScreenShot) driver; kizariklik olan
yere gelince bir aciklama belirdi. Bu yonlendirmede TakesScreenShot ve WebDriver vardi.
CastExpression'dan TakesScreenShot'i eklettik. Bu ekleme ile kizariklik sona erdi.

3. Adim:FileUtils Class'indan copyFile() methodu ile ts objemizi kullanarak getScreenShotAs
methodu ile dosya yolunu belirledik.
FileUtils.copyFile(ts.getScreenShotAs(OutputType.FILE), new File(dosyaYolu));


TakesScreenshot interface oldugundan implement eden siniflar override etmek zorunda,
obje de TakesScreenshot'i implemente etmeli yoksa assign edemeyiz.

         */
    }



        @Test
        public void test02() throws IOException {
            //Techproeducation sayfasına gidelim
            driver.get("https://techproeducation.com");

            warten(2);
            //Çıkan reklamı kapatalım
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

            //Ve ekran görüntüsünü alalım
            TakesScreenshot ts2 = (TakesScreenshot) driver;
            FileUtils.copyFile(ts2.getScreenshotAs(OutputType.FILE),new File("ScreenShot/screenShot.png"));
             //dosyayolunu string ile almadik ve screenshot package i ideanin altinda olustu.


        }

    @Test
    public void test03() throws IOException {
        /*
        Kaydettigimiz ekran resmi herseferinde ayni dosya üzerine yazmamasi icin
         dosya isminden sonra String bir degiskene tarih formati atayabiliriz
         */

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        warten(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        /*
        SimpleDateFormat'i kullanarak yeni bir tarih formati olusturup bir String.e assign ederiz.
        Ve bunu dosya isminden önce belirtiriz.
         */
        String datum=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String ordnerPath = "src/test/java/techproed/ScreenShot/screenShot"+datum+".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(ordnerPath));

    }

    @Test
    public void test04() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        warten(2);

        //Ve ekran görüntüsünü alalım

        String datum = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String ordnerPath = "src/test/java/techproed/ScreenShot/screenShot" + datum + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(ordnerPath));
    }


}
