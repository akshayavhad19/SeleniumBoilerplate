package testGPP;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomeGPP {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.manage().deleteAllCookies();
		driver.get("https://www.gpphiroba.jp/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void pageTitleTest() {
		String pageTitle =driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertEquals(pageTitle, "みんなで知ろう、膿疱性乾癬(GPP)のこと。|GPPひろば");
	}
	@AfterTest
	public void close() {
		driver.close();
	}
}
