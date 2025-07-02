package mobile;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Initializer {
    private static AppiumDriver driver;
    static Properties config = new Properties();

    static {
        try (InputStream input = Initializer.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                log.error("Config.properties not found");
            }
            config.load(input);
        } catch (Exception e) {
            log.error("Unsuccessful load configuration");
            throw new ExceptionInInitializerError();
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        try {
            URI appiumServerURI = new URI(config.getProperty("appium.server.url"));
            URL appiumServerURL = appiumServerURI.toURL();
            driver = new AndroidDriver(appiumServerURL, getDesiredCapabilities());
            log.info("Successful initialization");
        } catch (Exception e) {
            log.error("Unsuccessful initialization");
            throw new RuntimeException(e);
        }
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, config.getProperty("platform.name"));
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getProperty("device.name"));
        desiredCapabilities.setCapability("appPackage", config.getProperty("app.package"));
        desiredCapabilities.setCapability("appActivity", config.getProperty("app.activity"));
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, config.getProperty("automation.name"));
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, config.getProperty("new.command.timeout"));
        return desiredCapabilities;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
