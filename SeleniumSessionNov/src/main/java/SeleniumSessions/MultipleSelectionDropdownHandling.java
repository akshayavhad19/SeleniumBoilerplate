package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectionDropdownHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");

		By dropdownLocator=By.xpath("//select[@multiple]");
		By optionLocator= By.xpath("//select/option");
		
		//		WebElement mutiOptions= driver.findElement(dropdownLocator);
		//		Select select = new Select(mutiOptions);
		//		//Select select =new Select(driver.findElement(By.xpath("//select[@multiple]")));
		//
		//		//check if its mutiple dropdown
		//		if (select.isMultiple()) {
		//			System.out.println("yes its multiselect dropdown");
		//			select.selectByIndex(0);
		//			select.selectByVisibleText("Chilean flamingo");
		//			select.selectByVisibleText("Lesser flamingo");
		//		}
		//		Thread.sleep(3000);
		//		select.deselectByIndex(5);

		//TC-1 Multiple values
		selectMultipleDropdownValues(dropdownLocator,optionLocator, "Chilean flamingo","Lesser flamingo","American flamingo");

		//Tc-2 single value
		//selectMultipleDropdownValues(dropdownLocator, optionLocator, "American flamingo");

		//TC-3 ALL values
		//selectMultipleDropdownValues(dropdownLocator, optionLocator, "all");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static boolean isDropdownMultiple(By locator) {
		Select select = new Select(getElement(locator));
		return select.isMultiple() ? true : false; 
	}
	// spread operator ...
	
	
	/**
	 * This method is used to select the values from the dropdown. It can select;
	 * 1. single selection
	 * 2. Multiple selection (Add any number values)
	 * 3. All selection : Please pass "all" as a value to select all
	 * @param locator
	 * @param values
	 */
	public static void selectMultipleDropdownValues (By locator, By optionLocator, String... values) {
		Select select =new Select(getElement(locator));
		if (isDropdownMultiple(locator)) {
			if(values[0].equalsIgnoreCase("all")) {
				List <WebElement> optionsList= driver.findElements(optionLocator);
				for (WebElement e: optionsList) {
					e.click();
				}
			}
			else {
				for ( String value : values) {
					select.selectByVisibleText(value);
				}	
			}

		}
	}

}
