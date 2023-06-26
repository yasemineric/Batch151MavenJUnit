package techproed.day17_Exeption;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase {
    /*
NullPointerException:

degisken yada obje olusturup bu degiskene atama yapmadigimizda yada esitlemedigimizde
NullPointerException hatasi aliriz.
 */
    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    String isim;


    @Test
    public void NullPointerExceptionTest1() {
        // driver = new ChromeDriver(); atamasını yapmadıgımız icin NullPointerException hatasını aldık.
        driver.get("https://www.amazon.de/");
    }

    @Test
    public void NullPointerExceptionTest2() {
        // faker = new Faker(); atamasını yapmadıgımız icin NullPointerException hatasını aldık.
        System.out.println(faker.name().firstName());
    }

    @Test
    public void NullPointerExceptionTest3() {
        // actions = new Actions() atamasını yapmadıgımız icin NullPointerException hatasını aldık
        actions.doubleClick().perform();

    }

    @Test
    public void NullPointerExceptionTest4() {
        // sayi=6; sayi degiskenine atama yapmadıgımız icin NullPointerException hatası aldık.
        System.out.println(sayi+5);

    }

    @Test
    public void NullPointerException5() {

        //isim="Esma"; isim degiskenine atama yapilmadigi icin NullPointerException hatasini aldik
        System.out.println(isim.charAt(0));
    }

}
