package techproed.Tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_Task6 extends TestBase {
     //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
     //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
     //- Çizimden sonra clear butonuna basınız
     //- Sayfayi kapatiniz

    @Test
    public void test01() {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement ekran=driver.findElement(By.xpath("//canvas[@style='touch-action: none; user-select: none;']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(ekran).moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50)
                .moveByOffset(-50, 30)
                .moveByOffset(-30, -30)
                .moveByOffset(50, -30)
                .moveByOffset(30, 50).
                release().perform();
        warten(3);
        //- Çizimden sonra clear butonuna basınız
        WebElement clear=driver.findElement(By.xpath("//button[text()='Clear']"));
        clear.click();
        warten(3);
        //- Sayfayi kapatiniz
        driver.close();


    }
    @Test
    public void test02() {
        driver.get("http://szimek.github.io/signature_pad/");

        WebElement canvas = driver.findElement(By.xpath("(//*[@class='signature-pad--body'])/canvas"));
        int canvasWidth = canvas.getSize().getWidth();
        int canvasHeight = canvas.getSize().getHeight();
        int centerX = canvasWidth / 2;
        int centerY = canvasHeight / 2;
        int radius = Math.min(canvasWidth, canvasHeight) / 4; // Yarı çapı canvas boyutlarına gore ayarlama
        int numPoints = 5;
        double angle = 2 * Math.PI / numPoints;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Yıldız çizimini JavaScript kodu ile gerçekleştir
        StringBuilder jsCode = new StringBuilder();
        jsCode.append("var canvas = arguments[0];");
        jsCode.append("var context = canvas.getContext('2d');");
        jsCode.append("context.beginPath();");
        jsCode.append("context.moveTo(arguments[1], arguments[2]);");

        for (int i = 1; i <= numPoints * 2; i++) {
            int x, y;
            if (i % 2 == 0) {
                x = (int) (centerX + radius * Math.cos(i * angle));
                y = (int) (centerY + radius * Math.sin(i * angle));
            } else {
                x = centerX;
                y = centerY;
            }
            jsCode.append("context.lineTo(").append(x).append(",").append(y).append(");");
        }

        jsCode.append("context.closePath();");
        jsCode.append("context.stroke();");

        js.executeScript(jsCode.toString(), canvas, centerX, centerY);

}
}
