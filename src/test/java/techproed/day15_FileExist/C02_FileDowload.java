package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDowload  extends TestBase {
    //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
     //"b10 all test cases" dosyasını indirin
    // Dosyanın başarıyla indirilip indirilmediğini test edin.


    @Test
    public void test01() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        warten(2);

        //C:\Users\admin\Downloads\b10 all test cases, code.docx-->Dosya yolu
        File deleteOrdner=new File("C:\\Users\\admin\\Downloads\\b10 all test cases, code.docx");
        deleteOrdner.delete();
        warten(3);

        /*
 File silinecekDosya=new File("/Users/betulsongul/Downloads/b10 all test cases, code.docx") ;
silinecekDosya.delete();

Eğer  localinizden otomasyon ile dosya silmek için File class ından obje oluşturup dosya yolunu içine yerleştiririz.
 Ve oluşturduğumuz obje ile delete() methodunu kullanarak silebiliriz.
 Bunu yapma sebebimiz test classımızı çalıştırmada yeni bir dosya indireceği için oradaki dosya kalabalığını önlemiş oluruz
 Aynı zamananda doğrulama yaparken işimizi garantiye almış oluyoruz
 Aynı isimde birden fazla dosya indirmiş olsakta her indirilenin yanına index vereceği için ve bizim ilk indirdiğimiz
 o klasörün içinde bulamayacağı için her zaman ilk dosyanın varlığını böylelikle test etmiş oluruz

 */


        //"b10 all test cases" dosyasını indirin
        WebElement b10=driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
       b10.click();
        // Dosyanın başarıyla indirilip indirilmediğini test edin.
        warten(3);


        /*
        dosyanın, bilgisayarımda dowloads'a basarıyla indirilip indirilmedigini
        java ile test edecegim.
        cünkü selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki dowloads'a müdahele edemez.
         */


        // Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\admin\\Downloads\\b10 all test cases, code.docx")));


        // daha dinamik hale getirelim
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\b10 all test cases, code.docx";
        String dosyaYolu = farkliKisim + ortakKisim;
        warten(2);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }

    @Test
    public void test01_NT() {
        String filePath = "C:\\Users\\Lenovo\\Downloads\\b10 all test cases, code (1).docx";
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("dosya bulunamadı");
        }
        /*
        Dosyayı daha önce indirdiğimiz için ve tekrar testi çalıştırdığımızda yine aynı dosyayı indireceği için
        burda dosyayı sildik
         */

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        warten(2);
        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("(//*[text()=.])[6]")).click();
        /*
        İndirmemizi istediği dosyayı locate edip tıkladık ve dosyamız indirilenler klasörüne indi
         */
        warten(3);//--> indirme süresini göz önünde bulundurarak bekle koyduk
        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\Lenovo\\Downloads\\b10 all test cases, code (1).docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

}
