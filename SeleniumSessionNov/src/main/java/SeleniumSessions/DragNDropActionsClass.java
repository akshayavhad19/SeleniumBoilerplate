package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragNDropActionsClass {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		By draggable= By.id("draggable");
		By droppable =By.id("droppable");
		
		WebElement srcEle=driver.findElement(draggable);
		WebElement trgtEle=driver.findElement(droppable);
		
		Actions act = new Actions(driver);
		
//		act.
//		   clickAndHold(srcEle)
//		   		.moveToElement(trgtEle)
//		   			.release()
//		   				.build()	
//		   					.perform();
		
		act.dragAndDrop(srcEle, trgtEle).build().perform();
	}
}
