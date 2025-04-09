package SeleniumSessions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaticTableConcept {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[3]/td[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[7]/td[1]
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		//WebDriverWait wait= new WebDriverWait (driver, Duration.ofSeconds(10));
		Wait wait= new FluentWait<>(driver).withTimeout(Duration.ofSeconds(3000)).pollingEvery(Duration.ofSeconds(20)).ignoring(ElementNotInteractableException.class);
		int rowCount= driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		
		String beforeXpath="//table[@id='customers']/tbody/tr[";
		String afterXpath="]/td[1]";
		
		for(int i=2; i<=rowCount;i++) {
			String actXpath=beforeXpath + i + afterXpath;
			String text= driver.findElement(By.xpath(actXpath)).getText();
			//System.out.println(text);
		}
		// All contents of the table
		List<WebElement> allContents=driver.findElements(By.xpath("//th[text()='Company']/parent::tr/following-sibling::tr/td"));
		for(WebElement e: allContents) {
			String text= e.getText();
			System.out.println(text);
		}
		//th[text()='Company']/parent::tr/following-sibling::tr/td[1] --- first column
		//th[text()='Company']/parent::tr/following-sibling::tr/td[2] --- second coloumn
	}
}