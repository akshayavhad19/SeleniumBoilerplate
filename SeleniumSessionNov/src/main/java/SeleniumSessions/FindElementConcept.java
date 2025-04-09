package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//driver.findElement(By.id("input-email111")).sendKeys("test@email.com");
		//NoSuchElementException: no such element: Unable to locate element
		
		//driver.findElement(By.id("input-email")).sendKeys(null);
		//IllegalArgumentException: Keys to send should be a not null CharSequence
		
		//sendkeys work with String, StringBuilder, stringBuffer
		// beacuse SendKeys accepts charSequence (I) which Interface having child classes String, StringBuilder, stringBuffer
		StringBuilder sb = new StringBuilder("test@gmail.com");
		driver.findElement(By.id("input-email")).sendKeys(sb+" Automation");
		
		
		
		

	}

}
