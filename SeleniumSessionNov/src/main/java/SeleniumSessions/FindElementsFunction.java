package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsFunction {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");

		By links=By.tagName("a");
		By images=By.tagName("Img");

		List<String> actTotalLinkText=getElementTextList(links);
		System.out.println(actTotalLinkText);
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		if (actTotalLinkText.contains("Fresh")) {
			System.out.println("True");
		}

		//List<WebElement> totalLinks=getElements(links);
		//System.out.println(getElementsCount(links));
	}
	//WAF: capture text of all the page links and return String list.
	public static List<String> getElementTextList(By locator) {
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

	public static int getElementsCount (By locator) {
		return getElements(locator).size();
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}