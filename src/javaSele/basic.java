package javaSele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic {

	public static void main(String[] args) {
     System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.saucedemo.com/");
     driver.findElement(By.xpath("//input[@class='input_error form_input']")).sendKeys("standard_user");
     driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
     driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
