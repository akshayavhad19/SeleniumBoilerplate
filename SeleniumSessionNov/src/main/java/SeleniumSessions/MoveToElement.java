package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElement {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		// Actions class:
		// users actions : mouse and keyboard
		driver=new ChromeDriver();
		
		String username="develop";
		String password="bi!marketing";
		String loginUrl = "https://"+username+":"+password+"@nginx-gpphiroba-jp-develop.bi3.bi-oneweb.com";
		driver.get(loginUrl);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		By 	menu= By.cssSelector("span.label");
		By childMenu=By.xpath("//*[@id=\"dropDownMenu-1741865266-1826468210\"]/div/div/ul/li[4]/a");
//		Actions act= new Actions(driver);
//		act.moveToElement(driver.findElement(menu)).build().perform();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"dropDownMenu-1741865266-1826468210\"]/div/div/ul/li[4]/a")).click();
		
		//act.a1.build.perform --> valid
		//act.a1.build     --> invalid will not do anything
		//act.a1.perform  --> valid will act as build+perform both
		//act.a1   ---> invalid
		
		parentToChildMenu(menu, childMenu);
	}
	public static WebElement getElement (By locator) {
		return driver.findElement(locator);
	}
	public static void parentToChildMenu(By parentMenuLocator, By childMenuLocator) throws InterruptedException {
		Actions act= new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).build().perform();
		Thread.sleep(2000);
		driver.findElement(childMenuLocator).click();
	}
}