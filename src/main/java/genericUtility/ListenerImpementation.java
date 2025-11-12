package genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImpementation implements ITestListener, ISuiteListener{

//	@Override
//	public void onTestFailure(ITestResult result) {
//
//		String methodName = result.getMethod().getMethodName();
//
//		TakesScreenshot ts = (TakesScreenshot) BaseConfig.eDriver;
//		
//		File temp = ts.getScreenshotAs(OutputType.FILE);
//		
//		String time = new Date().toString().replace(" ", "_").replace(":", "_");
//		
//		File perm = new File("FailedTest_"+methodName+"_"+time+".png");
//		
//		try {
//			FileUtils.copyFile(temp, perm);
//			
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//	}
	
	
	public ExtentReports er;
	
	public  ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		
		System.out.println("Pre Reports");
		
		String time = new Date().toString().replace(" ","_").replace(":","_");
		
		String path = "./Advance Reports/reports"+time+".html";
		
	ExtentSparkReporter es = new ExtentSparkReporter(path);
		
		es.config().setDocumentTitle("Test Suite Result");
		
		es.config().setReportName("Test Report");
		
		es.config().setTheme(Theme.STANDARD);
		
		//2. add environment information & create test
		
		//2.1 create an object for ExtentReports
		
		 er = new ExtentReports();
		
		er.attachReporter(es);
		
		er.setSystemInfo("OS", "Windows-11");
		
		er.setSystemInfo("BROWSER", "Chrome");
	}
 
	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("Reports Back Up");
		
		er.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		
		System.out.println(testName+" is started");
		
	    test = er.createTest(testName);
	    
	    UtilityClassObject.setTest(test);
	    
		test.log(Status.INFO, testName+" ====>Started<====");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		String testName = result.getName();
		
		System.out.println(testName+" is end");
		
		test.log(Status.INFO, testName+" ====>Success<====");
	}
 
	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		
		if(ITestResult.FAILURE == result.getStatus()) {

			TakesScreenshot ts = (TakesScreenshot) BaseConfig.eDriver;
			
			 String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		//providing time-stamp to screenshot
		
	//	 String time = new Date().toString().replace(" ","_").replace(":","_");
		
			test.addScreenCaptureFromBase64String(filePath,testName);

			test.log(Status.INFO, testName+" ====>Failed<====");
		}
	
	}	
	
	

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getName();
		
		test.log(Status.SKIP, testName + " =====>Skipped<=====");
		
	}	


}
