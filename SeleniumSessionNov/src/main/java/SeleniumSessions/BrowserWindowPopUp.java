package SeleniumSessions;

import java.util.Set;

//import javax.swing.text.html.HTMLDocument.Iterator;
import java.util.Iterator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserWindowPopUp {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(15000);
		By LinkedIn=By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		By Facebook=By.xpath("//img[@alt='OrangeHRM on Facebook']");
		By twitter=By.xpath("//img[@alt='OrangeHRM on twitter']");
		By youtube=By.xpath("//img[@alt='OrangeHRM on youtube']");
		//ElementUtil eleUtil=new ElementUtil(driver);
		driver.findElement(LinkedIn).click();
		driver.findElement(Facebook).click();
		driver.findElement(twitter).click();
		driver.findElement(youtube).click();		
		Thread.sleep(3000);

		Set<String> handles=driver.getWindowHandles();
		Iterator <String> it = handles.iterator();

		//Iterator it= handles.iterator();
		//Iterator <String> it=handles.iterator();

		String parentWindowID=it.next();
		String YoutubeWindowID=it.next();
		String TwitterWindowID=it.next();
		String FacebookWindowID=it.next();
		String LinkedInWindowID=it.next();

		String LinkedInWindowTitle=getChildWindowTitle(LinkedInWindowID);
		System.out.println("LinkedInWindowTitle: "+LinkedInWindowTitle);
		driver.close();

		String FacebookWindowTitle= getChildWindowTitle (FacebookWindowID);
		System.out.println("FacebookWindowTitle: "+FacebookWindowTitle);
		driver.close();

		String TwitterWindowTitle= getChildWindowTitle(TwitterWindowID);
		System.out.println("TwitterWindowTitle: "+TwitterWindowTitle);
		driver.close();

		String YoutubeWindowTitle= getChildWindowTitle(YoutubeWindowID);
		System.out.println("YoutubeWindowTitle: "+YoutubeWindowTitle);
		driver.close();

		String parentWindowTitle= getChildWindowTitle(parentWindowID);
		System.out.println("parentWindowTitle: "+parentWindowTitle);
		driver.quit();             
	}

	public static String getChildWindowTitle(String ChildWindowID) {

		driver.switchTo().window(ChildWindowID);
		String ChildWindowTitle=driver.getTitle();

		return ChildWindowTitle;
	}
}
