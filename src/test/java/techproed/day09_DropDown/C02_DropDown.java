package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.ClientStats;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*
-getFirstSelectedOption() ==> Dropdown`daki en son sectigimiz option`u bize dondurur.

-getOptions() ==> Dropdown`daki tum optionlari bize dondurur.
 */

    // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
    // Select a State Dropdown'undan "Arizona" seciniz
    // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
    // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
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
    public void test01() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
        Select select1=new Select(state);
        select1.selectByVisibleText("Arizona");
        //select1.selectByValue("AZ");
        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
        WebElement lastOption=select1.getFirstSelectedOption();
        String lastOptionStr=lastOption.getText();//String.e cevirmeliyiz

        Assert.assertEquals("Arizona",lastOptionStr);
        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız

        List<WebElement> allStates=select1.getOptions();

       /* for (WebElement each:allStates) {
            System.out.println(each.getText());

        }

        */
        //lambda ile yapilisi
        allStates.
                stream().
                forEach(t-> System.out.println(t.getText()));


        //2.yol
        List<WebElement> tümOpsiyonlar=driver.findElements(By.xpath("//select[@id='state']//option"));
        // burada //option tüm optionlari secmemizi saglar
        tümOpsiyonlar.stream().forEach(t-> System.out.println(t.getText()));
        }




}
