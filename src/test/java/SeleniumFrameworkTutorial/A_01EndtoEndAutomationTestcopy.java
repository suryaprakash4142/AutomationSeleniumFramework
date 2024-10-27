package SeleniumFrameworkTutorial;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class A_01EndtoEndAutomationTestcopy extends A_02BaseTest {

	@Test
	public void ecommerce() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		String country = "India";
		country.equalsIgnoreCase(country);

		
		// driver.get("https://rahulshettyacademy.com/client/");
		// landing.URL("https://rahulshettyacademy.com/client/");
//inserting the object in the previous page
	//here we are using @Before annotation that means this step is no more required	
	A_01LandingPage landing = test01();
		A_02ProductCatalogue catalogue = landing.loginApplication("surya83@gmail.com", "Surya@4142");

		// List<WebElement> objects = catalogue.getProduct();
		// catalogue.addtocart(productName);
		A_03CartPage cartpage = catalogue.findProduct(productName);
		cartpage.cartpage(productName);
		Assert.assertTrue(cartpage.cartpage(productName));
		A_04checkOutPage page04 = cartpage.wrap();
		A_05confirmationpage page05 = page04.actions(country);
		page05.lastpage();
		System.out.println(page05.lastpage());
		Assert.assertTrue(page05.lastpage().equalsIgnoreCase("Thankyou for the order."));
	}

}