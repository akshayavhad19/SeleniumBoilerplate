package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	//SRP - single responsibility principle
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	public By getBy(String locatorType, String locatorValue) {
		By by=null;
		switch (locatorType.toLowerCase().trim()) {
		case "id": {
			by=By.id(locatorValue);
			break;
		}
		case "name": {
			by=By.name(locatorValue);
			break;
		}
		case "class": {
			by=By.className(locatorValue);
			break;
		}
		case "xpath": {
			by=By.xpath(locatorValue);
			break;
		}
		case "css": {
			by=By.cssSelector(locatorValue);
			break;
		}
		case "linktext": {
			by=By.linkText(locatorValue);
			break;
		}
		case "partiallinktext": {
			by=By.partialLinkText(locatorValue);
			break;
		}
		case "tag": {
			by=By.tagName(locatorValue);
			break;
		}
		default:
			System.out.println("Wrong Locator type passed= "+locatorType);
			throw new AutomationException("Wrong locator type");
		}
		return by;
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	public String doElementGetText(String locatorType, String locatorValue) {
		return getElement(getBy(locatorType, locatorValue)).getText();
	}
	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public WebElement getElement (By locator) {
		return driver.findElement(locator);
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}
	public void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();
	}
	public String doGetDomAttribute(By locator, String attributeName) {
		return getElement(locator).getDomAttribute(attributeName);	
	}
	public String doGetDomProprty(By locator, String attributeName) {
		return getElement(locator).getDomProperty(attributeName);	
	}

	//WAF: capture text of all the page links and return String list.
	public List<String> getElementTextList(By locator) {
		List<WebElement> eleList=getElements(locator);
		List<String> eleTextList= new ArrayList<String>();
		for (WebElement e: eleList) {
			String text=e.getText();
			if(text.length()!=0) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
	//Write a function (WAF): capture specific attribute from the list:
	public List<String> getElementsAttribute(By locator, String attrName) {
		List<WebElement> eleList=getElements(locator);
		List<String> eleAttrList= new ArrayList<String>();

		for (WebElement e : eleList) {
			String attrValue= e.getDomAttribute(attrName);
			eleAttrList.add(attrValue);
		}
		return eleAttrList;
	}
	public int getElementsCount (By locator) {
		return getElements(locator).size();
	}
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void Search(By searchField, By suggestions, String searchKey, String suggName) throws InterruptedException {
		driver.findElement(searchField).sendKeys(searchKey);
		Thread.sleep(3000);
		List<WebElement> suggList= driver.findElements(suggestions);
		System.out.println(suggList.size());

		for (WebElement e: suggList) {
			String text=e.getText();
			if(text.contains(suggName)) {
				e.click();
			}
		}

	}
	//*****************************Select dropdownUtil********************//

	private Select createSelect(By locator) {
		Select select=new Select(getElement(locator));
		return select;

	}
	public void doSelectDropdownByIndex(By locator, int index) {
		createSelect(locator).selectByIndex(index);
	}
	public void doSelectDropdownByVisibleText(By locator, String visibleText) {
		createSelect(locator).selectByVisibleText(visibleText);;
	}
	public void doSelectDropdownByValue(By locator, String value) {
		createSelect(locator).selectByValue(value);;
	}
	public int getDropdownOptionsCount(By locator) {
		return createSelect(locator).getOptions().size();
	}
	public List<String> getDropdownOptions(By locator) {
		List<WebElement> optionsList= createSelect(locator).getOptions();
		List<String> optionsTextList=new ArrayList<String>(); 
		for (WebElement e: optionsList) {
			String text= e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	public void selectDropdownOptions(By locator, String dropdownValue) {
		List<WebElement> countryList= createSelect(locator).getOptions();
		for (WebElement e: countryList) {
			String text= e.getText();
			if(text.equals(dropdownValue)) {
				e.click();
				break;
			}
		}
	}
	public void selectDropdownValue(By locator, String value) {
		List<WebElement> OptionsList= getElements(locator);
		for(WebElement e: OptionsList) {
			String text=e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	public boolean isDropdownMultiple(By locator) {
		return createSelect(locator).isMultiple() ? true : false; 
	}		
	/**
	 * This method is used to select the values from the dropdown. It can select;
	 * 1. single selection
	 * 2. Multiple selection (Add any number values)
	 * 3. All selection : Please pass "all" as a value to select all
	 * @param locator
	 * @param values
	 */
	public void selectMultipleDropdownValues (By locator, By optionLocator, String... values) {
		if (isDropdownMultiple(locator)) {
			if(values[0].equalsIgnoreCase("all")) {
				List <WebElement> optionsList= getElements(optionLocator);
				for (WebElement e: optionsList) {
					e.click();
				}
			}
			else {
				for ( String value : values) {
					createSelect(locator).selectByVisibleText(value);
				}	
			}

		}
	}
	//********************Actions Util*******************//
	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	public void fourLevelMenuHandle(By parentMenuLocator, By firstChildMenuLocaor, By secondChildMenuLocaor,
			By thirdChildMenuLocaor) throws InterruptedException {
		Actions act = new Actions(driver);
		doClick(parentMenuLocator);
		Thread.sleep(1000);
		act.moveToElement(getElement(firstChildMenuLocaor)).build().perform();
		Thread.sleep(1000);
		act.moveToElement(getElement(secondChildMenuLocaor)).build().perform();
		Thread.sleep(1000);
		doClick(thirdChildMenuLocaor);
	}
	public void twoLevelMenuHandle(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		Actions act= new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(2000);
		doClick(childMenuLocator);
	}
	public void doActionsSendKeysWithPause(By locator, String value) {
		Actions act = new Actions(driver);
		char val[] = value.toCharArray();
		for (char c : val) {
			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();
		}
	}

}
