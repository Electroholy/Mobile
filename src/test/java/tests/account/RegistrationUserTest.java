package tests.account;

import static mobile.utils.Constants.USER_EMAIL;
import static mobile.utils.Constants.USER_FIRST_NAME;
import static mobile.utils.Constants.USER_LAST_NAME;
import static mobile.utils.Constants.USER_PASSWORD;
import static mobile.utils.Constants.USER_PASSWORD_CONFIRM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.generator.FakeRandomGenerator;
import mobile.helper.TestDescription;
import mobile.screens.HomeScreen;
import tests.BaseTest;

public class RegistrationUserTest extends BaseTest {

    private final AddUserData addUserData = AddUserData.builder()
            .userFirstName(USER_FIRST_NAME)
            .userLastName(USER_LAST_NAME)
            .userEmail(USER_EMAIL)
            .userPassword(USER_PASSWORD)
            .userPasswordConfirm(USER_PASSWORD_CONFIRM)
            .build();

    @Test
    @DisplayName("User registration")
    @TestDescription("Close advertisement, skip the quiz, open login screen and sign up")
    public void testRegistrationUser() {
        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen
                .closeAdvertisementAndNotification()
                .skipQuiz()
                .openLoginScreen()
                .openRegistrationForm()
                .choseEmailOption()
                .registrationNewUser(addUserData)
                .verifyUserRegistered(FakeRandomGenerator.getRandomOption(AccountTitle.class));
    }
}
