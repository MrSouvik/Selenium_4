package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class shadowDomElements {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/shadowdom");
		driver.manage().window().maximize();
		
		//This Element is inside single shadow DOM. xpath and other locator can't handle shadow doms elements, only css selector can handle 
		String cssSelectorForHost1 = "#shadow-host";
		Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-host")).getShadowRoot();
		Thread.sleep(1000);
		String text = shadow.findElement(By.cssSelector("#my-btn")).getText();
		System.out.println("Text - "+text );
		driver.quit();
	}
}
