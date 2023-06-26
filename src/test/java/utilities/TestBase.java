package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class TestBase {
    protected ExtentReports extentReports; //-->Raporlamayı başlatmak için kullanılan class
    protected ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTML formatında düzenler
    protected ExtentTest extentTest;//--> Test adınlarına eklemek istediğimiz bilgileri bu class ile oluştururuz
    /*
        TestBase class'ından obje oluşturmanın önüne geçmek için bu class'ı abstract yapabiliriz.
    TestBase testBase = new TestBase(); yani bu şekilde obje oluşturmanın önüne geçmiş oluruz.
    Bu class'a extends yaptığımız test class'larından ulaşabiliriz
     */
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
        //extentReports=new ExtentReports();//farkli bir method icerisinde initialize yapmazsak null pointer exception verir
        //extentReports.flush();
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
    public void switchWindow(int index){
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }
    //xpath
    public WebElement xpath(String xpath){
        return driver.findElement(By.xpath(xpath));
    }


    //implicitlyWait() sayfadaki tüm elementlerin max bekleme süresidir. bizim isimizi %80 halleder
//bu method ile cogu yerde isimizi halleder.
//explicitlywait() %20 oraninda kullaniriz. Sadece belirli bir webelement icin kullanilir.Belirli bir
//kosul gerceklesene kadar max süre boyunca bekletir. Max süreyi biz belirleriz.


    //Selenium Wait/Explicit Wait
    //visibilityOf(element) methodu
    public void visibleWait(WebElement element,int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //visibilityOfElementLocated(locator) methodu
    public void visibleWaitByLocator(By locator, int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //AlertWait methodu
    public void alertWait(int saniye){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    //FluentWait visible Methodu
    public void visibleFluentWait(WebElement element,int saniye,int milisaniye){
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).
                until(ExpectedConditions.visibilityOf(element));
    }

    //Tüm Sayfa Resmi(ScreenShot)
    public void ss() {
        String datum = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String ordnerPath = "src/test/java/techproed/ScreenShot/screenShot" + datum + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(ordnerPath),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //exception method icinde handle edilmezse method signature icinde handle edilir,
        // orada da handle edilmezse parent classlarda handle edilir.

    }


    //WebElement Resmi (ScreenShot)
    public void webElementSS(WebElement element){
        String datum = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String filePath = "src/test/java/techproed/ElementResmi/WEscreenShot" + datum+ ".jpeg";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //UploadFile Robot Class
    public void uploadFilePath(String filePath) {
        try {
            warten(3);
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            warten(3);
            robot.keyPress(KeyEvent.VK_V);
            warten(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            warten(3);
            robot.keyRelease(KeyEvent.VK_V);
            warten(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            warten(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            warten(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    //Extent Report Methodu
    public void extentReport(String browser,String reportName){
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//-->HTML formatında raporlamayı başlatacak
        //Raporda gözükmesini isteğimiz bilgiler için
        extentReports.setSystemInfo("Browser",browser);
        extentReports.setSystemInfo("Tester","Yasemin");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName(reportName);

    }











}

