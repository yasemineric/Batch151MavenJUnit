package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist extends TestBase {
    //Selenium web tabanlı uyhulamar için kullanılır.
    /*
    Proje-Dosya yolu ne demek
icinde oldugumuz intellij projesinin dosya yoludur..Örnnegin dosyalarimi actginizda sitasizla tikladigimiz dosyalar
üst cubukta ">" isretiyle gözükür. Bu dosya yoludur.Dosyaya Sag click yaptigimizda dosya yolunu görüntüleyebiliriz.
     */

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));//bize icinde bulundugumuz dosya yolunu verir
        System.out.println(System.getProperty("user.home"));//herkesin bilg. farkli olan kismi dinamik olarak verir

        //SORU
        // Desktop(masaustu)'da bir text dosyası olusturun
        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
        /*
        Dosyanin, bilgisayarimda desktop.ta olup olmadigini Java ile test edecegim.
        Cunku Selenium benim bilgisayarimdaki desktop.a müdahale edemez
         */
        //C:\Users\admin\Desktop\text.txt  -->Win10'da sag click, sichereit- Üstte objectName yazan yeri kopyalayın
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\admin\\Desktop\\text.txt")));

        //daha dinamik hale getirelim
        //C:\Users\admin       \Desktop\text.txt
        String einzelnenPart=System.getProperty("user.home"); //herkesin bilgisayarinda farkli olan kisimdir.
        String gemeinsamPart="\\Desktop\\text.txt";  //herkesin bilgisayarinda ortak olan kisim
        String ordnerPfad=einzelnenPart+gemeinsamPart;
        Assert.assertTrue(Files.exists(Paths.get(ordnerPfad)));


    }

    @Test
    public void test01_NT() {
        /*
            Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
        kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
        için;
            Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
        dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
        Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
        assing ederiz.

        NOT:
            Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
            yolunu almak istediğimiz dosyanun üzerine gelip shift+sağKlik tusuna basarak yol olarak kopyala
            seçeneği ile dosya yolunu kopyalayabiliriz.
         */
        String dosyaYolu = "C:/Users/Lenovo/OneDrive/Masaüstü/sen.txt";
        //"C:/Users/Lenovo/OneDrive/Masaüstü/sen.txt"
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02_NT() {
        String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\Selenium  TEstNG son.pptx";
        //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//-->Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    @Test
    public void test03_NT() throws InterruptedException {
        /*
            Bir server'da farkli işlerim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
        daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
        her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
        bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
        atayarak herseferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
        sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assing ederiz
         */
        //-->Dosya yolumuz : "C:/Users/Lenovo/OneDrive/Masaüstü/sen.txt"
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/OneDrive/Masaüstü/sen.txt";
        String dosyaYolu = farkliYol+ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu));//-->Bu şekilde belirtmiş olduğumuz dosyayı sileriz
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//-->Sildiğimiz için assertFalse kullandık

        Thread.sleep(3000);
        //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));//-->Belirtmiş olduğumuz dosyayı oluşturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        /*
            Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
        yukardaki delete işlemini kullanabiliriz
         */
    }

    @Test
    public void test04_NT() {
        /*
            Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */
        String dosyaYolu = "C:/Users/Lenovo/OneDrive/Masaüstü/sen.txt";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}






