package Pages;

import engine.FluentBrowserActionsBot;

import static engine.FluentFilesBot.getConfigValue;

public class PageTask1 extends BasePage {


    public PageTask1(FluentBrowserActionsBot bot) {
        this.fluentBrowserActionsBot = bot;
        this.fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentBrowserActionsBot.getDriver(),
                fluentBrowserActionsBot.getWait());
    }


    public PageTask1 navigateToDuckDuckGo() {
        fluentBrowserActionsBot.navigateTo(getConfigValue("task1", "url"));
        return this;
    }


    public String getTitle() {
        return fluentBrowserActionsBot.getTitle();

    }
}