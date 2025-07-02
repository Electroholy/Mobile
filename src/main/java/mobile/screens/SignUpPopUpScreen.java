package mobile.screens;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.helper.Helper;
import mobile.locators.PopUpLocators;
import mobile.utils.Constants;
import mobile.utils.UtilsMethod;

@Slf4j
public class SignUpPopUpScreen extends BaseScreen {
    public SignUpPopUpScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = PopUpLocators.SIGN_UP_BUTTON)
    private WebElement signUpButton;
    public void signUp() {
        waitUntilElementIsVisible(signUpButton);
        signUpButton.click();
    }

    @AndroidFindBy(xpath = PopUpLocators.FIRST_NAME_FIELD)
    private WebElement firstNameField;
    public void setFirstName (String firstName) {
        waitUntilElementIsVisible(firstNameField);
        firstNameField.click();
        firstNameField.sendKeys(firstName);
    }

    @AndroidFindBy(xpath = PopUpLocators.LAST_NAME_FIELD)
    private WebElement lastNameField;
    public void setLastName (String lastName) {
        waitUntilElementIsVisible(lastNameField);
        lastNameField.click();
        lastNameField.sendKeys(lastName);
    }

    @AndroidFindBy(xpath = PopUpLocators.EMAIL_FIELD)
    private WebElement emailField;
    public void setEmail (String email) {
        waitUntilElementIsVisible(emailField);
        emailField.click();
        emailField.sendKeys(email);
    }

    @AndroidFindBy(xpath = PopUpLocators.PASSWORD_FIELD)
    private WebElement passwordField;
    public void setPassword (String password) {
        waitUntilElementIsVisible(passwordField);
        passwordField.click();
        passwordField.sendKeys(password);
    }

    @AndroidFindBy(xpath = PopUpLocators.CONFIRMATION_PASSWORD_FIELD)
    private WebElement passwordConfirmationField;
    public void setPasswordConfirmation (String passwordConfirmation) {
        waitUntilElementIsVisible(passwordConfirmationField);
        passwordConfirmationField.click();
        passwordConfirmationField.sendKeys(passwordConfirmation);
    }

    @AndroidFindBy(xpath = PopUpLocators.FINISH_SIGN_UP_BUTTON)
    private WebElement finishSignUpButton;
    public void register () {
        waitUntilElementIsVisible(finishSignUpButton);
        finishSignUpButton.click();
        log.info("System login: completed");
    }

    public SignUpPopUpScreen registrationNewUser(AddUserData addUserData) {
        signUp();
        setFirstName(addUserData.getUserFirstName());
        setLastName(addUserData.getUserLastName());
        setEmail(addUserData.getUserEmail());
        setPassword(addUserData.getUserPassword());
        setPasswordConfirmation(addUserData.getUserPasswordConfirm());
        log.info("Registration: User '{}' successful", addUserData.getUserEmail());
        register();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return this;
    }

    public void verifyUserRegistered(AccountTitle accountTitle) {
        assertThat(Helper.isTextOnScreen(accountTitle.getValue()))
                .as("Check if '%s' text is visible on the screen", accountTitle.getValue())
                .isTrue();
        log.info("Verified '{}' text is visible", accountTitle.getValue());
    }
}
