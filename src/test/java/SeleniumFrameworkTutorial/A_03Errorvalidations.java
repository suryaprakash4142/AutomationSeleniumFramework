package SeleniumFrameworkTutorial;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumframe.datafiles.A_04RetryAnalyser;

public class A_03Errorvalidations extends A_02BaseTest{
	
	@Test(retryAnalyzer = A_04RetryAnalyser.class)
	public void ecommerce() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		String country = "India";
		country.equalsIgnoreCase(country);

		
		// driver.get("https://rahulshettyacademy.com/client/");
		// landing.URL("https://rahulshettyacademy.com/client/");
//inserting the object in the previous page
		A_01LandingPage landing = test01();
		A_02ProductCatalogue catalogue = landing.loginApplication("surya830@gmajil.com", "Surya@4142");
		
		Assert.assertEquals("Incorrect email or password.", landing.WrongPass());
		landing.WrongPass();
		driver.close();
	
}
	/*@Test
	public void ecommerce02() throws IOException, InterruptedException {

		String productName = "ZARA COAT 33";
		String country = "India";
		country.equalsIgnoreCase(country);

		
		// driver.get("https://rahulshettyacademy.com/client/");
		// landing.URL("https://rahulshettyacademy.com/client/");
//inserting the object in the previous page
		A_01LandingPage landing = test01();
		A_02ProductCatalogue catalogue = landing.loginApplication("surya83@gmail.com", "Surya@4142");

		// List<WebElement> objects = catalogue.getProduct();
		// catalogue.addtocart(productName);
		A_03CartPage cartpage = catalogue.findProduct(productName);
		cartpage.cartpage(productName);
		Assert.assertFalse(cartpage.cartpage(productName));
		A_04checkOutPage page04 = cartpage.wrap();
		A_05confirmationpage page05 = page04.actions(country);
		page05.lastpage();
		System.out.println(page05.lastpage());
		Assert.assertTrue(page05.lastpage().equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}*/

}
