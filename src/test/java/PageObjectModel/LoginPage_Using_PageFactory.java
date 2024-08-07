package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Using_PageFactory {

	WebDriver driver;

	public LoginPage_Using_PageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Locators
	
	/*By userName = By.xpath("//input[@placeholder='Username']");
	By password = By.xpath("//input[@placeholder='Password']");
	By loginBtn = By.xpath("//button[normalize-space()='Login']");
	*/
	
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
//	@FindBy(xpath="//button[normalize-space()='Login']")
//	WebElement loginBtn;
	
	@FindBy(how=How.XPATH,using= "//button[normalize-space()='Login']")
	WebElement loginBtn;
	
	//Actions Methods
	
	public void enterUserName (String pass) {
		userName.sendKeys(pass);
	}
	
	public void enterPassword (String user) {
		password.sendKeys(user);
	}
	
	public void clickOnLogin() {
		loginBtn.click();
	}
}
