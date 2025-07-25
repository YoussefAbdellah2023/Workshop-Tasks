package Pages;

import Actions.FluentBrowserActionsBot;
import Actions.FluentElementActionsBot;
import engine.FluentDriverEngine;
import org.openqa.selenium.By;

public class PageTask7 extends BasePage{

    //    Open Google Chrome
//    Navigate to [https://www.w3schools.com/html/html_tables.asp]
//    Assert that the Country for the Company [Ernst Handel] is [Austria]
//    Close Google Chrome

    By CountryNameLabel = By.xpath("(//td[text()='Ernst Handel']/following-sibling::td)[2]");


    public PageTask7(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }

    public PageTask7 navigateToW3SchoolsHtmlTables() {
        fluentBrowserActionsBot.navigateTo("https://www.w3schools.com/html/html_tables.asp");
        return this;
    }

    public String getCountryForCompany() {
        return fluentElementActionsBot.getText(CountryNameLabel);
    }

}
