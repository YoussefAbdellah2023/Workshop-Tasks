package Tasks;

import engine.FluentDriverEngine;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static Files.FluentFilesBot.getConfigValue;

public abstract class FluentBotTestCase {
    FluentDriverEngine bot;

    @Parameters({"browser", "driverType"})
    @BeforeMethod
    public void setup(@Optional("") String browser, @Optional("") String driverType) {

//        TODO: WorkShop Tasks (#14) Read browser type from getProperty. To Run Any Class On Any Browser From Command Line
//        TODO: WorkShop Tasks (#12) Read browser type from Properties file

        if (browser == null || browser.isEmpty()) {
            if (getConfigValue("Drivers", "browser") != null) {
                browser = getConfigValue("Drivers", "browser");
            } else {
                browser = System.getProperty("browser", "chrome");
            }
        }

        if (driverType == null || driverType.isEmpty()) {
            if (getConfigValue("Drivers", "driver") != null) {
                driverType = getConfigValue("Drivers", "driver");
            } else {
                driverType = System.getProperty("driverType", "driver");
            }
        }

        System.out.println("Browser = " + browser + " | driverType = " + driverType);
        bot = new FluentDriverEngine(browser.toLowerCase(), driverType.toLowerCase());
    }


    @AfterMethod
    public void tearDown() {
        bot.quit();
        bot = null;
    }


}