package com.qa.videos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import javax.swing.text.Document;

public class VideoStatusChecker {
	public static void main(String[] args) {
		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		// List of video URLs to check
		String[] videoLinks = {
				"https://www.gpphiroba.jp/movie/index.html/patient/007.html",
		};

		for (String url : videoLinks) {
			driver.get(url); // Open video URL
			driver.manage().window().maximize();

			try {
				// Wait for page to load (adjust sleep time if needed)
				Thread.sleep(6000);

				// Find the video element (assuming only one <video> tag per page)
				WebElement videoElement = driver.findElement(By.tagName("video-js"));
			
				// JavaScript to check if video is playing
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				boolean isPlaying = (Boolean) js .executeScript("document.getElementById(\"video\").play()");

				if (isPlaying) {
					System.out.println("Video is UP and playing: " + url);
				} else {
					System.out.println("Video is DOWN or not playing: " + url);
				}
			} catch (Exception e) {
				System.out.println("Video not found or error on page: " + url);
			}
		}

		// Close the browser
		driver.quit();
	}
}
