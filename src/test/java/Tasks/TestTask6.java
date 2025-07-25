package Tasks;

import Pages.PageTask6;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask6 extends FluentBotTestCase {

    //    Open Google Chrome
//    Navigate to [http://the-internet.herokuapp.com/checkboxes]
//    Check Checkbox 1
//    Assert that both Checkboxes are checked
//    Close Google Chrome

    @Test
    public void navigateToHerokuAppAndCheckCheckboxesAreChecked() {

        boolean actualResult = new PageTask6(bot)
                .navigateToHerokuApp()
                .checkCheckbox1()
                .checkBoxesAreChecked();

        Assert.assertTrue(actualResult, "Checkboxes are not checked as expected");
    }
}
