package Tasks;

import Pages.PageTask11;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Files.FluentFilesBot.getJsonData;


public class TestTask11 extends FluentBotTestCase{

//    Open Google Chrome
//    Navigate to [https://duckduckgo.com/]
//    Search for [Selenium WebDriver]
//    Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
//    Close Google Chrome

    @Test
    public void searchForSeleniumWebDriverAndCheckFirstResultLink() {

        String actualLink = new PageTask11(bot)
                .navigateToPage()
                .inputDataInTheSearchFiled()
                .getTheFirstResultLink();

        // TODO: Ask Mohab Mohie If I Do It, Is It Correct?, For The Expected Result
        Assert.assertEquals(actualLink, getJsonData("Task11","expectedResults.value"), "The link of the first result is not as expected");
    }
}
