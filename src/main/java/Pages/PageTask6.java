package Pages;

import Actions.FluentBrowserActionsBot;
import Actions.FluentElementActionsBot;
import engine.FluentDriverEngine;
import org.openqa.selenium.By;

public class PageTask6 extends BasePage{

    //    Open Google Chrome
//    Navigate to [http://the-internet.herokuapp.com/checkboxes]
//    Check Checkbox 1
//    Assert that both Checkboxes are checked
//    Close Google Chrome

    public PageTask6(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }

    By checkbox1 = By.xpath("//input[1]");
    By checkbox2 = By.xpath("//input[2]");



    public PageTask6 navigateToHerokuApp() {
        fluentBrowserActionsBot.navigateTo("https://the-internet.herokuapp.com/checkboxes");
        return this;
    }

    public PageTask6 checkCheckbox1() {
        By checkbox1 = By.xpath("//input[1]");
        fluentElementActionsBot.click(checkbox1);
        return this;
    }

    public boolean checkBoxesAreChecked() {
        return fluentElementActionsBot.isSelected(checkbox1) && fluentElementActionsBot.isSelected(checkbox2);
    }







}