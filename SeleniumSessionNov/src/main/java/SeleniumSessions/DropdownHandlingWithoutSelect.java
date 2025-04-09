package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownHandlingWithoutSelect {
	static WebDriver driver;
	public static void main(String[] args) {

		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		By country= By.cssSelector("select#Form_getForm_Country>option");

		//List<WebElement> OptionsList= driver.findElements(country);
		//for(WebElement e: OptionsList) {
		//System.out.println(e.getText());
		//	}
		selectDropdownValue(country, "French Southern Territories");
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public static void selectDropdownValue(By locator, String value) {
		List<WebElement> OptionsList= getElements(locator);
		for(WebElement e: OptionsList) {
			String text=e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
}
