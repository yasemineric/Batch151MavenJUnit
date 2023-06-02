package techproed.day13_Cookies_ActionsDTNT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    // https://the-internet.herokuapp.com/context_menu sitesine gidin Kutuya sag tıklayın
// Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
// Tamam diyerek alert'i kapatın


    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/context_menu sitesine gidin Kutuya sag tıklayın
        driver.get("https://the-internet.herokuapp.com/context_menu");
        warten(3);
        driver.switchTo().defaultContent();
        WebElement box=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform();
        //actions objemizle yapacağımız işlemi uygulaması için veya sonlandırması için perform() kullanırız.
        warten(3);
// Alert'te cikan yazinin"You selected a context menu"oldugunu test edin
        Assert.assertEquals("You selected a context menu",getTextAlert());
        //TestBase deki getTextAlert() methodu kullandık --> driver.switchTo().alert().getText();



// Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();
    }
}
