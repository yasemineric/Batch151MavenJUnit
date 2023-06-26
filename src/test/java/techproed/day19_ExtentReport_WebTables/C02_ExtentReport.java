package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_ExtentReport extends TestBase {

    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi");
        extentTest=extentReports.createTest("ExtentReport","Test Raporu");

        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        //sayfanın resmini alınız
        ss();
        extentTest.info("Sayfanin resmi alindi");//Das Bild der Seite wurde kopiert


        //arama kutusunda iphone aratınız//Suchen Sie im Suchfeld nach iPhone
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");

        extentReports.flush();


    }
}
