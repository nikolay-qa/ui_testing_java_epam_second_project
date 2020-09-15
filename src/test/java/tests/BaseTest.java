package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.LoremIpsumPage;

public class BaseTest {

    WebDriver driver;
    private static final String LOREM_IPSUM_URL = "https://lipsum.com/";

/*
    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "usr/bin/chromedriver");
    }
 Uncomment it and add local path to chromedriver if chromedriver is not set in system path variable
*/

    @BeforeMethod
    public void testsSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOREM_IPSUM_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage getBasePage() {
        return new BasePage(getDriver());
    }

    public LoremIpsumPage getLoremIpsumPage() { return new LoremIpsumPage(getDriver()); }
}
