package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class LoremIpsumTests extends BaseTest{
    static final String EXPECTED_WORD = "рыба";
    static final String EXPECTED_PHRASE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

    @Test
    public void CheckThatExpectedWordIsShown() {
        getBasePage();
        getLoremIpsumPage().clickOnRuLink();
        String actualResult = getLoremIpsumPage().getFirstParagraph(5);
        assertTrue(actualResult.contains(EXPECTED_WORD));
    }
    @Test(priority = 1)
    public void CheckThatLoremIpsumStartedWithExpectedTextAfterGenerating(){
        getBasePage();
        getLoremIpsumPage().clickOnGenerateButton();
        String actualResult = getLoremIpsumPage().getFirstParagraphAfterGeneratingLoremIpsum();
        assertTrue(actualResult.contains(EXPECTED_PHRASE));
    }
}

