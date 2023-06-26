package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_File_Upload extends TestBase {
    // masaustunde bir deneme dosyası olusturun
// 'https://the-internet.herokuapp.com/upload' adresine gidiniz
// 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
// 'Upload' butonuna basın
// 'File Uploaded!' yazısının goruntulendigini test edin


    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun
// 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");
// 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
       WebElement dataiAuswahlen= driver.findElement(By.xpath("//input[@id='file-upload']"));
       //dataiAuswahlen.sendKeys("C:\\Users\\admin\\Desktop\\deneme.txt");
        // C:\Users\admin      \Desktop\deneme.txt
        String farkli=System.getProperty("user.home");
        String ortak="\\Desktop\\deneme.txt";
        String dosyaYolu=farkli+ortak;
        dataiAuswahlen.sendKeys(dosyaYolu);

// 'Upload' butonuna basın
        WebElement upload=driver.findElement(By.xpath("//input[@id='file-submit']"));
        upload.click();

// 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement text=driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(text.isDisplayed());


    }

    @Test
    public void test02_NT() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        /*
        Eğer dosyaSeç butonuna basmamız istenirse ve otomasyon ile bu butona klik yapmak istediğimizde
        exception alıyorsak, direk upload yapmak istediğimiz dosya yolunu alıp sendKeys() methodu ile
        dosyayı sayfaya upload yapabiliriz.
        Eğer upload yada dosyaseç butonuna tıkladığınızda windows pencesi açılıyorsa, o webelemente
        sendKeys() methodu ile dosya gönderemeyebilirsiniz. Böyle bir durumla karşılaşırsanız
        Robot class'ından obje ile methodlar kullanarak bunu aşabilirsiniz.
         */
        String dosyaYolu = "C:/Users/Lenovo/OneDrive/Masaüstü/sen.txt";
        //dosyaSeç butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        //dosyaSec.click();--> click yapmadı hata aldık
        //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);
        warten(2);
        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        warten(2);
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
