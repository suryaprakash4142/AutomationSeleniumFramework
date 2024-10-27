package SeleniumFrameworkTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.A_01ReuseableComponenets;

public class A_04checkOutPage extends A_01ReuseableComponenets{
	
	WebDriver driver;
	
	public A_04checkOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement selectCountry;
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']/button[2]")
	WebElement star;
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement actionSubmit;

	public A_05confirmationpage actions(String country) throws InterruptedException {
		Actions a = new Actions(driver);

		a.sendKeys(selectCountry, country).build().perform();
		Thread.sleep(2000);
		star.click();
		Thread.sleep(2000);
		actionSubmit.click();
		
		return new A_05confirmationpage(driver);
	}
	
	

}


/*
Actions a = new Actions(driver);

a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), country).build().perform();
Thread.sleep(2000);
driver.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button[2]")).click();
Thread.sleep(2000);
driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
String message = driver.findElement(By.xpath("//*[text()=' Thankyou for the order. ']")).getText();
Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
System.out.println(message);*/
