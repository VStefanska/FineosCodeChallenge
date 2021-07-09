package support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.Driver.getDriver;

public class BrowserUtils {

    private static WebDriverWait wait;
    private static Actions actions = new Actions(getDriver());
    private static JavascriptExecutor executor = (JavascriptExecutor) getDriver();

    public static WebDriverWait getWait(int seconds) {
        wait = new WebDriverWait(getDriver(), seconds);
        return wait;
    }

    public static void waitUntilVisibilityOfTheElement(WebElement element, int seconds) {
        getWait(seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementToBeClickable(WebElement element, int seconds) {
        getWait(seconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static Actions getActions() {
        return actions;
    }

    public static void scrollToTheBottomPage() {
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static JavascriptExecutor getExecutor() {
        return executor;
    }

    public static void clickOnElementWithJS(WebElement element) {
        executor.executeScript("arguments[0].click();", element);
    }
}
