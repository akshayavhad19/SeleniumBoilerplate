package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownHandling {
	static WebDriver driver;
	public static void main(String[] args) {
		
		// drowpdown --> htmltag: <select> --> <option> (child tag)
		// use Select class
		 driver=new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		By country= By.id("Form_getForm_Country");
		WebElement country_ele= driver.findElement(country);
		Select select= new Select(country_ele);
		//select.selectByIndex(5);  Preferred where no's are fixed ex. no of months, days
		//select.selectByValue("India");
		// select.selectByVisibleText("India"); most preferred when word are there 
		doSelectDropdownByIndex(country, 400);
	}
	public static WebElement getWebelemnt(By locator) {
		return driver.findElement(locator);
	}
	public static void doSelectDropdownByIndex(By locator, int index) {
		Select select =new Select(getWebelemnt(locator));
		select.selectByIndex(index);
	}
	public static void doSelectDropdownByVisibleText(By locator, String visibleText) {
		Select select =new Select(getWebelemnt(locator));
		select.selectByVisibleText(visibleText);;
	}
	public static void doSelectDropdownByValue(By locator, String value) {
		Select select =new Select(getWebelemnt(locator));
		select.selectByValue(value);;
	}
}
