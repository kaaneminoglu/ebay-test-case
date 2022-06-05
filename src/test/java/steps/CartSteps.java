package steps;

import base.BaseMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartSteps extends BaseMethods {

    private final By lst_cart_in_category = By.xpath("//*[@id='s0-28_2-9-0-1[0]-0-0']/ul/li");
    private final By btn_add_to_cart = By.id("isCartBtn_btn");
    private final By btn_cart = By.id("gh-minicart-hover");
    private final By btn_remove = By.xpath("//*[@data-test-id='cart-remove-item']");
    private final By lbl_message = By.xpath("//*[@id='page-alerts']/*[@class='page-notice page-notice--confirmation']/div[2]/p/span/span/span");
    private final By lst_cart = By.xpath("//*[@id='mainContent']/div/div[3]/div[1]/div/div");

    @When("Add to {int} cart")
    public void addToCart(int piece) {
        System.out.println("addToCart started");
        for (int i = 0; i < piece; i++) {
            List<WebElement> lstCartInCategory = getWebElements(lst_cart_in_category);
            lstCartInCategory.get(i).click();
            waitBySeconds(3);
            switchToLastTab();
            waitDisplayingWebElement(btn_add_to_cart);
            startTime = System.currentTimeMillis();
            clickWebElement(btn_add_to_cart);
            endTime = System.currentTimeMillis();
            loadPage("cart " + (i + 1));
            closeTab();
            switchToLastTab();
        }
        System.out.println("addToCart finished");
    }

    @When("Open cart")
    public void openCart() {
        System.out.println("openCart started");
        startTime = System.currentTimeMillis();
        clickWebElement(btn_cart);
        endTime = System.currentTimeMillis();
        loadPage("Cart");
        System.out.println("openCart finished");
    }

    @When("Check {int} item in cart")
    public void checkToWatchList(int piece) {
        System.out.println("checkToWatchList started");
        List<WebElement> lstCart = getWebElements(lst_cart);
        if (lstCart.size() == piece) {
            System.out.println("Cart have " + piece + " item");
        } else {
            Assert.fail("Products could not be added to cart");
        }
        System.out.println("checkToWatchList finished");
    }

    @Then("Remove first product")
    public void removeFirstProduct() {
        System.out.println("removeFirstProduct started");
        int cartSize = getWebElements(lst_cart).size();
        clickWebElement(btn_remove);
        waitDisplayingWebElement(lbl_message);
        Assert.assertEquals("was removed from your cart.", getText(lbl_message));
        Assert.assertEquals(cartSize - 1, getWebElements(lst_cart).size());
        System.out.println("removeFirstProduct finished");
    }
}
