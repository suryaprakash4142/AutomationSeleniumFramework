package AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameworkTutorial.A_06OrdersPage;

public class A_01ReuseableComponenets {

	WebDriver driver;

	public A_01ReuseableComponenets(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@routerlink = '/dashboard/myorders']")
	WebElement ordersXpath;

	public A_06OrdersPage orderspage01() {
		ordersXpath.click();
		
		A_06OrdersPage page = new A_06OrdersPage(driver);
		return page;
	}

	public void wait01Visibility(By find) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(find));
	}
	public void wait02Invisibility(By find01) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(find01));
	}

	public void WebElementwait02Visibility03(WebElement elem) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
}
