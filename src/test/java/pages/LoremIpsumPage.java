package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoremIpsumPage extends AbstractPage {

    private static final String LOREM_IPSUM_URL = "https://lipsum.com/";

    @FindBy(xpath = "//a[@class='ru']")
    private WebElement ruLanguageLink;

    @FindBy(xpath = "//p[contains(text(), 'PageMaker')]")
    private WebElement loremIpsumParagraph;

    @FindBy(xpath = "//*[@id='generate']")
    private WebElement generateButton;

    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    private WebElement firstParagraphAfterGeneratingLoremIpsum;

    public LoremIpsumPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoremIpsumPage openPage() {
        driver.navigate().to(LOREM_IPSUM_URL);
        return this;
    }

    public void clickOnRuLink() {
        waitUntilElementIsClickable(ruLanguageLink);
        ruLanguageLink.click();
    }

    public String getFirstParagraph() {
        waitUntilElementIsVisible(loremIpsumParagraph);
        return loremIpsumParagraph.getText();
    }

    public void clickOnGenerateButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", generateButton);
        generateButton.click();
    }

    public String getFirstParagraphAfterGeneratingLoremIpsum() {
        waitUntilElementIsVisible(firstParagraphAfterGeneratingLoremIpsum);
        return firstParagraphAfterGeneratingLoremIpsum.getText();
    }
}
