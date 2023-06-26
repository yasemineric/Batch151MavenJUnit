package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {
    //Techproeducation sayfasına gidelim
//sayfanın resmini alalım
//Arama bölümünde java aratalım
//ve sonuc yazısının resmini alalım
//Yeni bir sekmede amazona gidelim
//sayfanın resmini alalım
//arama bölümde iphone aratalım
//ve sonuc yazısının resmini alalım
//tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");
        String seite1=driver.getWindowHandle();
//sayfanın resmini alalım
        ss();
//Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("java", Keys.ENTER);
//ve sonuc yazısının resmini alalım
        WebElement resultScrift= driver.findElement(By.xpath("//h1[@class='elementor-heading-title elementor-size-default']"));
        webElementSS(resultScrift);
//Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.de/");
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        warten(2);
//sayfanın resmini alalım
        ss();
//arama bölümde iphone aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
//ve sonuc yazısının resmini alalım
        WebElement iphoneResultSchrift=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        webElementSS(iphoneResultSchrift);
//tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        driver.switchTo().window(seite1);
        ss();
    }


    @Test
    public void test02() { //hocadan
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//-->Reklamı kapatır
        warten(2);
        //sayfanın resmini alalım
        ss();//-->Method ile tüm sayfanın resmini aldık
        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//*[@id='elementor-search-form-9f26725']")).
                sendKeys("java", Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webElementSS(sonucYazisi);//-->Method ile weblement'in resmini aldık
        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        //sayfanın resmini alalım
        ss();//-->Method ile tüm sayfanın resmini aldık
        //arama bölümde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        WebElement amazonSonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        webElementSS(amazonSonucYazisi);
        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchWindow(0);
        ss();
    }





}
