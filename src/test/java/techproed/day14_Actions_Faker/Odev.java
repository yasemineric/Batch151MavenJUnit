package techproed.day14_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev extends TestBase {
    /*
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over  Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin  8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
     */

    @Test
    public void test01() {

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

   // 2- Hover over  Me First" kutusunun ustune gelin
        WebElement hoverBox=xpath("//button[text()='Hover Over Me First!']");
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverBox).perform();
        warten(3);
    //3- Link 1" e tiklayin
        WebElement link=xpath("(//a[text()='Link 1'])[1]");
        actions.moveToElement(link).click().perform();

    //4- Popup mesajini yazdirin
        driver.switchTo().alert();
        System.out.println(getTextAlert());

        //
        warten(3);

        //5- Popup'i tamam diyerek kapatin
        alertAccept();
        warten(3);
    //6- “Click and hold" kutusuna basili tutun
        WebElement clickBox=xpath("//div[@id='click-box']");
        actions.clickAndHold(clickBox).perform();
        warten(3);

    //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(actions.clickAndHold(clickBox).getActiveKeyboard());
        warten(3);

        // 8- “Double click me" butonunu cift tiklayin.
        WebElement doubleClick=driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClick).perform();
        // Tıklandığını test edin
        String actualClass=doubleClick.getAttribute("class");
        String expectedClass="div-double-click double";
        Assert.assertEquals(expectedClass,actualClass);








    }
}
