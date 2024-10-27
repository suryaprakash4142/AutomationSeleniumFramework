package seleniumframe.datafiles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;

public class A_02ExtendReportsDemo {

//i am calling the extent class globally because it has to be called to the main method	
	ExtentReports extent;
//here i am getting the HTML report and in that we can see the set reportName, SetDocument Title and SystemInfo	
	@BeforeMethod
	public void ExtendConcepts() {

		// here i am using some important concepts 1.)ExtentSpartReporter,
		// 2.)ExtendReports
		// dynamically we are creating a pathby java
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		com.aventstack.extentreports.reporter.ExtentSparkReporter reporter = new com.aventstack.extentreports.reporter.ExtentSparkReporter(
				path);
		reporter.config().setReportName("Surya's Web Design");
		reporter.config().setDocumentTitle("Automation code");

		// gere comes the main concept extendReports class and ehre we are calling the
		// prevoius method by reporter

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Surya Prakash");

	}

	@Test
	public void ExtendReportDemo() {

		ExtentTest test = extent.createTest("Initial Demo");
		WebDriver driver = new ChromeDriver();
		System.getProperty("webdriver.chrome.driver",
				"C:\\Users\\TEJA\\eclipse-workspace\\SeleniumFrameworkDesign\\drivers\\chromedriver01.exe");

		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		//it will fail the test because we are forcefully sending the fail message
		test.fail("its not working");

		extent.flush();
	}

}
