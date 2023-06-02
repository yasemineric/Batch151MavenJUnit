package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //TestBase Class.a extend ettigimiz test classlarindan ulasabiliriz
    //TestBase classinda obje olusturulmasini istemiyoruz, depo olarak kullanacagiz
    //Bu nedenle abstract yapiyoruz
    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }

    public void warten(int saniye){ //warten(3) yazdigimizda 3 saniyeyi 3000 ms yapiyor
        try {
            Thread.sleep(saniye*1000);//saniyeyi milisaniyeye ceviriyoruz
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }//test classlarinda classi extends ettikten sonra uzun uzun thread sleep yazmak yerine bekle() yazacagiz.
//ve exception uyarisi vermeyecek burada try catch yaptigimiz icin clas kendisi handle edecek ve uyari almayacagiz

    public void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public void alertPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //AcceptAlert
    public void alertAccept(){
        driver.switchTo().alert().accept();
    }


    //getTextAlert
    public String getTextAlert(){
        return driver.switchTo().alert().getText();
    }

    //sendKeysAlert
    public void sendKeysAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
     public void selectVisibleText(WebElement ddm,String wahl){
         Select select=new Select(ddm);
         select.selectByVisibleText(wahl);
     }

    //DropDown Index
    public void selectIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm,String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }
    //SwitchTo Window-1
    public void switchToWindow1(int index){
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));
    }
    //SwitchTo Window-2
    public void switchToWindow2(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }
    //xpath
    public WebElement xpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }



}

