package Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;


public class FluentBrowserActionsBot{

    private final WebDriver driver;
    private final Wait<WebDriver> wait;

    public FluentBrowserActionsBot(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public FluentBrowserActionsBot navigateTo(String url) {
        driver.navigate().to(url);
        return this;
    }

    public  String getTitle() {
        return wait.until(d -> d.getTitle());
    }

}
