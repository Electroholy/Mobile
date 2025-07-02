package tests.account;
import static mobile.enums.LoginTitle.LOGIN_TITLE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import mobile.helper.TestDescription;
import mobile.screens.HomeScreen;
import tests.BaseTest;

@Slf4j
public class GetProfileScreenTest extends BaseTest {

    @Test
    @DisplayName("Open Login Screen")
    @TestDescription("Close advertisement, skip the quiz, open login screen")
    public void testGetLoginScreen() {
        HomeScreen homeScreen = new HomeScreen(driver);

        homeScreen
                .closeAdvertisementAndNotification()
                .skipQuiz()
                .openLoginScreen()
                .verifyLoginScreenOpened(LOGIN_TITLE);
    }
}
