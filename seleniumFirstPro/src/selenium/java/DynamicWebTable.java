package selenium.java;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicitywait use only once in project

		driver.get("https://money.rediff.com/gainers");
		
		WebElement td = driver.findElement(By.xpath("//table[@class='dataTable']/thead/tr[1]/th[2]"));
		System.out.println("Heading capture: "+td.getText());
		
		List<WebElement> allCompanies = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]/a"));
		System.out.println("Total number of comapnies: "+allCompanies.size());
	
		
		List<WebElement> currentPrice = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		System.out.println("Total rows for current price: "+currentPrice.size());
		
		String expectedCompany = "NGL Fine-Chem Li";
		for (int i = 0; i<allCompanies.size();i++) {
			if(allCompanies.get(i).getText().equalsIgnoreCase(expectedCompany)) {
		
				System.out.println("Expected Company Position= "+i+ " Expected Comapny: "+allCompanies.get(i).getText()+" Current Price: "+currentPrice.get(i).getText());
				allCompanies.get(i).click();
				break;
			}
		}
	}

}

