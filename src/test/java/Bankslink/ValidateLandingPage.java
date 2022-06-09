package Bankslink;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage_PO;
import resources.BaseInitializar;

public class ValidateLandingPage extends BaseInitializar{
	
	public WebDriver driver;
	
	@BeforeTest
	public void InitializeTest() throws Exception {
		
		driver =InitializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void ValidateHomePage() {
		
		HomePage_PO hPO = new HomePage_PO(driver);
		Assert.assertTrue(hPO.getHomeImg().isDisplayed());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
