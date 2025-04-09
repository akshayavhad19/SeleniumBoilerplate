package javaSele; 
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicMethods 
{ 
// To execute any program we need main main() method. So we will continue from the main method. 
 public static void main(String[] args) 
 { 
     System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

// Create a driver object using WebDriver reference. 
   WebDriver driver = new ChromeDriver(); // FirefoxDriver class with no parameters. So, Default Firefox will be launche by Java program. Default Firefox profile is similar to launching the firefox in save mode. 

// Declaration of variable URL with data type String and store the URL of the webpage. 
   String URL = "https://www.google.co.in"; 

// Now call the get() method to open the URL of the web page in the existing browser. 
   driver.get(URL); // It takes String URL as a parameter and returns nothing. 

// Wait For Page To Load.
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

// Print a message to display on the console that the website is opened successfully. 
   System.out.println("Website is opened successfully"); 

// Call getTitle() method using reference variable to get the title of the web page. 
   String getTitle = driver.getTitle(); 

// Now print title of web page on the console. 
   System.out.println("Title of home page: " +getTitle); 

// Now call the close() method using reference variable 'driver' to close the browser. 
   String getPageSource = driver.getPageSource(); 
System.out.println(getPageSource); 
 } 
}