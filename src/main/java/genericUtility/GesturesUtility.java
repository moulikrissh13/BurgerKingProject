package genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GesturesUtility {

	AndroidDriver driver;

	public GesturesUtility(AndroidDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickByElement(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void clickByCoordinates(int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of("x", x, "y", y));
	}

	public void doubleClickByElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void doubleClickByCoordinates(int x, int y) {

		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of("x", x, "y", y));
	}

	public void dragAndDropByElement(WebElement element, int endX, int endY, int speed) {

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "endX", endX, "endY", endY, "speed", speed));
	}

	public void dragAndDropByCoordinates(int startX, int startY, int endX, int endY, int speed) {

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("startX", startX, "startY", startY, "endX", endX, "endY", endY, "speed", speed));
	}

	public void longClickByElement(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void longClickByCoordinates(int x, int y) {

		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of("x", x, "y", y));
	}

	public void swipeByElement(WebElement element, String direction, double percent) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", direction, "percent", percent));
	}

	public void swipeByCoordinates(int left, int top, int width, int height, String direction, double percent) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", left, "top", top,
				"width", width, "height", height, "direction", direction, "percent", percent));
	}

	public WebElement scrollByText(String text) {

		WebElement elementText = driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

		return elementText;
	}

	public void pinchOpen(WebElement element, double percent, int speed) {

		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percent, "speed", speed));
	}

	public void pinchClose(WebElement element, double percent, int speed) {

		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percent, "speed", speed));
	}

	public boolean scrollByElement(WebElement element, String direction, double percent) {

		boolean canScroll = (Boolean)(((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "direction", direction, "percent", percent)));
		return canScroll;
	}
	
	public void scrollByCoordinates(int left, int top, int width, int height, WebElement element, String direction, double percent) {
		
		boolean canScroll = (Boolean)(((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("left", left, "top", top, "width", width, "heigth", height, "direction", direction, "percent", percent)));
	}

}
