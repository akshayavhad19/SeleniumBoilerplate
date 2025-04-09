package selenium.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.tracing.Propagator;

public class objectRepoUse {

	public static void main(String[] args) throws IOException {
		//specify the file loaction
        File src= new File("C:\\Users\\2155644\\eclipse-workspace\\SeleniumAutomation\\seleniumFirstPro\\Repository\\ObjRepository.properties");
        
        //Use FileInputStream class to load file
        FileInputStream fis = new FileInputStream(src);
        
        //Read the objects file data using Properties
        Properties pro = new Properties();
        pro.load(fis);
        
    	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pro.getProperty("URL"));
        driver.findElement(By.id("email")).sendKeys("HEllo ZucK");
        System.out.println("Browser Opned");
        		
	}

}
