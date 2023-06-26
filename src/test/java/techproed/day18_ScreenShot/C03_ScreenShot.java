package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_ScreenShot extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        warten(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        ss();

    }
}
