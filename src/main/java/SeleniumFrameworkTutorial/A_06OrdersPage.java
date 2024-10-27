package SeleniumFrameworkTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import AbstractComponents.A_01ReuseableComponenets;

public class A_06OrdersPage extends A_01ReuseableComponenets{
	
	WebDriver driver = null;
	public A_06OrdersPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		
	}

	@FindBy(xpath="//td[2]")
	List<WebElement> zaracodeList;
	
	public Boolean orderspagedetails(String productName) {
	
		Boolean True = zaracodeList.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
		return True;
	}
		

}
