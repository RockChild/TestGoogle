package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumPage extends BasePage {

    public SeleniumPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElement() {
        return By.cssSelector("a[title='Return to Selenium home page']");
    }

}
