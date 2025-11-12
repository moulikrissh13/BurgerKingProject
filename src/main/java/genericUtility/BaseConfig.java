package genericUtility;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import objectRepository.CrownRewardsPage;
import objectRepository.Homepage;
import objectRepository.MenuPage;

public class BaseConfig {

	public AppiumDriverLocalService service;
	
	public AndroidDriver driver;
	
	public static AndroidDriver eDriver;
	
	FileUtility fLib;
	
	public AndroidDriverUtility androidUt;
	
	public GesturesUtility gesture;
	
	public Homepage home;
	
	public MenuPage menu;
	
	public CrownRewardsPage rewards;

	@BeforeSuite(groups = {"smoke", "regression"})
	public void startServer() {

		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\mouli\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		
		System.out.println("Server started");
	}

	@BeforeClass(groups = {"smoke", "regression"})
	public void launchApp() throws IOException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		
		fLib = new FileUtility();
		
		cap.setCapability("platformName", fLib.readDataFromPropertyFiles("platformName"));
		
		cap.setCapability("automationName", fLib.readDataFromPropertyFiles("automationName"));
		
		cap.setCapability("deviceName", fLib.readDataFromPropertyFiles("deviceName"));
		
		cap.setCapability("UDID", fLib.readDataFromPropertyFiles("UDID"));
		
//		cap.setCapability("appPackage", fLib.readDataFromPropertyFiles("appPackage"));
		
		driver = new AndroidDriver(new URL("http://localhost:4723"), cap);
		
		eDriver = driver;
		
//		UtilityClassObject.setDriver(driver);
		
		androidUt = new AndroidDriverUtility(driver);
		
		androidUt.openApp(fLib.readDataFromPropertyFiles("appPackage"));
		
		System.out.println("Opened application");
		
		Thread.sleep(3000);
	}

	@BeforeMethod(groups = {"smoke", "regression"})
	public void login() throws InterruptedException {
		
		Thread.sleep(2000);
		
		System.out.println("Login successful");
	}

	@AfterMethod(groups = {"smoke", "regression"})
	public void logout() {

		System.out.println("Logout");
	}

	@AfterClass(groups = {"smoke", "regression"})
	public void closeApp() throws IOException, InterruptedException {
		
		Thread.sleep(2000);
		
		fLib = new FileUtility();
		
		androidUt = new AndroidDriverUtility(driver);

		androidUt.closeApp(fLib.readDataFromPropertyFiles("appPackage"));;
		
		System.out.println("Closed application");
	}

	@AfterSuite(groups = {"smoke", "regression"})
	public void stopServer() {

		service.stop();
		
		System.out.println("Server stopped");
	}

}
