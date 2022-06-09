package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PO {
	
	
	WebDriver driver;
	public HomePage_PO(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="inputUsername")
	WebElement userName;
	
	@FindBy(xpath="//img[@alt='Website for automation practice']")
	WebElement homeImage;
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement login_SignUpBtn;
	
	@FindBy(xpath="//div[@class='shop-menu pull-right']/ul/li[9]/a")
	WebElement UserLoginNavLink;
	
	public WebElement getUserLoginNavLink() {
		return UserLoginNavLink;
	}
	
	public WebElement getLogin_SignUpBtn() {
		return login_SignUpBtn;
	}
	
	public WebElement getHomeImg() {
		return homeImage;
	}
	
	public WebElement getUserName() {
		
		return userName;	
	}

}
