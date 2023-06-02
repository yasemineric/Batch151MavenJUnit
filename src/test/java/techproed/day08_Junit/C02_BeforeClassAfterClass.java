package techproed.day08_Junit;

import org.junit.*;

public class C02_BeforeClassAfterClass {
    /*
    @BeforeClass Class.da ilk önce calisan methoddur.
    @AfterClass Class.da en son calisan methoddur.
    @BeforeClass ve @AfterClass metodlari sadece static metodlar ile calisir ve bir kez calisirlar
 */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class.taki tüm testlerden önce calisan methoddur.");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class.ta en son calisacak olan methoddur.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan önce calisir");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra calisir");

    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");
    }


}
