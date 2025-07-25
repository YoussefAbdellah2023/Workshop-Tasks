package Pages;

import engine.FluentDriverEngine;
import org.openqa.selenium.By;

public class PageTask9 extends BasePage{

    //    Open Google Chrome
//    Navigate to [https://jqueryui.com/resources/demos/droppable/default.html]
//    Drag [Drag me to my target] and drop it on [Drop here]
//    Assert that the text has been changed to [Dropped!]
//    Close Google Chrome


    public PageTask9(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new Actions.FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new Actions.FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());

    }

    By dragMe = By.xpath("//*[@id=\"draggable\"]");
    By dropIt = By.xpath("//*[@id=\"droppable\"]");


    public PageTask9 navigateToPage() {
        fluentBrowserActionsBot.navigateTo("https://jqueryui.com/resources/demos/droppable/default.html");
        return this;
    }

    public PageTask9 dragAndDropItem() {
        fluentElementActionsBot.dragAndDrop(dragMe, dropIt);
        return this;
    }

    public String TextChangedAfterDropped() {
        return fluentElementActionsBot.getText(dropIt);
    }
}
