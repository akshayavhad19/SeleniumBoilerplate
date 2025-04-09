package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class JqueryDropdownHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectmenu/");
		
		driver.switchTo().frame(0);
		
		Thread.sleep(3000);
		By openDropdown= By.cssSelector("span#speed-button");
		By dropdown= By.cssSelector("ul#speed-menu div");
		driver.findElement(openDropdown).click();
		Thread.sleep(2000);

		List<WebElement> optionList = driver.findElements(dropdown);
		System.out.println(optionList.size());
		
		for (WebElement e: optionList) {
			String text=e.getText();
			System.out.println(text);
			if ( text.equals("Fast")) {
				e.click();
				break;
			}
		}
	}
}
