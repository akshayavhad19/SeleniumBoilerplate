package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebdriverBasics {
    static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 driver=new ChromeDriver ();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		//driver.findElement();
		// By locator creation
		By email= By.id("email");
		  getElement (email).sendKeys("ag@gmail.com");
		
		// create generic function / method to find webelements
	
		
		System.out.println(driver.getCurrentUrl());
	}

	public static WebElement getElement(By locator) {
	
		return driver.findElement(locator);
	}
  Actions a =new Actions(driver);
}
