package Pages;

import Actions.FluentBrowserActionsBot;
import Actions.FluentElementActionsBot;
import engine.FluentDriverEngine;
import org.openqa.selenium.By;


import static Files.FluentFilesBot.getConfigValue;

public class PageTask8 extends BasePage{

    //    Open Google Chrome
//    Navigate to [http://the-internet.herokuapp.com/upload]
//    Upload a small image file
//    Assert that the file was uploaded successfully
//    Close Google Chrome

    By chooseFileButton = By.id("file-upload");
    By uploadButton = By.id("file-submit");
    By uploadSuccessMessage = By.xpath("//div[@class='row']//h3");

    public PageTask8(FluentDriverEngine bot) {
        this.fluentDriverEngine = bot;
        fluentElementActionsBot = new FluentElementActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
        fluentBrowserActionsBot = new FluentBrowserActionsBot(fluentDriverEngine.getDriver(), fluentDriverEngine.getWait());
    }

    public PageTask8 navigateToUploadPage() {
        fluentBrowserActionsBot.navigateTo("http://the-internet.herokuapp.com/upload");
        return this;
    }


    public PageTask8 uploadFile() {
        fluentElementActionsBot.uploadFile(chooseFileButton,getConfigValue("Task8","path"));
        return this;
    }
    public PageTask8 clickUploadButton() {
        fluentElementActionsBot.click(uploadButton);
        return this;
    }
    public String getUploadSuccessMessage() {
        return fluentElementActionsBot.getText(uploadSuccessMessage);
    }




}