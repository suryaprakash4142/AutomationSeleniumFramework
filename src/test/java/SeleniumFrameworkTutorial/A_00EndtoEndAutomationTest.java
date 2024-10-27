package SeleniumFrameworkTutorial;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class A_00EndtoEndAutomationTest {

	public static void main(String[] args) throws InterruptedException {
		
		String productName = "ZARA COAT 3";
		String country = "India";
		country.equalsIgnoreCase(country);
				
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		
		
		driver.findElement(By.xpath("//input[@placeholder = 'email@example.com']")).sendKeys("surya83@gmail.com");
		
		driver.findElement(By.xpath("//input[@formcontrolname='userPassword']")).sendKeys("Surya@4142");
		
		driver.findElement(By.cssSelector(".btn.btn-block.login-btn")).click();
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(5));
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".container")));
		
		List<WebElement> objects = driver.findElements(By.cssSelector(".container"));
		
		WebElement oneProduct = objects.stream().filter(s->s.findElement(By.cssSelector(".container b")).getText().equals(productName)).findAny().orElse(null);
		
		oneProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-bottom-right toast-container']")));
		//it is not working right now
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts =  driver.findElements(By.cssSelector(".cartWrap.ng-star-inserted h3"));
		
		Boolean correct = cartProducts.stream().anyMatch(a->a.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(correct);
		
		driver.findElement(By.xpath("(//*[@class='cartSection removeWrap']/button)[1]")).click();
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		
		a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), country).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		String message = driver.findElement(By.xpath("//*[text()=' Thankyou for the order. ']")).getText();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(message);
	}

}
