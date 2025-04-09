package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1. id : is an attribute : unique
		//driver.findElement(By.id("input-email")).sendKeys("test@email.com");
		
		//2. name : is an attribute : can't be unique
		//driver.findElement(By.name("email")).sendKeys("test@email.com");
		
		//3. className: is an attribute: mostly duplicate
		//driver.findElement(By.className("form-control")).sendKeys("testemail");
		//c1 c2 c3 ..... cn
		
		//4 xpath : is an address of the element in HTML dom.
		//driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@email.com");
		
		//5 cssSelectors: is also an address
		
		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@email.com");
		
		By emailId=By.cssSelector("#input-email");
		By pass=By.cssSelector("");
		doSendKeys(emailId, "test@email.com");
		
		//6. linkText: only for the links. this is the text of the link. 
		//LinkText can be duplicate ex. forgotten password
		driver.findElement(By.linkText("Register")).click();
		By registerLink=By.linkText("Register");
		doClick(registerLink);
		
		// 7. Partial linkText-
		driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8 tagName: html tag
		String header=driver.findElement(By.tagName("h2")).getText();
		By tagText=By.tagName("h2");
		doElementGetText(tagText);
		
		// to check use
		// for id #
		// for class .
	}
		public static String doElementGetText(By locator) {
			return getElement(locator).getText();

		}
		public static void doSendKeys(By locator, String value) {
			getElement(locator).sendKeys(value);
		}
		public static WebElement getElement (By locator) {
			return driver.findElement(locator);
		}
		public static void doClick(By locator) {
			getElement(locator).click();
		}
		
		
	}

