package Pages;

import Actions.FluentBrowserActionsBot;
import engine.FluentDriverEngine;

import static Files.FluentFilesBot.getConfigValue;

public class PageTask1 extends BasePage {


    public PageTask1(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        this.fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }


    public PageTask1 navigateToDuckDuckGo() {
        fluentBrowserActionsBot.navigateTo(getConfigValue("task1", "url"));
        return this;
    }


    public String getTitle() {
        return fluentBrowserActionsBot.getTitle();

    }
}