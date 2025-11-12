package objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import genericUtility.GesturesUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepage {
	
	AppiumDriver driver;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.horcrux.svg.PathView\").instance(4)")
	private WebElement homeBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.horcrux.svg.PathView\").instance(5)")
	private WebElement menuBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.horcrux.svg.PathView\").instance(8)")
	private WebElement nearByStoreBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(7)")
	private WebElement SelectServiceBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"com.horcrux.svg.PathView\").instance(6)")
	private WebElement crownRewardsBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(83)")
	private WebElement hamBurgerBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Show Crowns\"]")
	private WebElement showCrownBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Redeem\"]")
	private WebElement redeemBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Recent Orders\")")
	private WebElement recentOrdersBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved Addresses\")")
	private WebElement savedAddressBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved King Deals\")")
	private WebElement savedKingDealsBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"BK Wall\")")
	private WebElement bkWallBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"FAQs & Support\")")
	private WebElement faqSupportbtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Nutrition Info\")")
	private WebElement nutritionBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Logout\")")
	private WebElement logoutBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(9)")
	private WebElement bkCafe;
	
	

	public Homepage(AppiumDriver driver) {
		
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
	}
	
	

	public WebElement getCrownRewardsBtn() {
		return crownRewardsBtn;
	}
	
	public WebElement getSelectServiceBtn() {
		return SelectServiceBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getNearByStoreBtn() {
		return nearByStoreBtn;
	}

	public WebElement getHamBurgerBtn() {
		return hamBurgerBtn;
	}

	public WebElement getShowCrownBtn() {
		return showCrownBtn;
	}

	public WebElement getRedeemBtn() {
		return redeemBtn;
	}

	public WebElement getRecentOrdersBtn() {
		return recentOrdersBtn;
	}

	public WebElement getSavedAddressBtn() {
		return savedAddressBtn;
	}

	public WebElement getSavedKingDealsBtn() {
		return savedKingDealsBtn;
	}

	public WebElement getBkWallBtn() {
		return bkWallBtn;
	}

	public WebElement getFaqSupportbtn() {
		return faqSupportbtn;
	}

	public WebElement getNutritionBtn() {
		return nutritionBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getBkCafe() {
		return bkCafe;
	}
	


}
