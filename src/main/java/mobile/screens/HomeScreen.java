package mobile.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mobile.locators.HomeLocators;

@Slf4j
@Setter
public class HomeScreen extends BaseScreen {

    public HomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = HomeLocators.ACCEPT_NOTIFICATIONS)
    private WebElement acceptNotifications;
    @AndroidFindBy(xpath = HomeLocators.DECLINE_NEW_APP)
    private WebElement declineNewApp;
    public HomeScreen closeAdvertisementAndNotification() {
        int x1 = 1246;
        int y1 = 299;
        int x2 = 660;
        int y2 = 2603;

        tapByCoordinate(x1,y1);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        tapByCoordinate(x2,y2);
        waitUntilElementIsVisible(acceptNotifications);
        acceptNotifications.click();
        waitUntilElementIsVisible(declineNewApp);
        declineNewApp.click();
        log.info("Advertisement: closed");
        return new HomeScreen(driver);
    }

    @AndroidFindBy(xpath = HomeLocators.SKIP_SPINNING_WHEEL)
    private WebElement skipQuizButton;
    public HomeScreen skipQuiz() {
        waitUntilElementIsVisible(skipQuizButton);
        skipQuizButton.click();
        log.info("Spinning wheel: skipped");
        return new HomeScreen(driver);
    }

    @AndroidFindBy(xpath = HomeLocators.PROFILE_BUTTON)
    private WebElement openProfileButton;
    public ProfileScreen openLoginScreen() {
        waitUntilElementIsVisible(openProfileButton);
        openProfileButton.click();
        log.info("Profile screen: opened");
        return new ProfileScreen(driver);
    }
}
