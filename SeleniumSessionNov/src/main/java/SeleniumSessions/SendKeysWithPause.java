package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  { 

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(2000);

		By emailAdd= By.cssSelector("input#input-email");
		By passward= By.cssSelector("input#input-password");
		WebElement eId= driver.findElement(emailAdd);
		Actions act =new Actions(driver);

		String value="abc@gmail.com";
		char val[]=value.toCharArray();

		for (char c: val) {
			act.sendKeys(eId, String.valueOf(c)).pause(1000).build().perform();
		}
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSendKeysWithPause(By locator, String value) {
		Actions act =new Actions(driver);
		char val[]=value.toCharArray();
		for (char c: val) {
			act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();
		}
	}
}
