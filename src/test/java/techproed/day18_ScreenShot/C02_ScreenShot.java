package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ScreenShot extends TestBase {

    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        warten(2);

        //Ve ekran görüntüsünü alalım

        String datum = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String ordnerPath = "src/test/java/techproed/ScreenShot/screenShot" + datum + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        Files.write(Paths.get(ordnerPath),ts.getScreenshotAs(OutputType.BYTES));

    }
}
