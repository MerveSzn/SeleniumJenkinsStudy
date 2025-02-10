
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class googleTest {
    WebDriver driver;

    @Test
    public void test(){
        assertEquals(5, 5, "2 + 3 should equal 5");
        System.out.println( "test geçti");

    }
}
