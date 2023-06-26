package techproed.Tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C05_Task05 extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// ikinci emojiye tıklayın
// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz


    @Test
    public void test01() {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        warten(2);
        WebElement zweiteEmoji=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        zweiteEmoji.click();
        // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojisList=driver.findElements(By.xpath("//div[@id='nature']//div"));
        for (WebElement w: emojisList) {
            System.out.println(w.getText());
        }

      // Parent iframe e geri donun
        driver.switchTo().defaultContent();
      // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> textList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> dataien=new ArrayList<>(Arrays.asList(
                "Yasemin", "Yas", "Planzen","Pommes","Fahrrad Fahren","Wald", "Spielzeugen", "Nature","Freiheit","vjlsj","ksfkd"
        ));
        for (int i = 0; i < textList.size(); i++) {
            textList.get(i).sendKeys(dataien.get(i));

        }

        // Apply button a basiniz
        driver.findElement(By.xpath("//button[text()='Apply']")).click();




    }
}
