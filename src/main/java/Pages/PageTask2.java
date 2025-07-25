package Pages;
import Actions.FluentBrowserActionsBot;
import engine.FluentDriverEngine;
import Actions.FluentElementActionsBot;
import org.openqa.selenium.By;

public class PageTask2 extends BasePage{


    public PageTask2(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }


    By logoLocator = By.xpath("//div[contains(@class,'Desktop')]//img");

    public PageTask2 navigateToPage() {
        fluentBrowserActionsBot.navigateTo("https://duckduckgo.com/");
        return this;
    }

    public boolean LogoIsDisplayed() {
        fluentElementActionsBot.isDisplayed(logoLocator);
        return true;
    }
}
