package Pages;
import engine.FluentBrowserActionsBot;
import engine.FluentElementActionsBot;
import org.openqa.selenium.By;

public class PageTask2 extends BasePage{


    public PageTask2(FluentBrowserActionsBot bot) {
        this.fluentBrowserActionsBot = bot;
        fluentElementActionsBot = new FluentElementActionsBot(fluentBrowserActionsBot.getDriver(),
                fluentBrowserActionsBot.getWait());
        fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentBrowserActionsBot.getDriver(),
                fluentBrowserActionsBot.getWait());
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
