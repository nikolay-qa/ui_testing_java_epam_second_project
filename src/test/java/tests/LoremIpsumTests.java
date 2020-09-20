package tests;

import org.testng.annotations.Test;
import pages.LoremIpsumPage;

import static org.testng.Assert.assertTrue;


public abstract class LoremIpsumTests extends BaseTest{

    private static final String EXPECTED_WORD = "рыба";
    private static final String EXPECTED_PHRASE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

    @Test
    public void checkThatExpectedWordIsShown() {
        String actualResult = new LoremIpsumPage(driver)
                .openPage()
                .clickOnRuLink()
                .getFirstParagraph();
        assertTrue(actualResult.contains(EXPECTED_WORD), String.format("The '%s' word is not shown in the first paragraph.", EXPECTED_WORD));
    }

    @Test
    public void checkThatLoremIpsumStartedWithExpectedTextAfterGenerating(){
        String actualResult = new LoremIpsumPage(driver)
                .clickOnGenerateButton()
                .getFirstParagraphAfterGeneratingLoremIpsum();
        assertTrue(actualResult.contains(EXPECTED_PHRASE), "Incorrect text is shown after generating.");
    }
}

