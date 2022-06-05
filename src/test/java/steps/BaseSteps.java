package steps;

import base.BaseMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseSteps extends BaseMethods {
    public static WebDriver driver;
    public WebDriverWait wait;

    @Before()
    public void setUp(Scenario scenario) throws MalformedURLException {
        BaseMethods.folderName = scenario.getName();
        driver = Driver.get();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        startTime = System.currentTimeMillis();
        driver.get("https://www.ebay.com/");
        endTime = System.currentTimeMillis();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loadPage("Home");
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
