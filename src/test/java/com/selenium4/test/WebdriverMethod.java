package com.selenium4.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMethod {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//get methods - we can access these method through webdriver instance
		
		//1) get method
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//2) getTitle method
		String title = driver.getTitle();
		System.out.println("Current Page title - "+title);
		
		//3) getCurrentUrl method
		driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
		String currUrl  = driver.getCurrentUrl();
		System.out.println("Current Url - "+currUrl);
		
		//4)getPageSource method
		String pageSource = driver.getPageSource();
		System.out.println("Current page source- "+pageSource);
		
		//5)getWindowHandle method
		String window = driver.getWindowHandle();
		System.out.println("Current page window - "+window);
		
		//6)getWindowHandles method
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Page window handles - "+windows);
		
		//conditions method
		//1) isDisplayed method
		WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
		boolean isButtonDisplayed = searchButton.isDisplayed();
		System.out.println("Is button displayed - "+isButtonDisplayed);
		
		//2) isEnabled method
		boolean isButtonEnabled = searchButton.isEnabled();
		System.out.println("Is button Enabled - "+isButtonEnabled);
		
		//3) isSelected method
		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@type='radio'][@value='male']"));
		boolean isSelected  = maleRadioButton.isSelected();
		System.out.println("Before clicking on male radion button isSelected status - "+isSelected);
		maleRadioButton.click();
		isSelected  = maleRadioButton.isSelected();
		System.out.println("After clicking on male radion button isSelected status - "+isSelected);
		//Browser methods
		//1)close
		driver.close(); // close one window tab where driver is pointing 
		//2)quit
		driver.quit(); // close all open windows tab
		
	}
}
