package techproed.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    // Fluent Wait ==> Belirli bir kosul gerceklesene kadar max sure boyunca,
// belittigimiz aralıklarla webelementi kontrol ederek bekler.

    //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
    //==> Start buttonuna tıklayın
    //==> Hello World! yazısının görünürlügünü test edin
    @Test
    public void test01() {
        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //==> Start buttonuna tıklayın
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //==> Hello World! yazısının görünürlügünü test edin

        //withTimeout(); Fluent Wait icin max bekleme süresidir.
        //pollingEvery(); kac saniyede bir webelementin yüklendigini kontrol edecegini belirler.
        //withMessage() hata verdiginde konsolda görünecek mesaji belirtir.Zorunlu degildir. Inisiyatif.
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Wait<WebDriver> wait=new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).
                pollingEvery(Duration.ofSeconds(3)).
                withMessage("Ignore Exception");

        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assert.assertTrue(helloWorld.isDisplayed());



    }
}
