package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class C01_WindowHandles extends TestBase {
    //  https://the-internet.herokuapp.com/windows adresine gidin.
//  ilk sayfasının Handle degerini alın yazdırın
//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
//  "Click Here" butonuna tıklayın.
//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
//  ikinci sayfaya tekrar geçin.
//  ilk sayfaya tekrar dönün.

    @Test
    public void test01() {
         /*
        eger bir butona tıkladıgımızda bizim kontrolumuz dısında 2. sayfa acılıyorsa,
        otomatik acılan 2.sayfa'ya driver'ı gecirmemiz gerekir.
        2.sayfa'ya driver'ı gecirebilmemiz icin 2. sayfa'nın handle degerini bulmalıyız
        getwindowHandles(); methodu sayesinde 2. sayfanın handle degerini tespit edebiliriz.
        daha sonra driver.switchTo().window(sayfa2Handle); diyerek 2. sayfa'ya driver'ı gecirebiliriz
         */


        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//  ilk sayfasının Handle degerini alın yazdırın
       String firstPageHandle= driver.getWindowHandle();
        System.out.println(firstPageHandle);
//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement text=driver.findElement(By.xpath("//h3[text()='Opening a new window']"));
        String expectedText="Opening a new window";
        Assert.assertEquals(expectedText, text.getText());
//  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String title=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(expectedTitle,title);

//  "Click Here" butonuna tıklayın.
        WebElement clickButton=driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickButton.click();
//  ikinci sayfa Title'ının "New Window" olduğunu test edin.

        Set<String > allhandle =driver.getWindowHandles();
        //tüm sekmelerin sirasiyla handle degerini verir.
        //bize iki tane handle degeri geldigi icin kodlari ayiklamamiz gerekir.
        // javayi kullanarak "gelen iki handle degerinden sayfa 1in handle degeri olmayan sayfa 2nin handle degeridir"
        //diyerek for loop kullanarak sayfa 2nin handle degerini elde edecegiz
        System.out.println(allhandle);
        String secondPageHandle="";
        for (String w:allhandle) {
            if(!w.equals(firstPageHandle)){
                secondPageHandle=w;
            }
        }
        /*
        String sayfa2HandleDegeri = "" ;
    for (String w : windowHandlesSeti){
    if (w.equals(sayfa1Handle)){
        continue;
    }else {
        sayfa2HandleDegeri = w;
        System.out.println("Sayfa 2 Handle : "+ w);
    }
}
         */
        /* Lambda Version;
        windowHandlesSeti.
        stream().
        filter(t->!t.equals(sayfa1Handle)).
        forEach(t-> System.out.println("2.Sayfa Handle değeri : "+t));
         */

        driver.switchTo().window(secondPageHandle);

        String secondTitle=driver.getTitle();
        String expectedSecondTitle="New Window";
        Assert.assertEquals(expectedSecondTitle,secondTitle);
//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(firstPageHandle);

//  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(secondPageHandle);
//  ilk sayfaya tekrar dönün.
        driver.switchTo().window(firstPageHandle);

    }
}
