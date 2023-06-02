package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    //Techproeducation sayfasina gidiniz.
    //Basligin bootcamp icerdigini test ediniz


    @Test
    public void test01() {
        driver.get("https://techproeducation.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));



    }
}
