package engine;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class FluentBrowserActionsBot{
    WebDriver driver;
    Wait<WebDriver> wait;

    public FluentBrowserActionsBot(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public FluentBrowserActionsBot() {
        driver = initialize();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);
    }



    private WebDriver initialize() {
        WebDriver driver;
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        switch (browser) {
            case "safari" -> driver = new SafariDriver();
            case "firefox" -> driver = new org.openqa.selenium.firefox.FirefoxDriver();
            case "edge" -> driver = new org.openqa.selenium.edge.EdgeDriver();
            default -> driver = new ChromeDriver();
        }
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    public FluentBrowserActionsBot navigateTo(String url) {
        driver.navigate().to(url);
        return this;
    }

    public String getTitle() {
        return wait.until(d -> d.getTitle());
    }

    public WebDriver getDriver() {
        return driver;
    }

    public  Wait<WebDriver> getWait() {
        return wait;
    }
}
