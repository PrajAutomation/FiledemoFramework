package Bankslink;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage_PO;
import pageObjects.LoginPage_PO;
import resources.BaseInitializar;

public class LoginValidation extends BaseInitializar{
	
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws Exception {
		
		driver =InitializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test(dataProvider="getData")
	public void LoginValidationUser(String email,String password) {
		HomePage_PO hPO = new HomePage_PO(driver);
		hPO.getLogin_SignUpBtn().click();
		
		LoginPage_PO LPO = new LoginPage_PO(driver);
		LPO.getEmail_LoginTxt().sendKeys(email);
		LPO.getPassword_LoginTxt().sendKeys(password);
		
		Actions act =new Actions(driver);
		act.moveToElement(LPO.login_btn).click().build().perform();
		
		String UserLoggedIn = hPO.getUserLoginNavLink().getText();
		Assert.assertEquals(UserLoggedIn, "Logged in as Rohan");
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][2];
		
		data[0][0]="xyz@gmail.com";
		data[0][1]="1234";
		data[1][0]="xyz123@gmail.com";
		data[1][1]="1234";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
