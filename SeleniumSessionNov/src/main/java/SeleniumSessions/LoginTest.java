package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		// get the locator using string
		String email_Id="input-email";
		String password_Id="input-password";
		String loginBtn_Xpath="//*[@id=\"content\"]/div/div[2]/div/form/input";
		String register_linkText="Register";
		
		ElementUtil eleUtil= new ElementUtil(driver);
		eleUtil.doSendKeys("ID", email_Id, "test@email.com");
		eleUtil.doSendKeys("id", password_Id, "pass@123");
		//eleUtil.doClick("xpath", loginBtn_Xpath);
		
		String registerValue=eleUtil.doElementGetText("linkText", register_linkText);
		System.out.println("Register= "+registerValue);
		
	}
}