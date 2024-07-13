package com.selenium4.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		// 1. Copy Past Operation 
		//keyBoardActionOne(driver);
		
		//2. Opening another tab using key board actions
		openNewTab(driver);
		
		Thread.sleep(5000);
		driver.quit();
	}

	private static void openNewTab(WebDriver driver) {
		driver.get("https://demo.nopcommerce.com/");
		WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).build().perform();
		
		Set<String> windows = driver.getWindowHandles();
		List<String> windownsList = new ArrayList(windows);
		
		driver.switchTo().window(windownsList.get(1));
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Souvik");
		
		driver.switchTo().window(windownsList.get(0));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Selenium Testing");
		
		System.out.println("Done");
		
	}

	private static void keyBoardActionOne(WebDriver driver) {
		driver.get("https://text-compare.com/");
		WebElement textBox = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		textBox.sendKeys("Selenium Testing...");
		
		Actions action = new Actions(driver);
		
		//CTRL+A - select the text
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();
		
		//CTRL+C - copy the text into clipboard
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();
		
		//TAB - moved the courser to 2nd text box
		action.keyDown(Keys.TAB).build().perform();
		
		//CTRL+V - past the copied text
		action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();
		
		System.out.println("Execution done");
	}

}
