package techproed.day09_DropDown;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C03_DropDown {
    // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
    // Programlama Dili Dropdown'undan "Java" seciniz
    // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
    // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws Exception {
        //driver.close();
    }
    @Test
    public void test01() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        // Programlama Dili Dropdown'undan "Java" seciniz
        WebElement language=driver.findElement(By.xpath("//select[@name='Languages']"));
        Select select1= new Select(language);
        select1.selectByVisibleText("Java");
        // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
        WebElement lastSelected=select1.getFirstSelectedOption();
        String lastSelectedStr=lastSelected.getText();
        Assert.assertEquals("Java", lastSelectedStr);
        // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız

        List<WebElement> allOptions=driver.findElements(By.xpath("//select[@name='Languages']//option"));
        allOptions.stream().forEach(t-> System.out.println(t.getText()));

        // Sayfadaki tum Dropdown'lardaki tum optionları konsolda yazdırınız
        List<WebElement> allOptionAllDropdown=driver.findElements(By.tagName("option"));
        allOptionAllDropdown.stream().forEach(t-> System.out.println(t.getText()));


    }


}
