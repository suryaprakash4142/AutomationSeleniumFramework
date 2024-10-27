package seleniumframe.datafiles;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AbstractComponents.A_02ExtendReportGlobally;
import SeleniumFrameworkTutorial.A_02BaseTest;

public class A_03ExtentTestNGLIsteners extends A_02BaseTest implements ITestListener {
	ExtentTest test;

//A_02ExtendReportGlobally - we cna seen in this particular class we mentioned as static so thats why we havent created any object here 

	ExtentReports extent = A_02ExtendReportGlobally.ExtendConcepts();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//Thread Safe (it will be having their own iteration not getting any confusion in it

	@Override
	public void onTestStart(ITestResult result) {
//result means it will get all the details of the method whateverever it stored and it will get the method name also		
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//its having unique thread ID
		//so if we are using set means then we have to use get method for success and failure to get the output
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		//01.)
		//test.log(Status.PASS, "Test is passed");
		//02.)
		extentTest.get().log(Status.PASS, "Test is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable());
//the result will hold what driver the test case is holding and it iwll get into it by wrinting this try catch method		
		
		//getTestClass - will go and get the xml file which was created by listeners (A-01Testng.xml)
		//getRealClass -  will go and get the actual real class
					// by this we are assigning life to the driver
		//IMP : interview Question
					// i cannot use test method to get the driverthe fields associated with class
					// level not with method level
		try {

			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//exception will get all types of exception errors (illegalaccessexception, securityException, nosuchFieldException)		
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String filepath = null;
		try {
			filepath = ScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {

		extent.flush();

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
}
