package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {

    @Test
    public void acceptAlert()  {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click(); // //button[text()='Click for JS Alert']
        //uyarıdaki OK butonuna tıklayın
        //Butonda sag klick calismadigi icin driver.i alert.a gecirecegiz.
        warten(3);
        driver.switchTo().alert().accept();
        //switchTo(); gecmek degistirmek anlaminda kullanilir.
        // alert() driver i bulundugu konumdan alert durumna gecirir.
        //accept(); cikan uyarida ok veya tamam butonuna bas.
        warten(3);

        //ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void dismissAlert() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        //uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        //ve result mesajının "successfuly" icermedigini test edin.
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult="successfully";
        Assert.assertFalse(actualResult.contains(expectedResult));


    }

    @Test
    public void sendKeysAlert() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        //uyarıdaki mesajı konsolda yazdırın,
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);

        //uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Yasemin");
        Thread.sleep(2000);
        //OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        //ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult="Yasemin";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }

    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.


    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.

    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.

    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */
}
