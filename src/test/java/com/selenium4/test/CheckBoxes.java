package com.selenium4.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxes {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		List<WebElement> daysEle = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		int size = daysEle.size();
		
		// 1) Select specific checkbox
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
//		2) Select all checkboxes 
		
//		for(WebElement ele : daysEle) {
//			ele.click();
//		}
		
		// 3) Select last 3 checkboxes	
/*  	for(int i = size - 3 ; i< size ; i++ ) {
			daysEle.get(i).click();
		}*/
		
		// 4) Select first 3 checkboxes
		/*for(int i=0;i<3;i++) {
			daysEle.get(i).click();
		}*/
		
		// 5) Unselect checkboxes if they are selected 
		for(int i=0;i<3;i++) {
			daysEle.get(i).click();
		}
		
		Thread.sleep(5000);
		
		for(WebElement ele : daysEle) {
			if(ele.isSelected()) 
				ele.click();
		}
		
		driver.quit();
	}
}
