package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By email_Id=By.id("input-email");
		By register_link=By.linkText("Register");
		
		System.out.println(doGetDomAttribute(email_Id, "placeholder"));
		
		System.out.println(doGetDomAttribute(register_link, "href"));
		
		driver.findElement(email_Id).sendKeys("test@gmail.com");
		System.out.println(doGetDomProprty(email_Id, "value"));

		//String placeholderValue=driver.findElement(email_Id).getDomAttribute("placeholder");
		//System.out.println(placeholderValue);

		//String hrefValue=driver.findElement(register_link).getDomAttribute("href");
		//System.out.println(hrefValue);

		//driver.findElement(email_Id).sendKeys("test@gmail.com");
		//String dynamicValue=driver.findElement(email_Id).getDomProperty("value");
		//System.out.println(dynamicValue);
	}
	public static String doGetDomAttribute(By locator, String attributeName) {
		return getElement(locator).getDomAttribute(attributeName);	
	}
	public static String doGetDomProprty(By locator, String attributeName) {
		return getElement(locator).getDomProperty(attributeName);	
	}

	public static WebElement getElement (By locator) {
		return driver.findElement(locator);
	}
}