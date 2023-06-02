package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertion {
    // 4 tane test methodu olusturun
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
        driver.close();
    }

// test01
// https://amazon.com sayfasına gidin
// sayfa baslıgının "Amazon" kelimesini icerdigini test edin

    @Test
    public void test01() {
        driver.get("https://amazon.com");
        String sayfaBasligi=driver.getTitle();
        Assert.assertTrue(sayfaBasligi.contains("Amazon"));

    }

// test02
// https://amazon.com sayfasına gidin
// Amazon resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void test02() {
        driver.get("https://amazon.com");
        WebElement amazonLogo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(amazonLogo.isDisplayed());
    }


// test03
// https://amazon.com sayfasına gidin
// arama kutusunun erisilebilir oldugunu test edin

    @Test
    public void test03() {
        driver.get("https://amazon.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Assert.assertTrue(aramaKutusu.isEnabled());

    }


// test04
// https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin


    @Test
    public void test04() {
        driver.get("https://amazon.com");
        String sayfaBasligi=driver.getTitle();
        Assert.assertFalse(sayfaBasligi.contains("Kitap"));
    }
}
