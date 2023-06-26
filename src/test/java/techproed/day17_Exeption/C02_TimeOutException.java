package techproed.day17_Exeption;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
            TimeOutException:
Explicit wait kullanildiginda, ve element bulunamadiginda
alinir.
Explicit wait & yanlis locator-> timeout
Explicit wait & doğru locator & sure yeterli degil -> timeout
Explicit wait & dogru locator & sure yeterli & iframe var ->
time out


            Solution:
-Sureyi arttirmak
-Farkli explicit kullanmak: wait visibilityOfElementLocated
YERINE presenceOfElementLocated. Yada javascript executor
da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
-Locatori tekrar kontrol etmek
-Frameworkunde hazir reusable method lar var Bu durumda
timeoutexception aldigimda hızlıca o metotlar yardımıyla
problemi cozebiliyoruz

 */


    @Test
    public void TimeOutException() {
        /*
        TimeOut Exception sayfada aradigimiz elementi wait ile belirttigimiz
         max. sürede bulamadigimiz durumda TimeOutException hatasi aliriz
         */

        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com/");
        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //searchBox görünür oluncaya kadar bekleyiniz
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")));

               /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        */

    }

    @Test
    public void TimeOutException_02() {
        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        // Start butonuna tıklayınız
         // Hello World! yazısının görünürlügünü test ediniz

        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();
         // Hello World! yazısının görünürlügünü test ediniz
        WebElement hello=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        Assert.assertTrue(hello.isDisplayed());
        /*
gercekte Hello World! yazisi ortalama 6 saniyede gozukuyor
TimeOutException alabilmek icin Explicit Wait'e max bekleme sureisni 1 saniye verdik.
Bu sebeple TimeOutException hatasi aldik.
 */



    }
}
