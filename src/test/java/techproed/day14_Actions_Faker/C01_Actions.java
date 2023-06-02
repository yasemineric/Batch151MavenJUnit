package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;
import org.openqa.selenium.interactions.Actions;
//techpro sayfasina gidelim
//sayfanin altina dogru gidelim
//sayfanin ustune dogru gidelim

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //sayfanin altina dogru gidelim
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //sayfanin ustune dogru gidelim
        action.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();


    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        warten(2);
        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END); //Bu sayfanin en altina gider
        warten(3);

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).build().perform();
        //keys.Home-->Bu sayfanin en üstüne gider
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
//objesini birbirine bağlar
        //build().perform()-->methodu ile diger actions.lara da perform atamis oluyoruz
        ////release()-->methodu mouse'u serbest birakir

        //Eger yapilan islemin cok hizli olmasini istemiyorsak
        // build() kullanmak yerine her action'dan sonra perform() kullanmamiz gerekir.

        /*
her actions dan sonra perform kullanmazsak olay cok seri gerceklesir.
build kullandigimizda olay milisaniye icinde gerceklesir.
araya bekle methodu koysak bile java build methodunun oldugu kisimda sayfayi asagi yaparak hizli sekilde gerceklestirir

release() methodu kutuyu bir yerrden sürükleme veya eslestirme gibi konulari yaparken
mouseyi cekip birakmali sorularda release() methodu kullanilir
actionsta mouseta sürükleme islemi yapiyorsak serbest birakma islemi icin release() methodu kullanilir.
 */

    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        warten(2);
        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();
        warten(3);

        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();

    }





}
