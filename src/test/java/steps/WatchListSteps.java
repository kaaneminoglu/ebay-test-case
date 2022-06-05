package steps;

import base.BaseMethods;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WatchListSteps extends BaseMethods {

    private final By btn_add_watch_list = By.xpath("//*[@id='s0-28_2-9-0-1[0]-0-0']/ul/li/span/button");
    private final By btn_view_all_item = By.xpath("//*[@id='gh-wl-click-body']/div/div/div[1]/a");
    private final By chbox_all_select = By.xpath("//*[@id='middle-wrapper-grid']/div[4]/div[1]/div[1]/ul/li[1]/div");
    private final By btn_delete = By.xpath("//*[@id='middle-wrapper-grid']/div[4]/div[1]/div[1]/ul/li[3]/div/button");
    private final By btn_watch_list = By.xpath("//*[@id='gh-wl-click']/div/a[1]");
    private final By btn_home_page = By.id("gh-la");
    private final By lbl_watch_list = By.xpath("//*[@id=\"gh-wl-click-body\"]/div/div/div");
    private final By lst_watch_list_item = By.xpath("//*[@id='middle-wrapper-grid']/div[4]/div[3]/div");

    @When("Clear watch list")
    public void clearWatchList() {
        System.out.println("clearWatchList started");
        clickWebElement(btn_watch_list);
        if (getText(lbl_watch_list).equals("Looks like you are not watching any items yet.")) return;
        waitDisplayingWebElement(btn_view_all_item);
        clickWebElement(btn_view_all_item);
        waitDisplayingWebElement(chbox_all_select);
        clickWebElement(chbox_all_select);
        clickWebElement(btn_delete);
        clickWebElement(btn_home_page);
        System.out.println("clearWatchList finished");
    }

    @When("Add to {int} watch list")
    public void addToWatchList(int piece) {
        System.out.println("addToWatchList started");
        for (int i = 0; i < piece; i++) {
            waitDisplayingWebElement(btn_add_watch_list);
            List<WebElement> lstCartInCategory = getWebElements(btn_add_watch_list);
            lstCartInCategory.get(i).click();
            waitBySeconds(3);
            System.out.println("addToWatchList finished");
        }
    }

    @When("Check {int} item in watch list")
    public void checkToWatchList(int piece) {
        System.out.println("checkToWatchList started");
        clickWebElement(btn_watch_list);
        waitDisplayingWebElement(btn_view_all_item);
        clickWebElement(btn_view_all_item);
        List<WebElement> lstWatchListItem = getWebElements(lst_watch_list_item);
        if (lstWatchListItem.size() == piece) {
            System.out.println("Watchlist have " + piece + " item");
        } else {
            Assert.fail("Products could not be added to watch list");
        }
        System.out.println("checkToWatchList finished");
    }
}
