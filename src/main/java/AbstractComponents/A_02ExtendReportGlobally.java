package AbstractComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class A_02ExtendReportGlobally {
	
// we are using static keyword because of this static that doesn't matter to create object wherever the code is required for other classes
	public static ExtentReports ExtendConcepts() {
		
		String path = System.getProperty("user.dir")+"\\reports\\rep01.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Frameworks Concept");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("SDET QA", "Surya Prakash");
		return extent;
		
	}

}
