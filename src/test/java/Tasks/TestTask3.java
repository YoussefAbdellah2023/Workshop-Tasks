package Tasks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask3 extends FluentBotTestCase {

//    Open Google Chrome
//    Navigate to [https://duckduckgo.com/]
//    Search for [Selenium WebDriver]
//    Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
//    Close Google Chrome

    @Test
    public void searchForSeleniumWebDriverAndCheckFirstResultLink() {

        String actualLink = new Pages.PageTask3(bot)
                .navigateToPage()
                .inputDataInTheSearchFiled().getTheFirstResultLink();

        Assert.assertEquals(actualLink, "https://www.selenium.dev/documentation/webdriver/", "The link of the first result is not as expected");
    }
}