package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    static final int TIME_TO_WAIT = 5;

    protected abstract AbstractPage openPage();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitUntilElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
