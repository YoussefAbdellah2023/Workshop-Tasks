package Tasks;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask7 extends FluentBotTestCase{

    //    Open Google Chrome
//    Navigate to [https://www.w3schools.com/html/html_tables.asp]
//    Assert that the Country for the Company [Ernst Handel] is [Austria]
//    Close Google Chrome

    @Test
    public void verifyCountryForErnstHandel() {
        String actualCountry = new Pages.PageTask7(bot)
                .navigateToW3SchoolsHtmlTables()
                .getCountryForCompany();

        Assert.assertEquals(actualCountry, "Austria", "The country for Ernst Handel is not Austria");
    }
}