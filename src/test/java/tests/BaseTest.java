package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mobile.Initializer;
import mobile.helper.Helper;

@Slf4j
public class BaseTest {
    protected static AppiumDriver driver;

    @BeforeEach
    public void setUp() {
        log.info("Driver initializing before test\n");
        driver = Initializer.getDriver();
        Helper.setDriver(driver);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        log.info("!!!Starting the TEST!!!\n");
    }

    @AfterEach
    public void tearDown() {
        log.info("Driver closing after test\n");
        Initializer.quitDriver();
    }
}
