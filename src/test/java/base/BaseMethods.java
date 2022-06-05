package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseMethods {
    protected static String folderName;
    private final WebDriver driver = BaseSteps.getDriver();
    public long startTime;
    public long endTime;

    protected void clickWebElement(By locator) {
        try {
            System.out.println("Click web element: " + locator);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadPage(String pageName) {
        long total = endTime - startTime;
        System.out.println(pageName + " Page: " + total + " ms");
    }

    protected void clickWebElement(WebElement webElement) {
        try {
            System.out.println("Click web element: " + webElement);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendText(By locator, String text) {
        try {
            System.out.println("Send text: " + locator);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getText(By locator) {
        System.out.println("Get text: " + locator);
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(locator)).getText();
    }

    protected List<WebElement> getWebElements(By locator) {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.elementToBeClickable(locator)).findElements(locator);
    }

    public void waitBySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitDisplayingWebElement(By locator) {
        try {
            System.out.println("Wait Displaying Web Element: " + locator);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitDisplayingWebElement(WebElement webElement) {
        try {
            System.out.println("Wait Displaying Web Element: " + webElement);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void closeTab() {
        driver.close();
    }

    protected void switchToLastTab() {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(tab.size() - 1));
    }

    public void hoverElement(WebElement element) {
        System.out.println("Hover element: " + element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
