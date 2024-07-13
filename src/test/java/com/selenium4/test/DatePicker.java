package com.selenium4.test;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;

public class DatePicker {
	public static void main(String[] args) throws InterruptedException, ParseException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// 1. Using sendkeys method
		//usingSendKeys(driver);
		
		// 2. Using datepicker
		//datePickerApproach(driver);
		
		datePickerApproach_2(driver);
		
		driver.quit();
	}

	public static void datePickerApproach_2(WebDriver driver) {
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.switchTo().frame("frame-one796456169"); //switching to iframe using id
		String year = "1996";
		String month ="October";
		String date = "11";
		
		//Clicking on date picker
		WebElement element=driver.findElement(By.xpath("//span[@class='icon_calendar' and @role='button']"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 element.click();
		
		//Selecting year
		WebElement yearDropdown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select sel = new Select(yearDropdown);
		sel.selectByVisibleText(year);
		System.out.println("Year selected - "+year);
		
		//Selecting month
		while(true) {
			String displayMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			Month convertedActualMonth = convertMonth(displayMonth);
			Month convertedExpectedMonth = convertMonth(month);
			int comparisionResults = convertedActualMonth.compareTo(convertedExpectedMonth);
			
			if(comparisionResults<0) {
				//Future month
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//Next
			}
			else if(comparisionResults>0) {
				//Past month
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//Prev
			}
			else {
				System.out.println("Month selected - "+month);
				break;
			}
		}
		
		// Selecting date
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(WebElement d : alldates) {
			if(d.getText().equals(date)) {
				d.click();
				System.out.println("Date selected - "+date);
				break;
			}
		}
	}


	private static Month convertMonth(String month) {
		HashMap<String,Month> monthMap = new HashMap<String, Month>();
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		return monthMap.get(month);
	}

	public static void datePickerApproach(WebDriver driver) throws InterruptedException, ParseException {
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		String year = "2030";
		String month ="July";
		String date = "11";
		
		WebElement date_ele = driver.findElement(By.xpath("//input[@id=\"datepicker\"]"));
		date_ele.click();
		
		//Select month & year
		while(true) {
			String curr_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String curr_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMM/yyyy");
			
			Date expectedDate = dateFormat.parse(curr_month+"/"+curr_year);
			Date actualDate = dateFormat.parse(month+"/"+year);
            
            int comparisonResult = expectedDate.compareTo(actualDate);
            if(comparisonResult>0) {
            	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//previous
            }
            else if(comparisonResult<0) {
            	driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//next
            }
            else {
            	System.out.println("Year & month selected - "+month+"/"+year);
            	break;
            }
		}
		
		//Select date
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[@data-handler='selectDay']/a"));
		for(WebElement d : alldates) {
			if(d.getText().equals(date)) {
				d.click();
				System.out.println("Date selected - "+date);
				break;
			}
		}
	}

	public static void usingSendKeys(WebDriver driver) {
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		String date = "05/25/2024";
		WebElement date_ele = driver.findElement(By.xpath("//input[@id=\"datepicker\"]"));
		date_ele.sendKeys(date);
	}
}
