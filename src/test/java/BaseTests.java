import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseTests {
    @Test
    public void checkSetUp() {
        WebDriver chromeDriver = new ChromeDriver(); // Creates a new Chrome instance
        chromeDriver.get("https://www.bbc.com"); // Navigates to a page by address
    }
}
