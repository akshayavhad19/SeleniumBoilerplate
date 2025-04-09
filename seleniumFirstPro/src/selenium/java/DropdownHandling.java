package selenium.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();
		Thread.sleep(3000);
		WebElement birthday = driver.findElement(By.xpath("//select[@id='day']")); 
		Select day = new Select(birthday); 
		List <WebElement> dropdown = day.getOptions();
		System.out.println("size of month options= "+dropdown.size());

		for (int i=0; i<dropdown.size();i++) {
			String selectDate= "15";
			if(dropdown.get(i).getText().equals(selectDate)) {
				dropdown.get(i).click();
				System.out.println(dropdown.get(i).getText());
			}
		}



	}

}
