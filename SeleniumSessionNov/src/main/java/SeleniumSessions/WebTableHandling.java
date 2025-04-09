package SeleniumSessions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.checkerframework.common.value.qual.ArrayLen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		Thread.sleep(6000);
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_21\"]")).click();
		
		//a[text()='Joe.Root']/parent::td/preceding-sibling::td/input[@type='checkbox']
		
		//a[text()='John.Smith']/parent::td/preceding-sibling::td/input[@type='checkbox']
		
		//here only name is changing
		
		
		//selectUser("Joe.Root");
		
		List<String> userDetails=userInfo("Joe.Root");
		System.out.println(userDetails);
	}
	public static void selectUser(String userName) {
		driver.findElement(By.xpath("//a[text()='"+userName+"']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
		.click();
	}
	public static List<String> userInfo(String userName) {
		List<WebElement> colInfo=driver.findElements(By.xpath("//a[text()='"+userName+"']/parent::td/following-sibling::td"));
		List<String> colInfoList=new ArrayList<String>();
		for (WebElement e: colInfo) {
			String text= e.getText();
			colInfoList.add(text);
		}
		return colInfoList;
	}
}
