package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEresmi extends TestBase {

    /*
    Bir webelementin resmini almak icin  önce Webelementi locate edip bir WebElemente assign ederiz
    ve bu WebElementi direk getScreenShotAs() methodunu kullanarak resmini belirttigimiz dosyaya kaydederiz
     */

    @Test
    public void name() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

      warten(2);
      //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

      //çıkan sonuc yazisinin resmini alalım
        WebElement resultSchrift=driver.findElement(By.xpath("//*[@class='sg-col-inner'][1]"));
        String datum = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "src/test/java/techproed/ElementResmi/WEscreenShot" + datum+ ".jpeg";
        FileUtils.copyFile(resultSchrift.getScreenshotAs(OutputType.FILE), new File(filePath));

    }





}
