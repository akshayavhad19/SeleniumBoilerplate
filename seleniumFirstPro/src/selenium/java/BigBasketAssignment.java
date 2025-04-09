package selenium.java;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BigBasketAssignment {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException  { 
		
		 driver = new ChromeDriver();
		 
		 driver.get("https://www.bigbasket.com/");
		 Thread.sleep(2000);
		 
	     By parentLocator = By.xpath("(//span[text() = 'Shop by' ])[2]");
	     Thread.sleep(2000);
	     getElement(parentLocator).click();     
	     
	     //driver.manage().window().maximize();
	     
	     
	     List <WebElement> menuOptions =  driver.findElements(By.xpath("(//ul[contains(@class, 'jsx')])[1]/li/a"));
	     
	  //   xpath used :
	    //1. (//ul[contains(@class, 'jsx')])[1]/li/a     
	   //2. (//ul[@class])[1]/li/a	     
	  //3.   //((//ul[contains(@class, 'jsx')])[1]/li)[1]/a
	     
	     
//	     System.out.println(menuOptions.size());
// 	     
//	        for(WebElement e: menuOptions)
//	        {
//	        	System.out.println("Inside the loop");
////	        	Actions act = new Actions(driver);
////	        	act.moveToElement(e).pause(500).perform();
//	        		
//	        	String text = e.getText();
//	          	System.out.println(text);
//	          	
//	}
//	          	
	   System.out.println(menuOptions.size());
	   String startXpath = "((//ul[contains(@class, 'jsx')])[1]/li)[";
	   String lastXpath ="]/a";
	   
	   for(int i=1; i<=menuOptions.size();i++)
	   {
		  String actualXpath = ""+startXpath+i+lastXpath+"";
		  System.out.println(actualXpath);
		  WebElement option= driver.findElement(By.xpath(actualXpath));
          System.out.println(option.getText());
	        	     	
	   }
	     
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}

}
