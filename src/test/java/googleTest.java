

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTest {
    private static ExtentReports extent;
    private static ExtentTest test;
    private WebDriver driver;


    @BeforeAll
    public static void setup() {
        // ExtentReports için yeni Spark raporlayıcısını tanımlıyoruz.
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-reports/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

    }

    @BeforeEach
    public void beforeEachTest() {
        test = extent.createTest("Test Başlığı", "Test açıklaması");
    }


      @Test
    public void testExample() {
        // Test içeriği
        System.out.println("Test çalıştı!");
    }
    @AfterEach
    public void afterEachTest() {
        extent.flush();
    }

}
