package com.selenium4.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Xpath is a address of an element
 * 
 * DOM - Document object model
 * 
 * 2 Types of Xpath 
 * -------------------
 * 1) Absolute xpath(full path) Ex: /html/body/header/div/div/div[2]/div/input
 * 2) Relative xpath(partial xpath) Ex: //*[@id="search"]/input
 * 
 * Which xpath will be prefered ?
 * - Relative xpath
 * 
 * *Difference between absolute xpath and relative xpath
 * -absolute xpath start with / & relative xpath start with //
 * -absolute xpath does not use attribute , relative xpath used attributes
 * -absolute xpath traverse through each node till it's find the element, relative xpath directly jump into the element by using attribute 
 * 
 */
public class xpath {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//xpath with single attribute
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("A");
		
		//xpath with multiple attribute
		driver.findElement(By.xpath("//input[@placeholder='Search'][@name='search']")).sendKeys("B");
		
		//xpath with 'and' operator
		driver.findElement(By.xpath("//input[@placeholder='Search' and @name='search']")).sendKeys("C");
		
		//xpath with 'or' operator
		driver.findElement(By.xpath("//input[@placeholder='Search' or @name='xyz']")).sendKeys("D");
		
		//xpath with text() method - inner text
		driver.findElement(By.xpath("//*[text()='Desktops']")).click();
		
		//xpath with contains() method
		driver.findElement(By.xpath("//input[contains(@placeholder,'Se')]")).sendKeys("E");
		
		//xpath with starts-with() method
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Se')]")).sendKeys("F");
		
		//chained xpath 
		boolean status = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(status);
		
	}
}
