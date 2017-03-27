package po;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = (new WebDriverWait(driver, 30));
        isLoaded();
    }

    protected abstract By getUniqueElement();

    private void isLoaded() {
        List<WebElement> uniqueElement = driver.findElements(getUniqueElement());
        Assert.assertTrue("Unique Element \'" + getUniqueElement().toString() + "\' not found for " + this.getClass().getSimpleName(),
                (uniqueElement.size() > 0));
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUniqueElement()));
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitPageIsReady() {
        wait.until(driver -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }
}
