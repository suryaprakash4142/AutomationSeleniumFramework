package SeleniumFrameworkTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.A_01ReuseableComponenets;
//this is the POM for EndtoEndAutomationTestcopy
public class A_01LandingPage extends A_01ReuseableComponenets {
	
	
	WebDriver driver;
	public A_01LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
				
	}
	//instead of using driver.etc we can use this by don't hardcoding any webelement			
	@FindBy(xpath="//input[@placeholder = 'email@example.com']")
	WebElement Useremail;
	
	@FindBy(xpath = "//input[@formcontrolname='userPassword']")
	WebElement Userpassword;
	
	@FindBy(xpath="//*[@class='btn btn-block login-btn']")
	WebElement clickable;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement wrongPassword;
	
	//performing actions for the above inputs and providing arguments in the method itself
	

	public String WrongPass() {
		WebElementwait02Visibility03(wrongPassword);
		String wrongText = wrongPassword.getText();
		System.out.println(wrongText);
		return wrongText;
	}
	
	public void url() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	  
	public A_02ProductCatalogue loginApplication(String email,String password ) {
	
			
		Useremail.sendKeys(email);
		Userpassword.sendKeys(password);
		clickable.click();	
		return new A_02ProductCatalogue(driver);
	}
	
	

}

//1.) in step 11, 12, 13 tells that in this landing page wqe are having null driver for that we are adding the4 object of landing page in EndtoEndAutomation Testcopy
  //this.driver = driver will import the things from EndtoENd test case to landing page

//2.) 
