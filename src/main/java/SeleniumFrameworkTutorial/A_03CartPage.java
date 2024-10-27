package SeleniumFrameworkTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.A_01ReuseableComponenets;

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

public class A_03CartPage extends A_01ReuseableComponenets{
	
	WebDriver driver;
	
	public A_03CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//*[@class='cartSection removeWrap']/button)[1]")
	WebElement wrap;
	
	@FindBy(css=".cartWrap.ng-star-inserted h3")
	List<WebElement> cartProducts;
	
	
	public boolean cartpage(String productName) {
		boolean correct = cartProducts.stream().anyMatch(a->a.getText().equalsIgnoreCase(productName));
		return correct;
	}
	
	public A_04checkOutPage wrap() {
		
		wrap.click();
		return new A_04checkOutPage(driver);
	}
	
	
	
	
	
	

	
	

}
