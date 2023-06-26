package techproed.day17_Exeption;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NosSuchElementException extends TestBase {
    /*
        NoSuchElementException:
         Sayfada bulunmayan bir elemenente erisim saglanmaya calisildiginde
        NoSuchElementException hatasi aliriz.

         /*
     NoSuchElementException:
Yanlis locator
Popup, yeni pencere, iframe,…
Sayfa dolmada problemler ve yavaslamalar
Sakli olan elementle

            Solution:
Locatorin dogrulugunu tekrar kontrol et
Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada
fluent wait kullaniriz
     */




    @Test
    public void NoSuchElementException() {

        //techproEducation sayfasina gidiniz.
        driver.get("https://techproeducation.com/");
        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //searchBox'a java yazip aratalim
        driver.findElement(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")).sendKeys("Java", Keys.ENTER);

    }
}
