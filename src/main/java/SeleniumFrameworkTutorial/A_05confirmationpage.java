package SeleniumFrameworkTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.A_01ReuseableComponenets;

public class A_05confirmationpage extends A_01ReuseableComponenets {
	WebDriver driver;

	public A_05confirmationpage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[text()=' Thankyou for the order. ']")
	WebElement message;
	
	public String lastpage() {
		
		message.getText();
		return message.getText();
	}
	

}
