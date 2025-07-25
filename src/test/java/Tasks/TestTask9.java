package Tasks;

import Pages.PageTask9;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTask9 extends FluentBotTestCase{

    //    Open Google Chrome
//    Navigate to [https://jqueryui.com/resources/demos/droppable/default.html]
//    Drag [Drag me to my target] and drop it on [Drop here]
//    Assert that the text has been changed to [Dropped!]
//    Close Google Chrome

    @Test
    public void verifyDragAndDropFunctionality(){
        String actualResult=  new PageTask9(bot)
                .navigateToPage()
                .dragAndDropItem()
                .TextChangedAfterDropped();

        Assert.assertEquals(actualResult, "Dropped!", "Text after drop is not as expected");
    }


}