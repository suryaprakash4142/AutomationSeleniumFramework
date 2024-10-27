package SeleniumFrameworkTutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A_02BaseTest {

	//previously the driver will be null but after it went to the method it will be converted to chrome or firefox or etc as per the browser
	 protected WebDriver driver=null;
	//public A_01LandingPage landing ;
	public WebDriver main01() throws IOException {

	/*	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));*/
	//it will get all the properties features
		// the file created as test.properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\File\\Resources\\test.properties");
		//load is expecting to send fis input object to the load method
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();	
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\TEJA\\eclipse-workspace\\SeleniumFrameworkDesign\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "c:\\edge.driver");	
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
		
		public String ScreenShot(String testcaseName, WebDriver driver) throws IOException {
	//this driver has no life so thats why we can use it by listeners	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source =ts.getScreenshotAs(OutputType.FILE);	
		File file = new File(System.getProperty("user.dir")+"//reports//" + testcaseName + ".png");
		FileUtils.copyFile(Source, file);	
		return System.getProperty("user.dir")+"//reports//" + testcaseName + ".png";
		}
	

	@BeforeMethod(alwaysRun = true)
	public A_01LandingPage test01() throws IOException {
		
		driver = main01();
		//here we are making it as global level to access for all other classes
		A_01LandingPage landing = new A_01LandingPage(driver);
		landing.url();
		return landing;	
	}
}
