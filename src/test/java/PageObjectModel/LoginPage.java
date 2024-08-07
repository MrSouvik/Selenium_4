package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	
	By userName = By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By loginBtn = By.xpath("//button[normalize-space()='Login']");
	
	//Actions Methods
	
	public void enterUserName (String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void enterPassword (String user) {
		driver.findElement(userName).sendKeys(user);
	}
	
	public void clickOnLogin() {
		driver.findElement(loginBtn).click();
	}
}
