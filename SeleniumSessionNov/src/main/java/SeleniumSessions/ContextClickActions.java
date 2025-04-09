package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClickActions {
	

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  { 
		
		 driver = new ChromeDriver();
		 driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		 Thread.sleep(2000);
		 
		 WebElement rightClick= driver.findElement(By.cssSelector("span.context-menu-one"));
		 Actions act = new Actions(driver);
		 
		 act.contextClick(rightClick).perform();
		 
	}
	
	
}
