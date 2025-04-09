package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterLinks {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		By footerXpath= By.xpath("//footer//a");
		
		ElementUtil eleUtil= new ElementUtil(driver);
		int count=eleUtil.getElementsCount(footerXpath);
		System.out.println(count);
		List<String> actualFooterLinks= eleUtil.getElementTextList(footerXpath);
		
		for(String e: actualFooterLinks) {
			//String text=
		}
		//List<WebElement> footerLinks= driver.findElements(footerXpath);
		//System.out.println(footerLinks.size());
	}
}
