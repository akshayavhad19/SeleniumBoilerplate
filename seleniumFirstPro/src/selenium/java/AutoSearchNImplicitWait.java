package selenium.java;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSearchNImplicitWait {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Selenium");

		//WebElement options = driver.findElement(By.xpath("//ul[@role='listbox'][@class='G43f7e']"));
		List<WebElement> allSearch = driver.findElements(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul/li"));

		System.out.println("Total number of links/options= "+allSearch.size());		

		for (int i=0;i<allSearch.size();i++) {
			String allSuggestionList = allSearch.get(i).getText();
			String finalResult = "selenium dev";
			if(allSuggestionList.equalsIgnoreCase(finalResult)) {
				allSearch.get(i).click();
				System.out.println(allSearch.get(i).getText());
				break;
			}


		}


		//*[@id="APjFqb"]
		//*[@id="Alh6id"]/div[1]
	}

}
