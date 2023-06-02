package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    /*
    -Authentication kimlik dogrulama yöntemidir.
    -Söz konusu sisteme dahil olunup oplunamayacagi belirleyen formu ifade eder.
    -Authentication üzerinde sag click yapip locate alinamaz.
    -Authentication bir alert degildir bir kmlik dogulama yöntemidir.
    -Authentication yapabilmek icin uygulamanin kullanicilara,
    authentication.u nasil yapacagina dair bilgilendirme yapmis olmasi gerekir
    -https://username:password@URL gibi
     */
    /*
calistigimiz sirket authentication formatini bize vermek zorundadir. onlarin istedigi sekilde yapiyoruz
 */

    // Aşağıdaki bilgileri kullanarak authentication yapınız:
    // Url: https://the-internet.herokuapp.com/basic_auth
    // Username: admin
    // Password: admin
    //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız


    @Test
    public void authentication() {
        // Aşağıdaki bilgileri kullanarak authentication yapınız:
         /*
         https://username:password@URL
        Yukarıda belirtilen formata uygun kimlik dogrulaması yapılacaktır
         */

        // Url: https://the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        // Username: admin
        // Password: admin
        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        WebElement paragraph=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraph.getText().contains("Congratulations"));



    }
}
