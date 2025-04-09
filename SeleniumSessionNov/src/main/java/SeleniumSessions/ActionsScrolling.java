package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  { 

		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);

		Actions act = new Actions(driver);

		//for slight upNdown
		//		act.sendKeys(Keys.PAGE_DOWN)
		//				.pause(500)
		//					.sendKeys(Keys.PAGE_UP).build().perform();

		//Whole page down and up
		//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		//		Thread.sleep(3000);
		//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();

		//ScrolltoElement and click
		//		act.scrollToElement(driver.findElement(By.linkText("Help")))
		//			.click(driver.findElement(By.linkText("Help")))
		//				.build().perform();
		
		//Refresh page
		//driver.navigate().refresh();
		//cntol +R
		act.keyDown(Keys.COMMAND).sendKeys(Keys.F5).keyUp(Keys.COMMAND).build().perform();



	}
}
