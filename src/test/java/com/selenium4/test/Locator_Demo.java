package com.selenium4.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator_Demo {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//name 
		driver.findElement(By.name("search")).sendKeys("Mac");
		
		//id
		boolean logoDisplayStatus = driver.findElement(By.id("logo")).isDisplayed();
		System.out.println("Logo Displayed status "+logoDisplayStatus);
		
		//linkedText
		
		driver.findElement(By.linkText("Tablets")).click();
		
		String actualTitle = driver.getTitle();
		if(actualTitle.equals("Tablets")) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Pass");
		}
		
		//Partial linkedText
		int n = driver.findElements(By.partialLinkText("Tablets")).size();
		System.out.println("Size of partial linked Text "+n);
		driver.close();
	}
}
