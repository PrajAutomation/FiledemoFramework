package resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		
		String filepath = System.getProperty("user.dir")+"\\report\\index.html";
		File src = new File(filepath);
		ExtentSparkReporter reporter = new ExtentSparkReporter(src);
		reporter.config().setDocumentTitle("Automation Praj");
		reporter.config().setReportName("Bancslink");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Prasann");
		return extent;
	}

}
