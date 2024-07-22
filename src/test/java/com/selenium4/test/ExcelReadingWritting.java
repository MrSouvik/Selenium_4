package com.selenium4.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ExcelReadingWritting {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-bikaner-and-jaipur/fixed-deposit-calculator-SBB01-BSB005.html?classic=true");
		
		WebElement noThanks = driver.findElement(By.xpath("//button[text()='No thanks']"));
		noThanks.click();
		WebElement principal = driver.findElement(By.xpath("//input[@id='principal']"));
		WebElement interest = driver.findElement(By.xpath("//input[@id='interest']"));
		WebElement tenure = driver.findElement(By.xpath("//input[@id='tenure']"));
		WebElement tenurePeriod = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
		Select selectPeriod = new Select(tenurePeriod);
		WebElement frequency = driver.findElement(By.xpath("//select[@id='frequency']"));
		Select selectFrequency = new Select(frequency);
		
		WebElement calculate = driver.findElement(By.xpath("(//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif'])[1]"));
		WebElement clear = driver.findElement(By.xpath("//img[@class='PL5']"));
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\Documents\\Caldata.xlsx";
		int row = ExcelUtils.getRowCount(filePath, "Sheet1");
		//System.out.println(row); 
		for(int i=1;i<=row;i++) {
			String principalAmt = ExcelUtils.getCellDate(filePath, "Sheet1", i, 0);
			String interestVal = ExcelUtils.getCellDate(filePath, "Sheet1", i, 1);
			String tenureVal = ExcelUtils.getCellDate(filePath, "Sheet1", i, 2);
			String tenurePeriodVal = ExcelUtils.getCellDate(filePath, "Sheet1", i, 3);
			String frequencyVal = ExcelUtils.getCellDate(filePath, "Sheet1", i, 4);
			String expectedmaturityVal = ExcelUtils.getCellDate(filePath, "Sheet1", i, 5);
			//System.out.println(principalAmt+" - "+maturityVal);
			
			principal.sendKeys(principalAmt);
			interest.sendKeys(interestVal);
			tenure.sendKeys(tenureVal);
			selectPeriod.selectByVisibleText(tenurePeriodVal);
			selectFrequency.selectByVisibleText(frequencyVal);
			calculate.click();
			Thread.sleep(3000);
			
			WebElement maturityValue = driver.findElement(By.xpath("//span[text()='Maturity Value Rs.']/../span[2]/strong"));
			String actualValue = maturityValue.getText();
			
			if(Double.parseDouble(expectedmaturityVal) == Double.parseDouble(actualValue)) {
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Pass");
				ExcelUtils.fillGreenColour(filePath, "Sheet1", i, 7);
				System.out.println("Test Pass");
			}
			else {
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Fail");
				ExcelUtils.fillRedColour(filePath, "Sheet1", i, 7);
				System.out.println("Test Fail");
			}
			clear.click();
		}
		
		driver.quit();
	}
}
