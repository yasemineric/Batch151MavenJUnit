package techproed.day07_Mave_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Odev {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        C01_TekrarTesti isimli bir class  olusturun
https://www.google.com/  adresine gidin
cookies uyarisini  kabul ederek kapatin
Sayfa	basliginin	"Google"	ifadesi	icerdigini	test  edin
Arama cubuguna "Nutella" yazip aratin
Bulunan sonuc sayisini yazdirin
sonuc sayisinin 10 milyon'dan fazla oldugunu test  edin
Sayfayi kapatin



         */

        /*
        "https://www.saucedemo.com" Adresine gidin
Username kutusuna "standard_user" yazdirin
Password kutusuna "secret_sauce" yazdirin
Login tusuna basin
Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
Add to Cart butonuna basin
Alisveris sepetine tiklayin
Sectiginiz urunun basarili olarak sepete eklendigini control  edin
Sayfayi kapatin
         */





    }

    }
