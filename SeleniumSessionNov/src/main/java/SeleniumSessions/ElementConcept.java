package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		//Webelement
		//Create webelement + Perform action on it (ex. click, sendKeys, getText....)

		WebDriver driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		// 1st approach
		//driver.findElement(By.id("input-email")).sednKey("");
		//2nd approach
		// By locator
		//By eid= By.id("input-email");
		//By pwd= By.id("password");
		//WebElement emailId= driver.findElement(By.id("input-email"));
		//emailId.sendKeys("email@gmail.com");


		//3rd approach- By locator + Generic Method for element and action
		//By eid= By.id("input-email");
		//By pwd= By.id("password");
		//doSendKeys(eid, "email@gmail.com");
		//doSendKeys(pwd, "Pasword@123");
		
		//4th approach- By locator + Generic Method for element and action in other element util class
		//By eid= By.id("input-email");
		//By pwd= By.id("password");
		//ElementUtil eliUtil =new ElementUtil(driver);
		//eliUtil.doSendKeys(eid, "email@gmail.com");
		//eliUtil.doSendKeys(pwd, "Pasword@123");
		
		//5th Approach-By locator + Browserutil + ElementUtil
		
		//6th Approach - By locators --> String locators
		String email_id="input-email";
		String pass_id="input-password";
		ElementUtil eliUtil =new ElementUtil(driver);
		eliUtil.doSendKeys("id",email_id, "testuser@gmail.com");
		eliUtil.doSendKeys("id", pass_id, "password@123");
		
		//7th approach- POM + Framework
	}
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static WebElement getElement (By locator) {
		return driver.findElement(locator);
	}




}
