package Tasks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask4 extends FluentBotTestCase {

    //    Open Mozilla Firefox
//    Navigate to [https://duckduckgo.com/]
//    Search for [TestNG]
//    Assert that the text of the fourth result is [TestNG Tutorial]
//    Close Mozilla Firefox

    @Test
    public void searchForTestNGAndCheckFourthResultText() {
        String actualResult = new Pages.PageTask4(bot)
                .navigateToPage()
                .inputDataInTheSearchField()
                .getFourthResultText();

        Assert.assertEquals(actualResult, "TestNG Tutorial", "The text of the fourth result is not as expected");
    }
}