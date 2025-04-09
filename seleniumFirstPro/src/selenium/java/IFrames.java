package selenium.java;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrames {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicitywait use only once in project

		driver.get("https://paytm.com/");
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		Thread.sleep(3000);
		
		int totalIframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Iframes= "+totalIframes);
		
		for(int i=0; i<totalIframes;i++) {
			driver.switchTo().frame(i);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[@class='ng-scope']")).click();
			
			Thread.sleep(10000);
			try {
				
				driver.findElement(By.xpath("//span[@role='button']")).click();
				
			} catch (NoSuchElementException e) {
				System.out.println("bro u got wrong");
			}
			
		}
	}

}