package SeleniumSessions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
/**
 * 
 * @author 2155644 Akshay
 * BrowserUtil is having mutiple generic methods to handle various browser actions
 */
public class BrowserUtils {
	private WebDriver driver;

	/**
	 * 
	 * @param browserName
	 * @return this returns browser instance
	 */
	public WebDriver launchBrowser ( String browserName) {
		System.out.println("Browser Name: "+browserName);
		switch (browserName.toLowerCase().trim()){
		case "chrome": {
			driver = new ChromeDriver();
			break;
		}
		case "edge": {
			driver = new EdgeDriver();
			break;
		}
		case "firefox": {
			driver = new FirefoxDriver();
			break;
		}
		case "safari": {
			driver = new SafariDriver();
			break;
		}
		default:
			System.out.println("Please pass the right browser");
			throw new AutomationException("Invalid Browser "+browserName);
		}
		driver.manage().window().maximize();
		return driver;
	}

	public void launchURL(String url) {
		if(url==null) {
			System.out.println("url is Null");
			throw new AutomationException("URL is null");
		}
		if (url.indexOf("http")==0) {
			driver.get(url);
			System.out.println();
		} else {
			throw new AutomationException("Invalid URL- http is missing");
		}
	}
	public void luanchURL(URL url) {
		if(url==null) {
			System.out.println("url is Null");
			throw new AutomationException("URL is null");
		}
		driver.navigate().to(url);

	}
	public String getPageTitle() {
		String pageTitle= driver.getTitle();
		System.out.println("PageTitle: "+pageTitle);
		return pageTitle;
	}
	public String getPageUrl() {
		String pageUrl= driver.getCurrentUrl();
		System.out.println("Page URL: "+pageUrl);
		return pageUrl;
	}
	public boolean getPageSource(String value) {
		String pageSource= driver.getPageSource();
		if(pageSource.contains(value)) {
			return true;
		}
		return false;
	}
	public void closeBrowser() {
		driver.close();
	}
	public void quiteBrowser() {
		driver.quit();
	}

}
