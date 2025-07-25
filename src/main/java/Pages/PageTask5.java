package Pages;

import Actions.FluentBrowserActionsBot;
import Actions.FluentElementActionsBot;
import engine.FluentDriverEngine;
import org.openqa.selenium.By;

public class PageTask5 extends BasePage {



    By searchBox = By.id("searchbox_input");
    By urlSecondResult = By.xpath("//*[@id=\"r1-1\"]//div[3]//a");

    public PageTask5(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }


    public PageTask5 navigateToDuckDuckGo() {
        fluentBrowserActionsBot.navigateTo("https://duckduckgo.com/");
        return this;
    }

    public PageTask5 searchForCucumberIO() {
        fluentElementActionsBot.type(searchBox, "Cucumber IO");
        fluentElementActionsBot.type(searchBox, "\n"); // Simulate pressing Enter
        return this;
    }

    public String isSecondResultLinkedIn() {
        return fluentElementActionsBot.getDomAttribute(urlSecondResult, "href");

    }


    // Add methods and locators specific to Task 5 here
}