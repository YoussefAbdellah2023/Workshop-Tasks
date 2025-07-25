package engine;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static Files.FluentFilesBot.getConfigValue;

public class FluentDriverEngine {


    String browser;
    String driverType;

    WebDriver driver;
    Wait<WebDriver> wait;

    ThreadLocal<WebDriver> threadDriver;
    ThreadLocal<Wait<WebDriver>> threadWait;

    public FluentDriverEngine(String browser, String driverType) {
        this.browser = browser.toLowerCase();
        this.driverType = driverType.toLowerCase();

        switch (this.driverType) {
            case "grid" -> initializeSeleniumGrid();
            case "threaddriver" -> initializeThreadLocal();
            default -> initializeDriver();
        }
    }

    // TODO: Initialize Selenium Grid
    public void initializeSeleniumGrid() {
        this.driver = createRemoteDriver(browser);
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);

        System.out.println("Initialized Selenium Grid RemoteWebDriver");
    }

    // TODO: WorkShop Tasks (#15) Selenium Grid Support
    private WebDriver createRemoteDriver(String browser) {
        String gridUrl = getConfigValue("Drivers", "gridUrl");
        MutableCapabilities options;
        switch (browser) {
            case "firefox" -> options = new FirefoxOptions();
            case "edge" -> options = new EdgeOptions();
            case "safari" -> options = new SafariOptions();
            default -> options = new ChromeOptions();
        }

        try {
            return new RemoteWebDriver(new URL(gridUrl), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Grid URL is malformed: " + gridUrl, e);
        }
    }


    // TODO: Initialize Driver
    private void initializeDriver() {
        this.driver = initialize();
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);

        System.out.println("Initialized regular WebDriver mode");
    }


    // TODO: Initialize ThreadLocal Driver and Wait
    private void initializeThreadLocal() {
        this.threadDriver = ThreadLocal.withInitial(this::initialize);

        this.threadWait = ThreadLocal.withInitial(() ->
                new FluentWait<>(threadDriver.get())
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(ElementNotInteractableException.class)
                        .ignoring(NoSuchElementException.class)
        );

        System.out.println("Initialized ThreadLocal WebDriver mode");
    }


    private WebDriver initialize() {
        WebDriver driver;

        switch (this.browser.toLowerCase()) {
            case "safari" -> driver = new SafariDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> driver = new ChromeDriver();
        }

        System.out.println("Created " + this.browser + " driver instance");
        return driver;
    }

    public WebDriver getDriver() {
        if (this.driverType.equals("threaddriver")) {
            return threadDriver.get();
        } else {
            return driver;
        }
    }

    public Wait<WebDriver> getWait() {
        if (this.driverType.equals("threaddriver")) {
            return threadWait.get();
        } else {
            return wait;
        }
    }

    public void quit() {
        if (this.driverType.equals("threaddriver")) {
            WebDriver currentDriver = threadDriver.get();
            if (currentDriver != null) {
                currentDriver.quit();
                threadDriver.remove();
                threadWait.remove();
                System.out.println("ThreadLocal driver quit and cleaned up");
            }
        } else {
            if (driver != null) {
                driver.quit();
                System.out.println("Regular driver quit");
            }
        }
    }


}
