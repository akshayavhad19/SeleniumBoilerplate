package selenium.java;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TakeScreenshotOnFailure1 extends TakeScreenShotOnFailure{
	
	//TakeScreenShotOnFailure ss = new TakeScreenShotOnFailure();
	@Test
	public void Login() {
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicitywait use only once in project

		driver.get("https://www.facebook.com/");
		try {
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("Zukierberg");
		}
		catch (Exception e) {
			System.out.println("Element not found");		}
		try {
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("ZukierbergPass");
			}
		catch (Exception e) {
			System.out.println("Element not found");
		}
	}
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) throws Exception {
		captureScreenshot(result);
	}

}
