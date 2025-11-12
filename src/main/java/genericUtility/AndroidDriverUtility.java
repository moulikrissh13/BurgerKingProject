package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;

public class AndroidDriverUtility {

	AndroidDriver driver;
	
	
	public AndroidDriverUtility(AndroidDriver driver) {
		super();
		this.driver = driver;
	}

	public void installApp(String path) {
		
		driver.installApp(path);
	}
	
	public boolean isAppInstalled(String packageName) {
		
		boolean status = driver.isAppInstalled(packageName);
		
		return status;
	}
	
	public void uninstallApp(String packageName) {
		
		driver.removeApp(packageName);
	}
	
	public void openApp(String packageName) {
		
		driver.activateApp(packageName);
	}
	
	public void closeApp(String packageName) {
		
		driver.terminateApp(packageName);
	}
	
	public void openNotificationsBar() {
		
		driver.openNotifications();
	}
	
	public void orientation(String rotationType) {
		
		ScreenOrientation screen = driver.getOrientation();
		
		if(rotationType.equals("portrait"))
			driver.rotate(screen.PORTRAIT);
		else
			driver.rotate(screen.LANDSCAPE);
	}
	
	public void closeKeyboard() {
		
		driver.hideKeyboard();
	}
	
	public ApplicationState appRunningStatus(String packageName, int seconds) {
		
		driver.runAppInBackground(Duration.ofSeconds(seconds));
		
		ApplicationState status = driver.queryAppState(packageName);
		
		return status;
	}
	
	public void copyToClipboard(String text) {
		
		driver.setClipboardText(text);
	}
	
	public String getClipboardMsg() {
		
		String text = driver.getClipboardText();
		
		return text;
	}
	
	public void handleContext(AndroidDriver driver, String webContext) {
		
		this.driver = driver;
		
		Set<String> allAddress = driver.getContextHandles();
		
		for(String address : allAddress) {
			
			
		}
	}
}
