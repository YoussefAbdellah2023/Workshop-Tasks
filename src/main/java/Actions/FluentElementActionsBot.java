package Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;

public class FluentElementActionsBot {

    WebDriver driver;
    Wait<WebDriver> wait;

    public FluentElementActionsBot(WebDriver driver, Wait<WebDriver> wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getDomAttribute(By locator, String property) {
        return wait.until(d -> d.findElement(locator).getDomProperty(property));

    }

    public FluentElementActionsBot click(By locator) {
        wait.until(d -> {
            d.findElement(locator).click();
            return true;
        });
        return this;
    }

    public FluentElementActionsBot type(By locator, CharSequence... text) {
        wait.until(d -> {
            d.findElement(locator).clear();
            d.findElement(locator).sendKeys(text);
            return true;
        });
        return this;
    }


    public FluentElementActionsBot uploadFile(By locator, String filePath) {
        File uploadFile = new File(filePath);
        wait.until(d -> {
            d.findElement(locator).sendKeys(uploadFile.getAbsolutePath());
            return true;
        });
        return this;
    }

    public String getDomProperty(By locator, String property) {
        return wait.until(d -> d.findElement(locator).getDomProperty(property));
    }


    public boolean isDisplayed(By locator) {
        wait.until(d -> d.findElement(locator).isDisplayed());
        return true;
    }

    public boolean isSelected(By locator) {
        return wait.until(d -> d.findElement(locator).isSelected());
    }

    public FluentElementActionsBot dragAndDrop(By source, By target) {
        wait.until(d -> {
            WebElement sourceElement = d.findElement(source);
            WebElement targetElement = d.findElement(target);
            new Actions(d)
                    .dragAndDrop(sourceElement, targetElement)
                    .perform();
            return true;
        });
        return this;
    }

    public String getText(By locator) {
        return wait.until(d -> d.findElement(locator).getText());
    }
}
