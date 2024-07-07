package com.selenium4.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web_Table {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		// 1. Static web table
		staticWebTable(driver);
		
		//2. Dynamic table
		dynamictable(driver);
		
		//3. Bootstrap table
		bootStrapTable(driver);
		driver.quit();
	}

	public static void bootStrapTable(WebDriver driver) {
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
		
		// Print all the Employee list and click 
		int rows = driver.findElements(By.xpath("//div[@role='table']/div[@class='oxd-table-body']/div")).size();
		System.out.println("No of rows - "+rows);
		for(int row=1; row<=rows; row++) {
			int cols = driver.findElements(By.xpath("//div[@role='table']/div[@class='oxd-table-body']/div["+row+"]/div/div")).size();
			for(int col =1; col<=cols; col++) {
				WebElement ele = driver.findElement(By.xpath("//div[@role='table']/div[@class='oxd-table-body']/div["+row+"]/div/div["+col+"]/div"));
				if(col==1) {
					WebElement checkBox = driver.findElement(By.xpath("//div[@role='table']/div[@class='oxd-table-body']/div["+row+"]/div/div[1]/div/div/label"));
					checkBox.click();
				}
				else {
					String text = ele.getText();
					System.out.print(text+"\t");
				}
				
			}
			System.out.println();
		}
	}

	public static void dynamictable(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// Find the no of page in the table
		List<WebElement> pages = driver.findElements(By.xpath("//div[@class='table-container']/ul/li"));
		int totalPages=pages.size();
		System.out.println("Total no of page - "+totalPages);
		
		// Printing all rows and column, click on checkbox
		for(int i = 1; i<=totalPages; i++) {
			pages.get(i-1).click();
			int rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
			for(int row = 1 ; row<=rows; row++) {
				int cols = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr["+row+"]/td")).size();
				for(int col = 1 ; col<=cols; col++) {
					WebElement ele = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+row+"]/td["+col+"]"));
					if(col==4) {
						WebElement checkbox = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+row+"]/td["+col+"]/*"));
						checkbox.click();
					}
					else {
						String text = ele.getText();
						System.out.print(text +"\t");
					}
				}
				System.out.println();
			}
		}
	}

	public static void staticWebTable(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Find total no of rows present in the table (book list)
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size(); //multiple table
		//int rows = driver.findElements(By.tagName("tr")).size(); //single table
		System.out.println("No of rows - "+rows);
		
		//Find total no of columns present in the table
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th")).size(); //multiple table
		//int columns = driver.findElements(By.tagName("th")).size(); //single table
		System.out.println("No of columns - "+columns);
		
		//Read data from specific row & column (Ex - 5th row and 1st column)
		int rowNo = 5;
		int columnNo = 1;
		String text = driver.findElement(By.xpath(" //table[@name='BookTable']/tbody/tr["+rowNo+"]/td["+columnNo+"]")).getText();
		System.out.println("Text captured from "+rowNo+"'th row & "+columnNo+"'st column is - "+text);
		
		//Read data from all rows and columns 
		for(int row = 1; row<=rows ; row++) { //1st row ignored as it's having header part
			for(int col = 1 ; col<=columns ; col++) {
				String value = driver.findElement(By.xpath(" //table[@name='BookTable']/tbody/tr["+row+"]/*["+col+"]")).getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		
		//Print book name whose author is Mukesh
		System.out.println("Printing bookname whose author is Mukesh  -  ");
		for(int row = 1; row<=rows ; row++) { //1st row ignored as it's having header part
			String author = driver.findElement(By.xpath(" //table[@name='BookTable']/tbody/tr["+row+"]/*[2]")).getText();
			if(author.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath(" //table[@name='BookTable']/tbody/tr["+row+"]/*[1]")).getText();
			    System.out.println(bookName);	
			}
		}
		
		//Find total price of all the books
		int totalPrice  = 0;
		for(int row = 2; row<=rows ; row++) {
			String price  = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+row+"]/td[4]")).getText();
			totalPrice+=Integer.parseInt(price);
		}
		System.out.println("Total Price of all the books is - "+totalPrice);
	}
}
