package tests;

import org.junit.Before;
import org.junit.Test;
import po.GooglePage;
import po.SeleniumPage;

import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class TestGoogle extends BaseTest {
    private static final String SELENIUM_TITLE = "Selenium - Web Browser Automation";
    private int resultsPerPage = 10;
    private GooglePage googlePage;

    @Before
    public void setUpTestGoogle() {
        googlePage = new GooglePage(driver);
    }

    /**
     * <strong>Test Google</strong>
     * <strong>Prerequisites:</strong>
     * Open 'https://www.google.com' and wait until page is loaded.
     * <strong>Steps:</strong>
     * 1. Enter 'Selenium' in search input.
     * 2. Click on submit button.
     * >> Result list consists of 10 results.
     * >> There is a 'Selenium - Web Browser Automation' among results.
     * 3. Click on 'Next'
     * >> Result list consists of 10 results.
     * >> There is no same result on the 2nd page
     * 4. Click on 'Previous'
     * 5. Click on 'Selenium - Web Browser Automation'.
     * >> Selenium official page is opened with 'Selenium - Web Browser Automation' page title.
     */
    @Test
    public void test() {
        //1, 2
        googlePage.search("Selenium");
        assertEquals(String.format("Number of results should equal to %d ", resultsPerPage),
                resultsPerPage, googlePage.countResults());
        assertThat(googlePage.getResultTextList(), hasItem(SELENIUM_TITLE));
        List<String> resultTextList = googlePage.getResultTextList();

        //3
        googlePage.navigateForward();
        googlePage.waitResultsLoaded();

        assertEquals(String.format("Number of results should equal to %d ", resultsPerPage),
                resultsPerPage, googlePage.countResults());
        //4
        googlePage.navigateBackward();

        //5
        googlePage.clickOnResult(SELENIUM_TITLE);

        SeleniumPage seleniumPage = new SeleniumPage(driver);
        assertEquals("Expected opened page title", SELENIUM_TITLE, seleniumPage.getTitle());
    }
}
