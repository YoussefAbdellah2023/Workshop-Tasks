package Tasks;

import Pages.PageTask8;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask8 extends FluentBotTestCase{


    //    Open Google Chrome
//    Navigate to [http://the-internet.herokuapp.com/upload]
//    Upload a small image file
//    Assert that the file was uploaded successfully
//    Close Google Chrome

    @Test
    public void verifyFileUploadedSuccessfully(){
        String actualResult =  new PageTask8(bot)
                .navigateToUploadPage()
                .uploadFile()
                .clickUploadButton()
                .getUploadSuccessMessage();

        Assert.assertEquals(actualResult,"File Uploaded!", "File upload was not successful");
    }
}