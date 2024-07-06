package com.selenium4.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		// 1. Select drop down
		selectDropdown(driver);
		
		// 2. Bootstrap drop down 
		bootStrapDropdown(driver);
		
		// 3. Hidden drop down 
		hiddenDropdown(driver);
		
		// 4. Auto Suggest drop down 
		autoSuggestDropdown(driver);
		
		driver.quit();
	}
	
	public static void hiddenDropdown(WebDriver driver) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.sendKeys("Admin");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.sendKeys("admin123");
		WebElement loginBtn = driver.findElement(By.xpath("//button[normalize-space()=\"Login\"]"));
		loginBtn.click();
		
		WebElement pimEle = driver.findElement(By.xpath("//span[text()='PIM']"));
		pimEle.click();
		
		//select one element
		String  value  = "Automaton Tester";
		WebElement jobTitleDropDown = driver.findElement(By.xpath("//label[text()='Job Title']/../../div/div/div/div[2]/i"));
		jobTitleDropDown.click();
		WebElement automationTesterValue = driver.findElement(By.xpath("//span[text()='"+value+"']"));
		automationTesterValue.click();
		boolean isSelected = driver.findElement(By.xpath("//div[text()='"+value+"']")).isDisplayed();
		if(isSelected) {
			System.out.println("Dropdown value "+value+" selected from the dropdown");
		}
		else {
			System.out.println("Failed to select "+value+" from the dropdown");
		}
		
		//count the number of options
		jobTitleDropDown.click();
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='oxd-select-option']/span"));
		System.out.println("No of options  - "+options.size());
		
		//Printing all the elements
		System.out.println("List of options - ");
		for(WebElement ele : options) {
			System.out.println(ele.getText());
		}
	}

	public static void bootStrapDropdown(WebDriver driver) {
 		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		//Select single option
		WebElement eleDrop = driver.findElement(By.xpath("//button[@data-toggle='dropdown']"));
		eleDrop.click();
		driver.findElement(By.xpath("//input[@value='Java']")).click();
		eleDrop.click();
		System.out.println("Selected options  - "+eleDrop.getText());
		
		//capture all the options and print the size
		driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/li/a/label[@class='checkbox']"));
		System.out.println("Total No of options - "+options.size());
		//Printing all the options from the drop down 
		for(WebElement ele : options) {
			String text = ele.getText();
			System.out.println(text);
		}
		
		//de-select if any one is selected
		int count=0;
		List<WebElement> checkBox = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/li/a/label[@class='checkbox']/*"));
		for(WebElement ele : checkBox) {
			if(ele.isSelected()) {
				ele.click();
				count++;
			}
		}
		System.out.println(count+" element de selected");
		
		//Selecting multiple options 
		for(int i = 0; i<options.size(); i++) {
			if(options.get(i).getText().equalsIgnoreCase("Python") || options.get(i).getText().equalsIgnoreCase("MySQL")) {
				options.get(i).click();
			}
		}
		System.out.println("Selected options  - "+eleDrop.getText());
	}

	public static void selectDropdown(WebDriver driver) throws InterruptedException {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement eleCountry = driver.findElement(By.xpath("//select[@id='country']"));
		Select sel = new Select(eleCountry);
		sel.selectByValue("japan");
		System.out.println("Selected Dropdown - "+sel.getAllSelectedOptions().get(0).getText());
		Thread.sleep(5000);
		sel.selectByVisibleText("France");
		System.out.println("Selected Dropdown - "+sel.getAllSelectedOptions().get(0).getText());
		Thread.sleep(5000);
		sel.selectByIndex(9);
		System.out.println("Selected Dropdown - "+sel.getAllSelectedOptions().get(0).getText());
		Thread.sleep(5000);
		
		List<WebElement> options = sel.getOptions();
		System.out.println("Number of options in a drop down : "+options.size());
//		for(int i=0;i<options.size();i++) {
//			System.out.println(options.get(i).getText());
//		}
		
		for(WebElement op:options) {
			System.out.println(op.getText());
		}
	}
	public static void autoSuggestDropdown(WebDriver driver) throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
		Thread.sleep(5000);
		List<WebElement> text = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@role='option']"));
		
		for(int i = 0;i<text.size();i++) {
			if(text.get(i).getText().equalsIgnoreCase("Selenium")) {
				text.get(i).click();
				System.out.println("Clicked on Selenium");
				break;
			}
		}
		
		Thread.sleep(5000);
	}
}
