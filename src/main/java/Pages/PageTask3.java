package Pages;

import Actions.FluentBrowserActionsBot;
import Actions.FluentElementActionsBot;
import engine.FluentDriverEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class PageTask3 extends BasePage{

//    Open Google Chrome
//    Navigate to [https://duckduckgo.com/]
//    Search for [Selenium WebDriver]
//    Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
//    Close Google Chrome

    public PageTask3(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }



    By searchBoxLocator = By.id("searchbox_input");
    By urlFirstResult = By.xpath("//article[@id='r1-0']//h2/a");


    public PageTask3 navigateToPage() {
        fluentBrowserActionsBot.navigateTo("https://duckduckgo.com/");
        return this;
    }

    public PageTask3 inputDataInTheSearchFiled() {
        fluentElementActionsBot.type(searchBoxLocator, "Selenium WebDriver", Keys.ENTER);
        return this;
    }


    public String getTheFirstResultLink() {
        return fluentElementActionsBot.getDomAttribute(urlFirstResult,"href");

    }

}