package techproed.day10_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

public class C04_DropDownReusableMethod extends TestBase {

    /*
    DropDown: Alt basliklarin oldugu acilir menu listesidir.
    DropDown 3 adimda handle edilir.
    1-) DropDown locate edilmelidir.

    2-) Select objesi olusturulmalidir;
    Select select=new Select(ddm)

    3-) Opsiyonlardan bir tanesi secilir.
    -selectByVisibleText() ==> option.a görünür metin ile ulasmak icin kullanilir
    -selectByIndex() ==> option.a index ile ulasmak icin kullanilir(index 0 ile baslar)
    -selectByValue() ==> option.a value degeri ile ulasilir.

     */
    /*
     // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz

    // Yıl Drodown'undan "2020" seciniz

    // Ay Dropdown'undan "August" seciniz

    // Gün Dropdown'undan "5" seciniz
     */


        @Test
        public void test01()  {
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

            // Yıl Drodown'undan "2020" seciniz
            WebElement year= driver.findElement(By.xpath("//select[@id='year']"));
            selectVisibleText(year,"2020");
            warten(3);
            // Ay Dropdown'undan "August" seciniz
            WebElement month= driver.findElement(By.xpath("//select[@id='month']"));
            selectVisibleText(month,"August");
            warten(3);


            // Gün Dropdown'undan "5" seciniz
            WebElement day= driver.findElement(By.xpath("//select[@id='day']"));
            selectVisibleText(day,"5");
            warten(3);


        }

    /*
    // Ay Dropdown'undan "August" seciniz
    WebElement ddmAy = driver.findElement(By.xpath("//select[@id='month']"));//id ile locate aldik

    Select select2 = new Select(ddmAy);//obje olusturduk

    //select2.selectByVisibleText("August");//görünen sekilde yapistirdik/yazdik. karakter hatasi olmamali.

    //select2.selectByIndex(7);//index 0 ve en yukaridan baslar. august 8. sirada ve 7. indextedir.

    select2.selectByValue("7");
    //ay dropdown una sag click incele dedik, select html kodunun yaninda bulunan ok isaretine tikladik,
    // aylarin value degeri görünür, ayin yanindaki value degerini sayisal olarak paranteze ekledik
     */


}
