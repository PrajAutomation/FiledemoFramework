package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseInitializar {
	
	public WebDriver driver=null;
	public Properties prop=null;
	
	public WebDriver InitializeDriver() throws Exception {
	
	prop=new Properties();
	FileInputStream fis=new FileInputStream(new File("D:\\my workspace\\AutomationExercise\\src\\main\\java\\resources\\Data.properties"));
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\java installation\\chromedriver.exe");
		driver= new ChromeDriver();
		
	}else if(browserName.equalsIgnoreCase("firefox")) {
		
		System.out.println("Initialize firefox");
	}else if(browserName.equalsIgnoreCase("IE")) {
		System.out.println("Initialize IE");
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	public String getScreenshotPath(WebDriver driver,String TestCaseName) throws Exception {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\report\\"+TestCaseName+".png";
		FileUtils.copyFile(src, new File(destinationPath));
		return destinationPath;
		
	}
}
