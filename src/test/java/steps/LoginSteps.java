package steps;

import base.BaseMethods;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginSteps extends BaseMethods {
    private final By txt_email = By.id("userid");
    private final By txt_password = By.id("pass");
    private final By btn_continue = By.id("signin-continue-btn");
    private final By btn_sign_in = By.id("sgnBt");

    @When("{string} and {string} are entered.")
    public void setMailAndPassword(String userName, String password) {
        System.out.println("setMailAndPassword started");
        waitDisplayingWebElement(txt_email);
        sendText(txt_email, userName);
        clickWebElement(btn_continue);
        waitDisplayingWebElement(txt_password);
        sendText(txt_password, password);
        clickWebElement(btn_sign_in);
        System.out.println("setMailAndPassword finished");
    }
}
