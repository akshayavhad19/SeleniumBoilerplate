package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcepts {

	//findElmenet: find single element + then perform action
	//findElemets: find the multiple elements and store in the list + No action

	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		//List<WebElement> textFiledList= driver.findElements(By.className("form-control"));
		//System.out.println(textFiledList.size());

		driver.get("https://www.amazon.in/");

		List<WebElement> totalLinks= driver.findElements(By.tagName("a"));
		System.out.println(totalLinks.size());

		//for(int i=0; i<totalLinks.size();i++) {
		//	String text=totalLinks.get(i).getText();
		//	if (text.length()!=0) {
		//		System.out.println(i+" "+text);
		//	}
		for( WebElement e : totalLinks) {
			String text=e.getText();
			if (text.length()!=0) {
				System.out.println(text);
			}

			//for(int i=0; i<totalLinks.size();i++) {
			//	String text=totalLinks.get(i).getText();
			//	if (text.length()!=0) {
			//		System.out.println(i+" "+text);
			//	}
		}
		List<WebElement> totalImages= driver.findElements(By.tagName("Img"));
		System.out.println(totalImages.size());

		driver.findElements(By.tagName("a"));
     
	}
	public static int getListCount (By locator) {
		return getElements(locator).size();
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
}
