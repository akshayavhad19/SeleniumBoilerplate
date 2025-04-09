package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowsHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");// Parent
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//get the parentId
		String parentWindowId=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
		
		Set<String> handles=driver.getWindowHandles(); // capture all windows including parent
		
		Iterator<String> it= handles.iterator();
		
		//check for the next id - if available returns true
		while(it.hasNext()){
			String windowId=it.next();
			driver.switchTo().window(windowId);
			System.out.println("Get window URL: "+driver.getCurrentUrl());
			Thread.sleep(2000);
			//it will close all the windows including parent so
				if (!windowId.equals(parentWindowId)) {
					driver.close();
				}
			
		}
		//if not switchech to parent - NoSuchWindowException: no such window: target window already closed
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window URL: "+driver.getCurrentUrl());
		driver.quit();
		
		//selenium 4.X feature]
		// //opens new window we can can work on that winodw and the close it and switch to parent window
		//driver.switchTo().newWindow(WindowType.WINDOW);
		// //opens new tab we can can work on that winodw and the close it and switch to parent window
		//driver.switchTo().newWindow(WindowType.TAB);
	}
}
