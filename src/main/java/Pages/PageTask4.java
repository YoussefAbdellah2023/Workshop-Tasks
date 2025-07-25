package Pages;

import Actions.FluentBrowserActionsBot;
import Actions.FluentElementActionsBot;
import engine.FluentDriverEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class PageTask4 extends BasePage {
//    Open Mozilla Firefox
//    Navigate to [https://duckduckgo.com/]
//    Search for [TestNG]
//    Assert that the text of the fourth result is [TestNG Tutorial]
//    Close Mozilla Firefox

    public PageTask4(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }

    By searchBox = By.id("searchbox_input");
    By fourthResultText = By.xpath("//*[@id='r1-3']//h2//span");


    public PageTask4 navigateToPage() {
        fluentBrowserActionsBot.navigateTo("https://duckduckgo.com/");
        return this;
    }

    public PageTask4 inputDataInTheSearchField() {
        fluentElementActionsBot.type(searchBox, "TestNG", Keys.ENTER);
        return this;
    }

    public String getFourthResultText() {
        return fluentElementActionsBot.getText(fourthResultText);
    }

    // Add methods specific to PageTask4 here
}
