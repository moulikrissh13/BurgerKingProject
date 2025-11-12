package com.burgerKing.assignment;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseConfig;
import genericUtility.GesturesUtility;
import io.appium.java_client.AppiumBy;
import objectRepository.Homepage;


@Listeners(genericUtility.ListenerImpementation.class)
public class NutritioniInfo extends BaseConfig{
	
	
	@Test
	public void nutritionInfoTest() throws InterruptedException {
		
		home = new Homepage(driver);
		
		gesture = new GesturesUtility(driver);
		
		home.getSelectServiceBtn().click();
		
		Thread.sleep(3000);
		
		//home.getHamBurgerBtn().click();
		
		gesture.clickByCoordinates(98, 161);
		
		System.out.println("Hamburger Button clicked");
		
		home.getNutritionBtn().click();
		
		Thread.sleep(3000);
		
		WebElement el = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\")"));
		
		gesture.pinchOpen(el, 0.75, 7500);
		
		System.out.println("Zoom in successful");
		
		gesture.pinchClose(el, 0.75, 5000);

		System.out.println("Zoom out successful");
		
		gesture.clickByCoordinates(116, 174);
		
		gesture.clickByCoordinates(116, 174);
		
		System.out.println("Gesture performed successfully..!!");
	}

}
