package techproed.day13_Cookies_ActionsDTNT;

import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class C01_Cookies extends TestBase {
    //1-Amazon anasayfaya gidin
    //2-tum cookie’leri listeleyin
    //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin  5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    //6-eklediginiz cookie’nin sayfaya eklendigini test edin
    //7-ismi skin olan cookie’yi silin ve silindigini test edin
    //8-tum cookie’leri silin ve silindigini test edin

    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        //2-tum cookie’leri listeleyin
        /*
        driver.manage().getCookies(); methoduyla bir sitedeki cookileri listeleyebiliriz
         */
        Set<Cookie> cookieSet=driver.manage().getCookies();
        int sayac=1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+". cookie : "+ w);
            System.out.println(sayac+". cookieName : "+ w.getName());//-->Sadece Cookielerin ismini alir
            System.out.println(sayac+". cookieName : "+ w.getValue());//Sadece Value.larini alir.

            sayac++;

        }
        //Lambda ile yazdirma;
        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookielerin Sayisi :"+cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue="USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookie);
        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet=driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(each);
        }
        Assert.assertTrue(cookieSet.contains(newCookie));
        //Assert.assertTrue(driver.manage().getCookieNamed("en sevdigim cookie").getValue().equals("cikolatali"));--alternatif
        System.out.println("Cookilerin sayisi :"+Arrays.stream(driver.manage().getCookies().toArray()).count());

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        Cookie deletedCookie=driver.manage().getCookieNamed("skin");
        driver.manage().deleteCookieNamed("skin");
        cookieSet=driver.manage().getCookies();
        Assert.assertFalse(cookieSet.contains(deletedCookie));
        /*
        Alternatif
        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        int silinmedenOnce = cookieSet.size();
        driver.manage().deleteCookieNamed("skin");//-->ismi skin olan cookie'yi sildik
        cookieSet=driver.manage().getCookies()
        int silindiktenSonra = cookieSet.size();
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));
         */
        //Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        //java'nin native methodu olmadigi icin tekrar initialize ediyoruz

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());

        //System.out.println(cookieSet.size());

    }
}
