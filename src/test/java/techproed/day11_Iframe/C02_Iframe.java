package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
//==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
//==>  textBox içindeki yazıyı siliniz.
//==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
//==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.

    @Test
    public void test02() {
        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        WebElement dickeSchreibt=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(dickeSchreibt.getText().contains("Editor"));

//==    >  textBox içindeki yazıyı siliniz.
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        // iframe locate edildi, switchTo ile icteki website gecildi.
        WebElement textBox=driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();
        // textBox locate edildi ve icindeki silindi.


//==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
//==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSel=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSel.isDisplayed());
    }
    //Birden fazla iframe oldugu zaman onlarin kac tane oldugu nasil anlariz
//ve kac adet oldugu ile ilgil sonuc yazdirabilir miyiz?
//herhanbgi bir dongu icine mi almamiz gerekir?

//web sayfasina gideriz, sag click incele deriz, html kodlari gelir, alttaki cubuga //iframe yazariz
// sagdaki kisimda 1 of 1 oldugunda 1 tane iframe oldugunu görürüz.
// iframe yazarsak bu sayfada bulunan iframe taglarini getirir
//kodlarda anlöamak icin bu yöntemi kullaniriz. iframe olup olmadigini bu sekilde anlariz
    /*
    How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
    ● ***Iframe ler iframe tagi kullanılarak oluşturulur.
    Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum ●
     ***driver.findElements(By.tagName(“iframe”)); ● ***driver.findElements(By.xpath(“//iframe”));
     */





}
