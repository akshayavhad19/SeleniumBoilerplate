package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartLoginTest {
	public static void main(String[] args) {
		BrowserUtils brutils=new BrowserUtils();
		WebDriver driver=brutils.launchBrowser("chrome");
		brutils.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//By eid= By.id("input-email");
		//By pwd= By.id("input-password");
		String email_id="input-email";
		String pass_id="input-password";
		ElementUtil eliUtil=new ElementUtil(driver);	
		//eliUtil.doSendKeys(eid, "testuser@gmail.com");
		//eliUtil.doSendKeys(pwd, "password@123");
		eliUtil.doSendKeys("id",email_id, "testuser@gmail.com");
		eliUtil.doSendKeys("id", pass_id, "password@123");
		//brutils.closeBrowser();
		
	}


}
