package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    //==>   https://testcenter.techproeducation.com/index.php?page=iframe
//==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
//==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
//==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin


    @Test
    public void test01() {
        //==>   https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");
        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        WebElement anIframeScreibt=driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']"));
        Assert.assertTrue(anIframeScreibt.getText().contains("black border"));
        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim

        /*
       Applications lists yazisini dogru locate edip,
       dogru sekilde gorunur oldugunu test etmemize ragmen Failed oldu
       bunun uzerine HTML kodlarini inceleyince
       Applications lists yazisinin aslinda bir iframe icerisinde oldugunu gorduk
       bu durumda once iframe'i locate edip
       switchTo() ile iframe'e gecmeliyiz
        */

        //ctrl+F ile iframe diye arattıktan sonra incelemek daha kolay oluyor yeşile boyuyor
        WebElement iframe=driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']"));
        driver.switchTo().frame(iframe);
        WebElement iframeList=driver.findElement(By.xpath("//h1[text()='Applications lists']"));
        Assert.assertTrue(iframeList.isDisplayed());
        //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
        driver.switchTo().defaultContent();// driver.i distaki websayfasina cikarmis olduk
        WebElement powerBy= driver.findElement(By.xpath("//p[text()='Povered By']"));
        Assert.assertTrue(powerBy.getText().contains("Povered By"));
        ////bir üst seviyedeki frame e cikmak icin parent frame(); kullanilir
        //// en üstteki web sayfasina cikmak icin defaultContent(); kullanilir




    }
}
