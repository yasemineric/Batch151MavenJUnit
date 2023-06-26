package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
    raporla ilgili bilgileri rapora ekleyebiliriz
     */

public class C01_ExtentReport extends TestBase {

    //ExtentReport diyince aklimiza 3 class gelmeli!!! ==> ExtentReports, ExtentHtmlReporter, ExtentTest
    //Wenn wir ExtentReport sagen, sollten wir an 3 Klassen denken!!! ==> ExtentReports, ExtentHtmlReporter, ExtentTest
    /*
    ExtentReport:
    1) ExtentReport kullanabilmek icin öncelikle MVN adresinden 4.0.9 versiyon numarali
    dependency'i pom.xml dosyamiza ekleriz
    //Um ExtentReport verwenden zu können, müssen Sie zuerst die Versionsnummer
    4.0.9 von MVN herunterladen
    //    Wir fügen die Abhängigkeit zu unserer POM.xml Datei hinzu
    2) ExtentReports classindan class seviyesinde obje olustururuz
    Wir erstellen Objekte auf Klassenebene aus der ExtentReports-Klasse

    3)ExtentHtmlReporter classindan class seviyesinde obje olustururuz
    4)ExtentTest classindan class seviyesinde obje olustururuz
     */
    ExtentReports extentReports; //Raporlamayi baslatmak icin kullanilan classtir.
    // Die Klasse, mit der die Berichterstellung gestartet wurde.
    ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatinda düzenler
    // Organisiert den Bericht im HTML-Format
    ExtentTest extentTest;//Test adımlarına eklemek istediğimiz bilgileri bu class ile oluştururuz
    //Mit dieser Klasse erstellen wir die Informationen, die wir den Testschritten hinzufügen möchten

    @Test
    public void test01() {
        extentReports=new ExtentReports();
        String datum= new SimpleDateFormat("_hh_mm_ss_ddMMyyy").format(new Date());
        String filePath="testOutput/extentReports/extentReport"+datum+".html";
        extentHtmlReporter=new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter); //HTML formatinda raporlamayi baslatacak.
        //Startet die Berichterstellung im HTML-Format
        // htmlReport.u extent Report.a attach yapacak ve raporlamayi baslatacak

        //Raporda gözükmesini istedigimiz bilgiler icin;
        //Für die Informationen, die im Bericht erscheinen sollen;
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Yasemin");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Report");
        extentTest=extentReports.createTest("ExtentTest", "Test Reports");

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");
        warten(2);

       //Basligin amazon icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Basligin Amazon icerdigi test edildi"); //Getestet, ob der Titel Amazon enthält

        warten(3);
       //arama kutusunda iphine aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");//'iPhone' im Suchfeld gesucht
       //sonuc yazisini konsola yazdiralim
        warten(2);
        WebElement resultSchrift= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("resultSchrift = " + resultSchrift.getText());
        extentTest.info("Sonuc yazisi konsola yazdirildi"); //Der Ergebnistext wurde auf der Konsole ausgegeben
        extentTest.pass("Sayfa kapatildi");//Seite geschlossen //Sayfayi kapatirken enson pass kullaniliyor.
        extentReports.flush();//-->bu methodu kullanmazsak raporumuz olusmaz
        //-->Wenn wir diese Methode nicht verwenden, wird unser Bericht nicht generiert

        /*
        extentTest objesi ile info() methodunu kullanarak her step'de ne yaptığımızla alakalı bilgi yazabiliriz
testimizin en sonunda testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi
ekleyebiliriz.
    Ve son olarak actions daki perform methodu gibi extentReport objesi ile flush() methodu kullanarak
raporu sonlandırırız
         */
        /*
        Mit der Methode info() mit dem extentTest-Objekt können wir Informationen darüber schreiben,
        was wir bei jedem Schritt tun Dieneuesten Informationen zu unserem Test mit der pass()-Methode, was bedeutet,
        dass der Test am Ende unseres Tests beendet ist Wir können es hinzufügen.
    Und schließlich die Verwendung der flush()-Methode mit dem extentReport-Objekt,
     z. B. die perform-Methode in Aktionen.Wir beenden den Bericht
         */




    }
}
