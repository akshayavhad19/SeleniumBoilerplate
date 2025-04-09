package SeleniumSessions;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class CopyPasteActionClass {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();  
		driver.get("https://www.google.com/account/about/");    
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("/html/body/header/div[1]/div[5]/ul/li[1]/a"));
		element.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement firstName = driver.findElement(By.name("firstName"));
		WebElement userName = driver.findElement(By.name("username"));    
		firstName.sendKeys("shalini");  
		Actions action = new Actions(driver);
		action.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
		action.keyDown( Keys.CONTROL ).sendKeys( "c" ).keyUp( Keys.CONTROL ).build().perform();
		userName.click();
		action.keyDown( Keys.CONTROL ).sendKeys( "v" ).keyUp( Keys.CONTROL ).build().perform();
	}
}
