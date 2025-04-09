package SeleniumSessions;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenCartTestMain {
	public static void main(String[] args) throws MalformedURLException {
		BrowserUtils brUtils= new BrowserUtils();
		brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://naveenautomationlabs.com/opencart/");
		String actPageTitle= brUtils.getPageTitle();
		if (actPageTitle.equals("Your Store")) {
			System.out.println("Title is correct - test PASS");
		}
		else {
			System.out.println("Title is not correct - test FAIL");
		}
		String actPageURL=brUtils.getPageUrl();
		if (actPageURL.contains("opencart")) {
			System.out.println("URL is correct - test PASS");
		}
		else {
			System.out.println("URL is not correct - test FAIL");
		}
		brUtils.luanchURL (new URL ("http"));
		brUtils.closeBrowser();
	}
}
