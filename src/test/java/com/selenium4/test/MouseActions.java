package com.selenium4.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		// 1. Mouse hover
		mouseHover(driver);
		
		// 2. Right click
		rightClick(driver);

		// 3. Double click
		doubleClick(driver);
		
		// 4. Drag & Drop
		dragAndDrop(driver);
		
		// 5. Slider
		slider(driver);
		
		Thread.sleep(5000);
		driver.quit();
	}

	private static void slider(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/");
		//driver.switchTo().frame(1);
		WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		
		System.out.println("Default location of the slider - "+slider.getLocation()); // (413, 282) - > (X,Y)
		
		Actions action  = new Actions(driver);
		action.dragAndDropBy(slider, 200, 0).build().perform();
		
		System.out.println("Location after performing operation of the slider - "+slider.getLocation());
	}

	private static void dragAndDrop(WebDriver driver) {
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	
		WebElement Oslo = driver.findElement(By.id("box1"));
		WebElement Norway = driver.findElement(By.id("box101"));
		
		WebElement Stockholm = driver.findElement(By.id("box2"));
		WebElement Sweden = driver.findElement(By.id("box102"));
		
		WebElement washington = driver.findElement(By.id("box3"));
		WebElement us = driver.findElement(By.id("box103"));
		
		WebElement Copenhagen = driver.findElement(By.id("box4"));
		WebElement Denmark = driver.findElement(By.id("box104"));
		
		WebElement Seoul = driver.findElement(By.id("box5"));
		WebElement South_Korea = driver.findElement(By.id("box105"));
		
		WebElement rome = driver.findElement(By.id("box6"));
		WebElement italy = driver.findElement(By.id("box106"));
		
		WebElement Madrid = driver.findElement(By.id("box7"));
		WebElement Spain = driver.findElement(By.id("box107"));
		
		Actions action  = new Actions(driver);
		
		//drag & drop
		Action dragNDrop_1 = action.dragAndDrop(Oslo, Norway).build();
		Action dragNDrop_2 = action.dragAndDrop(Stockholm, Sweden).build();
		Action dragNDrop_3 = action.dragAndDrop(washington, us).build();
		Action dragNDrop_4 = action.dragAndDrop(Copenhagen, Denmark).build();
		Action dragNDrop_5 = action.dragAndDrop(Seoul, South_Korea).build();
		Action dragNDrop_6 = action.dragAndDrop(rome, italy).build();
		Action dragNDrop_7 = action.dragAndDrop(Madrid, Spain).build();
		
		dragNDrop_1.perform();
		dragNDrop_2.perform();
		dragNDrop_3.perform();
		dragNDrop_4.perform();
		dragNDrop_5.perform();
		dragNDrop_6.perform();
		dragNDrop_7.perform();
	}

	private static void doubleClick(WebDriver driver) {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.switchTo().frame("iframeResult");
		String inputText = "Selenium Testing";
		WebElement box1 = driver.findElement(By.xpath("//input[@id=\"field1\"]"));
		WebElement box2 = driver.findElement(By.xpath("//input[@id=\"field2\"]"));
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()=\"Copy Text\"]"));
		box1.clear();
		box1.sendKeys(inputText);
		
		Actions action  = new Actions(driver);
		action.doubleClick(button).build().perform();
		
		String text = box2.getAttribute("value");
		
		if(text.equals(inputText)) {
			System.out.println("Both the text boxes text are same");
		}
		
		
		
	}

	private static void rightClick(WebDriver driver) {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClickMe = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action  = new Actions(driver);
		
		//Right click action
		action.contextClick(rightClickMe).build().perform();
		
	}

	public static void mouseHover(WebDriver driver) {
		driver.get("https://stqatools.com/demo/MouseHover.php");
		WebElement mouseHoverDropdown = driver.findElement(By.xpath("//button[text()='Mouse Hover DropDown']"));
		Actions action  = new Actions(driver);
		
		//Mouse hover action
		action.moveToElement(mouseHoverDropdown).build().perform();
		
	}
}
