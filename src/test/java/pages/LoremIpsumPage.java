package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoremIpsumPage extends BasePage{

    @FindBy(xpath = "//a[@class='ru']")
    public WebElement ruLanguageLink;

    @FindBy(xpath = "//p[contains(text(), 'PageMaker')]")
    public WebElement loremIpsumParagraph;

    @FindBy(css = "#generate")
    public WebElement generateButton;

    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    public WebElement firstParagraphAfterGeneratingLoremIpsum;

    public LoremIpsumPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnRuLink(){
        waitUntilElementIsClickable(5, ruLanguageLink);
        ruLanguageLink.click();
    }

    public String getFirstParagraph(long timeToWait){
        waitUntilElementIsVisible(timeToWait, loremIpsumParagraph);
        return loremIpsumParagraph.getText();
    }

    public void clickOnGenerateButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", generateButton);
        generateButton.click();
    }

    public String getFirstParagraphAfterGeneratingLoremIpsum(){
        waitUntilElementIsVisible(5, firstParagraphAfterGeneratingLoremIpsum);
        return firstParagraphAfterGeneratingLoremIpsum.getText();
    }
}
