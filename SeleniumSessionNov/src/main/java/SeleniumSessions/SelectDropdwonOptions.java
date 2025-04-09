package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdwonOptions {
	static WebDriver driver;
	public static void main(String[] args) {

		// drowpdown --> htmltag: <select> --> <option> (child tag)
		// use Select class

		driver=new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		By country= By.id("Form_getForm_Country");
		//WebElement country_ele= driver.findElement(country);

		System.out.println(getDropdownOptionsCount(country));
		getDropdownOptions(country);
		selectDropdownOptions(country, "Tuvalu");

	}
	public static WebElement getElement (By locator) {
		return driver.findElement(locator);
	}
	public static int getDropdownOptionsCount(By locator) {
		Select select =new Select(getElement(locator));
		return select.getOptions().size();
	}
	public static void getDropdownOptions(By loctor) {
		Select select =new Select(getElement(loctor));
		List<WebElement> countryList= select.getOptions();
		for (WebElement e: countryList) {
			String text= e.getText();
			System.out.println(text);
		}
	}
	public static void selectDropdownOptions(By loctor, String dropdownValue) {
		Select select =new Select(getElement(loctor));
		List<WebElement> countryList= select.getOptions();
		for (WebElement e: countryList) {
			String text= e.getText();
			if(text.equals(dropdownValue)) {
				e.click();
				break;
			}
		}
	}
}