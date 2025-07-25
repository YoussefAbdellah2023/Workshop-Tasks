package Tasks;

import engine.FluentBrowserActionsBot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class FluentBotTestCase {
    FluentBrowserActionsBot bot;

    @BeforeMethod
    public void setup() {
        bot = new FluentBrowserActionsBot();
    }

    @AfterMethod
    public void tearDown() {
        bot.quit();
        bot = null;
    }



}
