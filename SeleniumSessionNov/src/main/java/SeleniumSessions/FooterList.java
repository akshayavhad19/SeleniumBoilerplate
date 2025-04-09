package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterList {
    static WebDriver driver;
    public static void main(String[] args) {
            
           // WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.get("https://www.freshworks.com/");
            driver.manage().window().maximize();
            
            By footer1 = By.xpath("//div[@class='sc-ace17a57-0 hFnGrz']//a");
            By footer2 = By.xpath("//div[@class='footer-nav copyrights-nav hide-in-mobile']//a");
            getFooterList(footer1);
    
    }
    public static List<WebElement> getElements(By locator){                //getElements()
            
            return driver.findElements(locator);
    }
    
    public static void getFooterList(By locator) {
            
            List<WebElement> footerList=getElements(locator);
            for(WebElement e : footerList) {
                    
                    String txt=e.getText();
                    System.out.println(txt);
            }
            System.out.println(footerList.size());
    }
}
