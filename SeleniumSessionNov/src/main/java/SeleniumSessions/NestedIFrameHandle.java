package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIFrameHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://selectorshub.com/iframe-scenario/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//f1
		driver.switchTo().frame("pact1");
		driver.findElement(By.id("inp_val")).sendKeys("First");
		
		Thread.sleep(2000);
		//f2
		driver.switchTo().frame("pact2");
		driver.findElement(By.id("jex")).sendKeys("Second");
		
		Thread.sleep(2000);
		//f3
		driver.switchTo().frame("pact3");
		driver.findElement(By.id("glaf")).sendKeys("Destiny");
		Thread.sleep(2000);

		//f3--->f1 : not allowed
		//driver.switchTo().frame("pact1"); -->NoSuchFrameException: No frame element found by name or id pact1 
		
		//f3-->f2-->f1 : Not allowed
		//driver.switchTo().frame("pact2");
		//driver.switchTo().frame("pact1");
		
		driver.switchTo().parentFrame();//f3-->f2
		driver.findElement(By.id("jex")).sendKeys(" second crush 2");
		
		driver.switchTo().parentFrame();//f2-->f1
		driver.findElement(By.id("inp_val")).sendKeys(" crush");
		
		Thread.sleep(2000);
		// now we are f1, we can againg use parentFrame to switch on main page
		//driver.switchTo().parentFrame(); only frame to frame switch 
		driver.switchTo().defaultContent(); //lands to main page from any frame
		String getHeading= driver.findElement(By.tagName("h3")).getText();
		System.out.println(getHeading);
		
		

		

	}
}