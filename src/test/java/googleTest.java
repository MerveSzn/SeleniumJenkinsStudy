import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class googleTest {
    WebDriver driver;

    @Test
    public void test(){
        assertEquals(5, 5, "2 + 3 should equal 5");
        System.out.println( "test geçti");

    }
    /*@Before
    public void setUp() {
        // Chrome WebDriver'ı başlat
        System.setProperty("webdriver.chrome.driver", "/Users/mervesozen/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        // Google sayfasına git
        driver.get("https://www.google.com");
    }

    @After
    public void tearDown() {
        // Tarayıcıyı kapat
        driver.quit();
    }*/
}
