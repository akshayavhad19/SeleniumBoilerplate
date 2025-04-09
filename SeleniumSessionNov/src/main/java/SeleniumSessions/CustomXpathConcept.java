package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpathConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	 driver= new ChromeDriver();
	 driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");		
		
	 //xpath: address of the element in the HTML dom
		//1. absolute : /html/body/div[2]/div/div/div[2]/div[2]/div/div[2]/h4/a
		//2. Relative:
		
		//a. htmltag[@attributeName='value']
		//*[@attributeName='value']
		
		//* -- gives total number of elements/tags
		
		//text() in xpath : headers, links, spans, p
		//b. tag[text()='value']
		//tag[text()='value' and @attributeName='value']
		
		//1. contains in Xpath: when to use contains? for long texts
		//tag[contains(@attName, 'value')]
		//tag[contains(@attName, 'value') and @attName='value']
		
		//contains() with text()-
		//tag[contains(text(),'value')]
		
		//contains() with text() and attribute
        //tag[contains(text(),'value') and contains(@attName,'value') ]
		
		//2. Dynamic Attributes: 
		 // Attribute value is getting changed
		  //<input id= firstname_123>
		  //<input id= firstname_124>
		  //<input id= firstname_125>
		  //<input id= firstname_126>
		 
		  //driver.findElement(By.id("firstname_123")).sendKeys("");---invalid as everytime id is changing
	 	 // driver.findElement(By.xpath("//input[contains(@id,'firstname')]")).sendKeys("HEHHE");
		
		//starts-with () in xpath:
	 	//tagname[starts-with(text(),'value')]
	    //tagname[starts-with(@attrName,'value')]
	    // ex. //p[starts-with(text(),'By creating an account')] --- https://naveenautomationlabs.com/opencart/index.php?route=account/login
		
	    //ends-with () in xpath:---deprecated
	 	//tagname[ends-with(text(),'value')]
	 
	    // for normalizing the space
	 	//tagname[normaize-space()='text']
	    
	}
}
