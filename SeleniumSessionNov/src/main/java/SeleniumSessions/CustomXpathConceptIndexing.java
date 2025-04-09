package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpathConceptIndexing {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//index:
		
			//(//input[@class='form-control'])[1]
			
			//(//input[@class='form-control'])[last()]
			//(//input[@class='form-control'])[last()-1]
			////(//input[@class='form-control'])[last()-2]
			
			//(//input[@class='form-control'])[position()=1]
		
		// Parent to child
			// direct child :- /
			// indirect child :- //
		
		// child to parent
			//tagName[@attrubuteName='AttValue']/..
			//(//input[@class='form-control'])/parent::div
			//(//input[@class='form-control'])/parent::div/parent::div/label[@for='input-firstname']
			//input[@class='form-control']/ancestor::div[@class='form-group required']/label[@for='input-firstname']
			//(//input[@class='form-control'])/ancestor::div -- reach to grandparent
		
		//preceding-sibling
			//input[@name='firstname']/parent::div/preceding-sibling::label
		
		//even odd in xpath:
				//(//select[@id='Form_getForm_Country']/option)[position() mod 2=0] --> even
				//(//select[@id='Form_getForm_Country']/option)[position() mod 2=1] --> odd
		
	}
}
