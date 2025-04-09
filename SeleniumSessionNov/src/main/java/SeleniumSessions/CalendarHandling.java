package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarHandling {

	public static void main(String[] args) 
	{
		// Set the driver path
		//System.setProperty("webdriver.firefox.marionette","G:\\Selenium\\Firefox driver\\geckodriver.exe");
		
                // start firefox
		WebDriver driver=new ChromeDriver();

                // start application
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
                // click on date picker so that we can get the calendar in view 
		driver.findElement(By.id("datepicker")).click();
			
                // this will find all matching nodes in calendar		
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		//Directly picking the date using x path
		driver.findElement(By.xpath("//a[text()='28']")).click();
                // now we will iterate all values and will capture the text. We will select when date is 28
				/*
				 * for(WebElement ele:allDates) {
				 * 
				 * String date=ele.getText();
				 * 
				 * // once date is 28 then click and break if(date.equalsIgnoreCase("28")) {
				 * ele.click(); break; }
				 * 
				 * }
				 */
		
		
	}

}