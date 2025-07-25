package Tasks;

import Pages.PageTask1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask1 extends FluentBotTestCase{

//    Open Google Chrome
//    Navigate to [https://duckduckgo.com/]
//    Assert that the page title is [Google]
//    Close Google Chrome


    @Test
    public void navigateToDuckDuckGoAndCheckTitle() {
        String actualResult=
                new PageTask1(bot)
                        .navigateToDuckDuckGo()
                        .getTitle();
        Assert.assertEquals(actualResult, "Google", "Page title is not as expected");
    }

    @Test
    public void navigateToDuckDuckGoAndCheckTitle2() {
        String actualResult=
                new PageTask1(bot)
                        .navigateToDuckDuckGo()
                        .getTitle();
        Assert.assertEquals(actualResult, "Google", "Page title is not as expected");
    }



}