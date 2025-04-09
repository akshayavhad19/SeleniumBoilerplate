package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");// Parent
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();//child-new window
		
		//1. fetch the window id
		Set<String> handles=driver.getWindowHandles(); //Set-unordererd and cant save duplicates
		
		Iterator<String> it=handles.iterator(); // used for unordered ds
		
		String parentWindow=it.next();
		System.out.println(parentWindow);
		
		String childWindow=it.next();
		System.out.println(childWindow);

		//2. Switching bet the windows
		driver.switchTo().window(childWindow);
		System.out.println("Child window URL: "+driver.getCurrentUrl());
		driver.close(); // closing current window i.e. child
		
			//back to parent window
		driver.switchTo().window(parentWindow);
		System.out.println("Parent window URL: "+driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.quit(); //close parent window
		
		
		
	}
}

