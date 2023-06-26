package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_ExplicitWait extends TestBase {
    // Implictly Wait==> Sayfadaki tüm webelementlerim yüklenebilmesi icin max. bekleme süresi
    // Explict Wait==> Belirli bir kosul gerceklesene kadar max sure boyunca
    // default olarak 500ms aralıklarla webelementi kontrol ederek bekler.
    // (sadece belirli bir webelement icin kullanılır)


        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        //==> Start buttonuna tıklayın
        //==> Hello World! yazısının görünürlügünü test edin

    @Test
    public void explicitWait() {

        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //==> Hello World! yazısının görünürlügünü test edin
        WebElement helloWorldYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        visibleWait(helloWorldYazisi,100);
        Assert.assertTrue(helloWorldYazisi.isDisplayed());

    }

}
