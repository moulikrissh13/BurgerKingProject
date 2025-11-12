package objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CrownRewardsPage {

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"HISTORY\")")
	private WebElement historyBtn;
	
	
	public CrownRewardsPage(AppiumDriver driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
	}

	public WebElement getHistoryBtn() {
		return historyBtn;
	}
	
	
	
}
