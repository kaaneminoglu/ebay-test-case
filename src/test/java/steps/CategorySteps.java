package steps;

import base.BaseMethods;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CategorySteps extends BaseMethods {
    private final By lbl_sub_category_name = By.className("b-pageheader__text");

    @When("Check {string} subcategory name")
    public void openLoginPage(String subMenuName) {
        System.out.println("openLoginPage started");
        waitDisplayingWebElement(lbl_sub_category_name);
        Assert.assertEquals(subMenuName, getText(lbl_sub_category_name));
        System.out.println("openLoginPage finished");
    }
}
