package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_windowHandle extends TestBase {

//  https://www.techproeducation.com adresine gidiniz
//  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
//  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
//  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
//  techproeducation sayfasına geçiniz
//  youtube sayfasına geçiniz
//  linkedIn sayfasına geçiniz:

    /*
        Eğer sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle başka sayfaya gittikten sonra
        tekrar ilk açtığınız sayfaya dönmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir değişkene handle değerini assingn ederseniz tekrar ilk açılan sayfaya dönmek istediğinizde
        driver.switchTo().window(ilksayfaHandleDeğeri) ile geçiş yapabilirsiniz.
         */

    @Test
    public void test01() {
        //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techProHandle=driver.getWindowHandle();
        System.out.println(techProHandle);
        //Techpro sayfasinin handle degerini daha sonra kullanmak üzere getWindowHandle() methodu ile alabiliriz
        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actualtitle=driver.getTitle();
        String expectedTitle="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualtitle);

       //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeHandle=driver.getWindowHandle();
        System.out.println(youtubeHandle);

       //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);// driver.i yeni bir pencereye tasir
        //WindowType.TAB==>Sayet pecere degil de yeni sekme acmak isteseydik WindowType.TAB degerini girmeliydik
        driver.get("https://www.linkedin.com");
        String linkedinHandle=driver.getWindowHandle();
        System.out.println(linkedinHandle);

       //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techProHandle);
        warten(3);
       //  youtube sayfasına geçiniz
        driver.switchTo().window(youtubeHandle);
        warten(3);
       //  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinHandle);
        warten(3);
    }
}
