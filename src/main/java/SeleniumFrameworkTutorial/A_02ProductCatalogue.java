package SeleniumFrameworkTutorial;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.A_01ReuseableComponenets;

public class A_02ProductCatalogue extends A_01ReuseableComponenets{

	
	WebDriver driver;
	public A_02ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);		
   }
	
	
	@FindBy(css=".container")
	List<WebElement> objects;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	By objects01 = By.cssSelector(".container");
	
	By cartClick = By.xpath("//button[@class='btn w-10 rounded']");
	By wait02 = By.cssSelector(".container");
	By wait03 = By.cssSelector(".ng-animating");
	
	/*public List<WebElement> getProduct() {
		wait01Visibility(objects01);
		return objects;	
	}*/
	
	public A_03CartPage findProduct(String productName) throws InterruptedException{
		
		wait01Visibility(objects01);
		WebElement oneProduct = objects.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		WebElement prod = oneProduct;
		prod.findElement(cartClick).click();
		wait01Visibility(wait02);
		wait02Invisibility(wait03);
		Thread.sleep(2000);
		cart.click();
		
		return new A_03CartPage(driver);
	}
		
	/*	public void addtocart(String productName) throws InterruptedException {
			
			WebElement prod = findProduct(productName);
			prod.findElement(cartClick).click();
			
			wait01Visibility(wait02);
			wait02Invisibility(wait03);
			Thread.sleep(2000);
			//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			cart.click();
			
			
		}*/
	
	
}
