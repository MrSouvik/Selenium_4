package com.selenium4.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*	**Types of CSS Selector
 *    ----------------------
 *    
 * 	tag id  -> tag#id  //tag is optional 
 * 	tag class -> tag.class
 * 	tag attribute -> tag[attribute="value"]
 * 	tag class attribute -> tag.classname[attribute="value"]
 * 
 */

public class CSS_Selector {
	public static void main(String[] args) {
		WebDriver driver  =new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//tag id(including tag name)
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-Shirt");
		
		//tag id(without tag name)
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-Shirt");
		
		//tag.class(including tag name)
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("T-Shirt");
		
		//tag.class(without tag name)
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("T-Shirt");
		
		//tag attribute (including tag name)
		//driver.findElement(By.className("input[name='q']")).sendKeys("T-sirt");
		
		//tag attribute (without tag name)
		//driver.findElement(By.className("[name='q']")).sendKeys("T-sirt");
		
		//tag class attribute (including tag name)
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("T-shirt");
		
		//tag class attribute (without tag name)
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("T-shirt");
	}

}
