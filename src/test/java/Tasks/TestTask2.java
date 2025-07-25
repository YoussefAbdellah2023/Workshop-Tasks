package Tasks;

import Pages.PageTask2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask2 extends FluentBotTestCase{

//    Open Google Chrome
//    Navigate to [https://duckduckgo.com/]
//    Assert that the DuckDuckGo logo is displayed
//    Close Google Chrome


    @Test
    public void navigateToDuckDuckGoAndCheckLogoIsDisplayed() {
        boolean ActualResult = new PageTask2(bot)
             .navigateToPage()
             .LogoIsDisplayed();
        Assert.assertTrue(ActualResult, "DuckDuckGo logo is not displayed");

    }

}
