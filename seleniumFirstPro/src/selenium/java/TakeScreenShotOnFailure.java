package selenium.java;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class TakeScreenShotOnFailure {

	WebDriver driver; 
	public static void main(String[] args) {


	}
	public void captureScreenshot(ITestResult result) throws Exception {

		if(ITestResult.FAILURE==result.getStatus()) {
			//creating ref of TakeScreenShot interface and perform type casting
			TakesScreenshot ts =(TakesScreenshot) driver; //type casting
			
			//using getScreenShotAs() method to capture failure
			//getScreenShotAs() return in file format
			File source =ts.getScreenshotAs(OutputType.FILE);
			
			//copy file in specified location
		FileUtils.copyFile(source, new File("./ScreenShotsOfFailedCase/"+result.getName()+".png"));
		System.out.println(result.getName()+ " Method() Screenshot Captured");
		}
	}
}
