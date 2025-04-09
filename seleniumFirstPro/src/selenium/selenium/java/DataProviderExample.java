package selenium.selenium.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderExample {
	WebDriver driver;
  @BeforeClass
	public void setEnv() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.facebook.com/");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
  @DataProvider
  public String [][] dataSet(){
	  String arr [][]=new String [2][2];
	  arr [0][0]="EmaiId_1";
	  arr [0][1]="Password1";
	  arr [1][0]="EmailId_2";
	  arr [1][1]="Password2";
	  return arr;
			 
  }
  @Test(dataProvider="dataSet")
  public void enterCred(String uName, String pass) throws InterruptedException {
	  
	  driver.findElement(By.id("email")).clear();
	  driver.findElement(By.id("pass")).clear();
	  driver.findElement(By.id("email")).sendKeys(uName);
	  driver.findElement(By.id("pass")).sendKeys(pass);
	  driver.findElement(By.xpath("//button[@name='login']")).click();
	  Thread.sleep(3000);
	  driver.navigate().back();
	  
  }
}
