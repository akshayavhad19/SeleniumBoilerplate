package com.qa.videos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dummy {
	static WebDriver driver;
	public static void main(String[] args) {
		
		
		
		
		
		
		// Initialize WebDriver
		driver = new ChromeDriver();

		// List of video URLs to check
		String[] videoLinks = {
				"https://hai-senishou.jp/ssc/patient-open-space/overseas-japanese-patients/sakamoto-dawn",
				"https://hai-senishou.jp/ssc/patient-open-space/overseas-japanese-patients/mitsuo-akutsu"
		};
		By playIcon= By.xpath("//button[@class='vjs-big-play-button']");
		for (String url : videoLinks) {
			driver.get(url); // Open video URL
			driver.manage().window().maximize();

			try {
				Thread.sleep(6000);
				if(driver.findElement(By.tagName("video-js")).isDisplayed()) {
					doClick(playIcon);
					System.out.println("Video is UP and playing: " + url);
				}
				else{
					System.out.println("Video is DOWN or not playing: " + url);
				}
			}
			catch (Exception e) {
				System.out.println("Video not found or error on page: " + url);			}
		}
		driver.quit();
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}
	public static WebElement getElement (By locator) {
		return driver.findElement(locator);
	}
	
	
	
}
