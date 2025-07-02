package mobile.screens;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseScreen {

    protected AppiumDriver driver;

    public BaseScreen (AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void tapByCoordinate (int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 0);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
    }

    public void scrollToTop() {
        int startX = 700;
        int startY = 1400;

        Dimension size = driver.manage().window().getSize();
        int endY = 1;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe;

        for (int i = 0; i < 4; i++) {
            swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Collections.singletonList(swipe));
        }
    }

    public void zoom () {
        int startFingerX = 700;
        int startFingerY = 1400;

        int endFinger1X = 700;
        int endFinger1Y = 600;

        int endFinger2X = 700;
        int endFinger2Y = 2300;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence tapFinger1 = new Sequence(finger1, 1);
        tapFinger1.addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startFingerX, startFingerY));
        tapFinger1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapFinger1.addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endFinger1X, endFinger1Y));
        tapFinger1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        Sequence tapFinger2 = new Sequence(finger2, 2);
        tapFinger2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startFingerX, startFingerY));
        tapFinger2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapFinger2.addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endFinger2X, endFinger2Y));
        tapFinger2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tapFinger1, tapFinger2));
    }

    public void zoomOut () {
        int endFingerX = 700;
        int endFingerY = 1400;

        int startFinger1X = 700;
        int startFinger1Y = 600;

        int startFinger2X = 700;
        int startFinger2Y = 2300;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence tapFinger1 = new Sequence(finger1, 1);
        tapFinger1.addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startFinger1X, startFinger1Y));
        tapFinger1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapFinger1.addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endFingerX, endFingerY));
        tapFinger1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        Sequence tapFinger2 = new Sequence(finger2, 2);
        tapFinger2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startFinger2X, startFinger2Y));
        tapFinger2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapFinger2.addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), endFingerX, endFingerY));
        tapFinger2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(tapFinger1, tapFinger2));
    }
}
