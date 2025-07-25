package Pages;

import engine.FluentDriverEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static Files.FluentFilesBot.getJsonData;


public class PageTask11 extends BasePage{

//    Open Google Chrome
//    Navigate to [https://duckduckgo.com/]
//    Search for [Selenium WebDriver]
//    Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
//    Close Google Chrome

    public PageTask11(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new Actions.FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new Actions.FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }


    By searchBoxLocator = By.id("searchbox_input");
    By urlFirstResult = By.xpath("//article[@id='r1-0']//h2/a");


    public PageTask11 navigateToPage() {
        fluentBrowserActionsBot.navigateTo((String) getJsonData("Task11", "page.url"));
        return this;
    }

    public PageTask11 inputDataInTheSearchFiled() {
        fluentElementActionsBot.type(searchBoxLocator, (CharSequence) getJsonData("Task11","searchBox.value"), Keys.ENTER);
        return this;
    }


    public String getTheFirstResultLink() {
        return fluentElementActionsBot.getDomAttribute(urlFirstResult,"href");

    }
}
