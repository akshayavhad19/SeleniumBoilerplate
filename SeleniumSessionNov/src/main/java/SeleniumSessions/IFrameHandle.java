package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#imageTemplateContainer>img")).click();
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		Thread.sleep(3000);
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Autmation");
		
		//to back to previous frame
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		String getText = driver.findElement(By.cssSelector("h3.details__form-preview-title")).getText();
		System.out.println(getText);
	}
}