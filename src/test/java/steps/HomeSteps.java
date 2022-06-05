package steps;

import base.BaseMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeSteps extends BaseMethods {

    private final By btn_sign_in = By.xpath("//*[@id='gh-ug']/a");
    private final By lst_main_category = By.xpath("//*[@id='mainContent']/div[1]/ul/li");
    private final By lst_shop_by_category = By.xpath("//*[@id='s0-17-12_2-0-1[0]-0-0']/ul/li");

    @When("Open login page")
    public void openLoginPage() {
        System.out.println("openLoginPage started");
        startTime = System.currentTimeMillis();
        clickWebElement(btn_sign_in);
        endTime = System.currentTimeMillis();
        loadPage("Login");
        System.out.println("openLoginPage finished");
    }

    @Given("Hover {string} category and open {string} subcategory")
    public void hoverCategory(String menuName, String subMenuName) {
        System.out.println("hoverCategory started");
        List<WebElement> lstMainCategory = getWebElements(lst_main_category);
        for (WebElement webElement : lstMainCategory) {
            String name = webElement.getText();
            if (name.equals(menuName)) {
                hoverElement(webElement);
                waitDisplayingWebElement(webElement.findElement(By.xpath(".//div[2]/div[1]/nav[1]/ul/li/a")));
                List<WebElement> lstMainSubCategory = webElement.findElements(By.xpath(".//div[2]/div[1]/nav[1]/ul/li/a"));
                for (WebElement subWebElement : lstMainSubCategory) {
                    String subName = subWebElement.getText();
                    if (subName.equals(subMenuName)) {
                        startTime = System.currentTimeMillis();
                        clickWebElement(subWebElement);
                        endTime = System.currentTimeMillis();
                        loadPage(subMenuName);
                        System.out.println("hoverCategory finished");
                        return;
                    }
                }
                startTime = System.currentTimeMillis();
                webElement.click();
                endTime = System.currentTimeMillis();
                loadPage(menuName);
                break;
            }
        }
        waitDisplayingWebElement(lst_shop_by_category);
        List<WebElement> lstShopByCategory = getWebElements(lst_shop_by_category);
        for (WebElement webElement : lstShopByCategory) {
            String shopByCategoryName = webElement.getText();
            if (shopByCategoryName.equals(subMenuName)) {
                clickWebElement(webElement);
                startTime = System.currentTimeMillis();
                webElement.findElement(By.xpath(".//li")).click();
                endTime = System.currentTimeMillis();
                loadPage(subMenuName);
                System.out.println("hoverCategory finished");
                return;
            }
            System.out.println("hoverCategory finished");
        }
    }
}
