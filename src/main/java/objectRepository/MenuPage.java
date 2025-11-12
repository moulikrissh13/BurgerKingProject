package objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuPage {
	
	AppiumDriver driver;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(42)")
	private WebElement bevaragesButton;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(83)")
	private WebElement cappuccinoSmallBtn;

	public MenuPage(AppiumDriver driver) {
		
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
	}

	public WebElement getCappuccinoSmallBtn() {
		return cappuccinoSmallBtn;
	}
	
	public WebElement getBevaragesButton() {
		return bevaragesButton;
	}

}
