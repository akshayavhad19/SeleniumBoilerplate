package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertJSPopupHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		//alert: JS popups
		//1. Alert
		//2.Promt ( usually to fill some response and close)
		//3. confrim -yes or no

		// All handled by Alert Api

		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(2000);
		//		
		//		//1. Alert
		//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		//		//button[text()='Click for JS Alert']
		//		
		//		Alert alert=driver.switchTo().alert();
		//		System.out.println(alert.getText());
		//		alert.accept();

		//After accepting and then trying to dismiss or accept
		//alert.dismiss();
		//NoAlertPresentException:  no such alert

		//2. confirm
		//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		//		Alert alert=driver.switchTo().alert();
		//		System.out.println(alert.getText());
		//		alert.dismiss();
		
		//3. Promt
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("automation");
		Thread.sleep(2000);
		alert.accept();
		

	}
}
