package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {
    //   https://the-internet.herokuapp.com/checkboxes sayfasına gidin
    //   Checkbox1 ve checkbox2 elementlerini locate edin.
    //   Checkbox1 seçili değilse secin
    //   Checkbox2 seçili değilse secin

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Test baslatildi");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Test sonuclandi");
    }

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if (!checkbox1.isSelected()){
        checkbox1.click();
        Thread.sleep(3000);
    }

        if (!checkbox2.isSelected()) {
            checkbox2.click();
            Thread.sleep(3000);
        }

        /*
    @Test @Ignore("Gereksiz")
    public void ignor() {

        driver.get("https://amazon.com");

    }


 */

    }
}
