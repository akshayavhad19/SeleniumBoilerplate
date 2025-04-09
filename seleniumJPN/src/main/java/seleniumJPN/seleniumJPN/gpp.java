package seleniumJPN.seleniumJPN;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

 
public class gpp 
{
    public static void main( String[] args ) throws InterruptedException
    {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.gpphiroba.jp/");
		driver.manage().window().maximize();
		Actions act= new Actions(driver);
		WebElement web= driver.findElement(By.xpath("(//a[@class='main-link'])[2]"));
		act.moveToElement(web).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class=\"gds-link gds-link--link-intercept\"])[1]")).click();
		String currentURL=driver.getCurrentUrl();
		Assert.assertEquals("https://www.gpphiroba.jp/before-hospital/index.htm", currentURL );
		System.out.print(true);
    }
}
