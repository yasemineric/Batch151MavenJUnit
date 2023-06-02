package techproed.day13_Cookies_ActionsDTNT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    //Amazon a gidelim https://www.amazon.com/
//Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
//Acilan sayfanin Title in "Your Account" icerdigini dogrula
    @Test
    public void test01() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
      WebElement kontoList= driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(kontoList).perform();
        WebElement konto=xpath("//span[text()='Konto']");
        konto.click();


//Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Mein Konto"));


    }
}
