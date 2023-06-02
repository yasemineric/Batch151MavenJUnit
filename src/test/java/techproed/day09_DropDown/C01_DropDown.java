package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_DropDown {
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

    WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws Exception {
       // driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Yıl Drodown'undan "2020" seciniz
        WebElement year= driver.findElement(By.xpath("//select[@id='year']"));
        Select select1=new Select(year);
        select1.selectByVisibleText("2020");
        Thread.sleep(3000);
        // Ay Dropdown'undan "August" seciniz
        WebElement month= driver.findElement(By.xpath("//select[@id='month']"));
        Select select2=new Select(month);
        select2.selectByVisibleText("August");
        Thread.sleep(3000);


        // Gün Dropdown'undan "5" seciniz
        WebElement day= driver.findElement(By.xpath("//select[@id='day']"));
        Select select3=new Select(day);
        select3.selectByVisibleText("5");
        Thread.sleep(3000);


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
