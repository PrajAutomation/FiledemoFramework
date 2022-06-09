package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PO {

	WebDriver driver;
	public LoginPage_PO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	public WebElement email_LoginTxt;
	
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	public WebElement password_LoginTxt;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	public WebElement login_btn;
	
	public WebElement getloginBtn() {
		return login_btn;
	}
	
	public WebElement getEmail_LoginTxt() {
		return email_LoginTxt;
	}
	
	public WebElement getPassword_LoginTxt() {
		
		return password_LoginTxt;
	}
}
