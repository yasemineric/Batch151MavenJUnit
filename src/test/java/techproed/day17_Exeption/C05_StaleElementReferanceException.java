package techproed.day17_Exeption;

import org.bouncycastle.util.Arrays;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C05_StaleElementReferanceException extends TestBase {

    @Test
    public void StaleElementReferanceExceptionTest1() {

        //Amazonsayfasina gidelim
        driver.get("https://www.amazon.de/");
        //AramaMotoruna  iphone   yazip aratalim
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone" + Keys.ENTER);
        // cıkan sonuclardan ilk 5'ine tıklayıp sayfa baslıklarını alalım konsola yazdıralım

        driver.findElement(By.xpath("//input[@name='accept']")).click();

        List<WebElement> productList=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
        for (int i = 0; i < productList.size(); i++) {
            productList=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
            //tekrar webelementi hatirlaticagiz bu nedenle forloop icine webelementin locatini kopyaladik
            productList.get(i).click();
            System.out.println(i+1+ ".URUN TITLE: "+driver.getTitle());
            driver.navigate().back();
            if (i==4){
                break;
            }

        }






    }
}
