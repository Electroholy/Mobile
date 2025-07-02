package mobile.screens;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.LoginTitle;
import mobile.helper.Helper;
import mobile.locators.LoginLocators;

@Slf4j
public class ProfileScreen extends BaseScreen {
    public ProfileScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyLoginScreenOpened(LoginTitle loginTitle) {
        assertThat(Helper.isTextOnScreen(loginTitle.getValue()))
                .as("Check if the text '%s' is visible on screen", loginTitle.getValue())
                .isTrue();
        log.info("Verified {} text is visible", loginTitle.getValue());
    }

    @AndroidFindBy(xpath = LoginLocators.LOGIN_BUTTON)
    private WebElement loginButton;
    public ProfileScreen openRegistrationForm () {
        waitUntilElementIsVisible(loginButton);
        loginButton.click();
        log.info("Login profile: opened");
        return this;
    }

    @AndroidFindBy(xpath = LoginLocators.MORE_OPTION_FOR_REGISTRATION)
    private WebElement moreOptionForRegistration;
    public void showMoreOption() {
        waitUntilElementIsVisible(moreOptionForRegistration);
        moreOptionForRegistration.click();
    }

    @AndroidFindBy(xpath = LoginLocators.EMAIL_OPTION)
    private WebElement emailOption;
    public SignUpPopUpScreen choseEmailOption() {
        showMoreOption();
        waitUntilElementIsVisible(emailOption);
        emailOption.click();
        log.info("Sign up with email: Accepted");
        return new SignUpPopUpScreen(driver);
    }
}
