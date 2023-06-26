package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTable extends TestBase {
    /*
    Thead : Tablo Başlığı
Tbody : Tablo Body'si
Tr : Table Row(Satır)
Td : Table Data(Sütun olarak adlandırılabilir)
     */
    /*
    WEBTABLE;
        <table> tagi ile baslar
            <thead> basliklar icin bu tag ile devam eder
            <tr> table row(Basliklarin satiri)
                <th> table head
                    <td> basliktaki veriler
                <tbody> basliklar altindaki verileri temsil eder
                        <tr> table row(satir)
                            <td> table data(tablodaki veri)
 */

    //    https://the-internet.herokuapp.com/tables sayfasına gidin
//    Task 1 : Table1’i yazdırın
//    Task 2 : 3. Satır verilerini yazdırın
//    Task 3 : Son satırın verilerini yazdırın
//    Task 4 : 5. Sütun verilerini yazdırın
//    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
    //    Parameter 1 = satır numarası
    //    Parameter 2 = sütun numarası
    //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

    @Test
    public void test01() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
//    Task 1 : Table1’i yazdırın
        WebElement table1=driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
//    Task 2 : 3. Satır verilerini yazdırın
        WebElement dritteZeile= driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("++++++++++++++++++++++");
        System.out.println(dritteZeile.getText());
//    Task 3 : Son satırın verilerini yazdırın
//    Task 4 : 5. Sütun verilerini yazdırın
//    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.


    }
}
