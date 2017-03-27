package po;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class GooglePage extends BasePage {

    private static final By TITLE_BY = By.className("r");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchInput() {
        return this.driver.findElement(By.name("q"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.name("btnG"));
    }

    public List<WebElement> getResults() {
        waitPageIsReady();
        return driver.findElements(By.cssSelector("#rso .srg .g .r"));
    }

    protected By getUniqueElement() {
        return By.name("q");
    }

    public void search(String text) {
        getSearchInput().sendKeys(text);
        getSearchButton().click();
        waitResultsLoaded();
    }

    public void waitResultsLoaded() {
        wait.until(ExpectedConditions.visibilityOfAllElements(getResults()));
    }

    public int countResults() {
        return getResults().size();
    }

    public void navigateForward() {
        driver.findElement(By.id("pnnext")).click();
        waitPageIsReady();
    }

    public WebElement previousButton() {
        return driver.findElement(By.id("pnprev"));
    }

    public void navigateBackward() {
        previousButton().click();
        waitPageIsReady();
    }

    public List<String> getResultTextList() {
        waitPageIsReady();
        List<String> resultList = new ArrayList<>();
        //waitResultsLoaded();
        for (WebElement element : getResults()) {
            resultList.add(element.getText());
        }
        return resultList;
    }

    public void clickOnResult(String text) {
        WebElement link = driver.findElement(By.partialLinkText(text));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
    }


}
