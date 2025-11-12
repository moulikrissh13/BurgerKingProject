package com.burgerKing.assignment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericUtility.BaseConfig;
import genericUtility.UtilityClassObject;
import io.appium.java_client.AppiumBy;
import objectRepository.CrownRewardsPage;
import objectRepository.Homepage;


@Listeners(genericUtility.ListenerImpementation.class)
public class CaptureCrowns_Test extends BaseConfig{


	@Test
	public void e2esample2Test() throws InterruptedException, IOException {
		
		home = new Homepage(driver);
		
		rewards = new CrownRewardsPage(driver);
		
		home.getSelectServiceBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Service Button clicked");
		
		Thread.sleep(3000);

		home.getCrownRewardsBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Rewards Button clicked");
		
		Thread.sleep(3000);

		rewards.getHistoryBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "History Button clicked");
		
	//	UtilityClassObject.getTest().info("Using direct info()");
		
		System.out.println("Rewards button clicked");
		
		Thread.sleep(3000);

		TakesScreenshot ts = (TakesScreenshot) driver;

		File temp = ts.getScreenshotAs(OutputType.FILE);

		String time = new java.util.Date().toString().replace(" ", "_").replace(":", "_");

		File perm = new File("./Screenshots/homepage" + time + ".png");

		FileUtils.copyFile(temp, perm);
		
		UtilityClassObject.getTest().log(Status.INFO, "Screenshot Captured");

		System.out.println("Screenshot captured");

		Thread.sleep(3000);

	}
}
