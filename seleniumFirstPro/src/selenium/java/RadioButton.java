package selenium.java;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RadioButton {
   
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		// click create account button
		driver.findElement(By.xpath("//a[@data-testid=\"open-registration-form-button\"]")).click();
		Thread.sleep(3000);
		
		//Way 1 - Handling of Radio Buttons 
		//click for female
		//driver.findElement(By.xpath("//input[@name='sex'][@value='1']")).click();
		//Thread.sleep(3000);
		//click for male
		//driver.findElement(By.xpath("//input[@name='sex'][@value='2']")).click();
		//Thread.sleep(3000);
		//click for custom
		//driver.findElement(By.xpath("//input[@name='sex'][@value='-1']")).click();
		
		//way 2 - by creating list for all the radio buttons, if xpath elements are same for all buttons
		
		List <WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println(radio.size());// count no of buttons
		System.out.println(radio.get(0).isDisplayed()); // true
		System.out.println(radio.get(1).isEnabled());   // true
		System.out.println(radio.get(2).isSelected());  // false
		
		// 3rd way and Correct way
		List <WebElement> radio1 = driver.findElements(By.xpath("//label[contains(@class, 'mt')]"));
		String expextedResult = "Male";
		for(int i=0; i<radio.size();i++) {
			if(radio1.get(i).getText().equalsIgnoreCase(expextedResult)) {
				radio1.get(i).click();
				System.out.println("Expected results "+expextedResult+" clicked");
				break;
			}
			
		}
		System.out.println("Execution completed");

	}

}
