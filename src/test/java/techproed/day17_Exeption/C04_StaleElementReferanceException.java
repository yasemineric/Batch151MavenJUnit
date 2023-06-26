package techproed.day17_Exeption;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferanceException extends TestBase {

    /*
    StaleElementReferanceException:
    bir websayfasindaki bir webelementin gecerliliginin kayboldugu durumlarda olusur.
    Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullaniyorsak
    yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasini aliriz.
    Bunu handle edebilmek icin webelemente yeniden ayni locate.i atamaliyiz.
    (webelementin locate.ni hatirlatmak gibi diyyebiliriz)
     */

    @Test
    public void StaleElementReferenceException1() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        warten(2);

        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        warten(2);

        //sayfayi yenileyelim
        driver.navigate().refresh(); //navigate'den önceki locate'ler bayatlar ve tekrar kullanamayiz.
        //LMS Login butonuna tiklayalim
        driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]")).click();

    }


    @Test
    public void StaleElementReferenceException2() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        warten(2);

        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        warten(2);
        //LMS Login butonunun Locate.ini alalim
        WebElement lmsLogin=driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        //sayfayi yenileyelim
        driver.navigate().refresh(); //navigate'den önceki locate'ler bayatlar ve tekrar kullanamayiz.
        //LMS Login butonuna tiklayalim
       lmsLogin.click();

    }
}
