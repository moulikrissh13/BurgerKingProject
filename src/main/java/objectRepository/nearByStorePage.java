package objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class nearByStorePage {
	
	AppiumDriver driver;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(7)")
	private WebElement button;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.horcrux.svg.PathView\").instance(6)")
	private WebElement crownRewardsBtn;

	public nearByStorePage(AppiumDriver driver) {
		
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
	}

	public WebElement getCrownRewardsBtn() {
		return crownRewardsBtn;
	}
	
	public WebElement getButton() {
		return button;
	}

}
