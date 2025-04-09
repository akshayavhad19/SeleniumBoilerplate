package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertSession {
    public static void main(String args[]) throws InterruptedException {
      
        WebDriver driver = new ChromeDriver();
          
        // Maximize the browser
        driver.manage().window().maximize();
  
        // Launch Website
        driver.get("https://demoqa.com/alerts");
        driver.switchTo().newWindow(WindowType.WINDOW);
       
        // clicking on prompt button
        driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
        Thread.sleep(3000);
      
        // accepting javascript alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();
        
        // clicking on prompt button
        driver.findElement(By.xpath("//*[@id=\"confirmButton\"]")).click();
        Thread.sleep(3000);
      
        // Rejecting javascript alert
        Alert alert1 = driver.switchTo().alert();
        alert1.dismiss();        
        
    }
    

}