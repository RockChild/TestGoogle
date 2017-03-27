package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String URL = "https://www.google.com";
    private static final int iTimeout = 10;

    static WebDriver driver;

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.gecko.driver","/Users/pavlo.shtefanesku/Documents/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(iTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(iTimeout, TimeUnit.SECONDS);
    }

    @Before
    public void openUrl() {
        driver.get(URL);
    }

    @After
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void quit() {
        driver.quit();
    }
}
