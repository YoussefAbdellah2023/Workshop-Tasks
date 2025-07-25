package Tasks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask5 extends FluentBotTestCase{

    //    Open Google Chrome
//    Navigate to [https://duckduckgo.com/]
//    Search for [Cucumber IO]
//    Assert that the link of the second result contains [https://www.linkedin.com]
//    Close Google Chrome

    @Test
    public void navigateToSeleniumWebDriverAndCheckTitle() {
        String actualResult = new Pages.PageTask5(bot)
                .navigateToDuckDuckGo()
                .searchForCucumberIO()
                .isSecondResultLinkedIn();

        Assert.assertTrue(actualResult.contains("https://www.linkedin.com"),
                "The link of the second result does not contain the expected URL");
    }
}