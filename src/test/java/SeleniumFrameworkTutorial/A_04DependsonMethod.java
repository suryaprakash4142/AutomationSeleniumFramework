package SeleniumFrameworkTutorial;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class A_04DependsonMethod extends A_02BaseTest {


	//while running this code it will check the first the data provider 
	//01.) general way public void ecommerce(String email, String Password) throws IOException, InterruptedException {
	
	public String productName = "ZARA COAT 3";
	@Test(dataProvider="jsoncoObject1")
	
	//here we are input method to retreiving the data from hashmap tp actual method and by using (input.get) method the will come
	public void ecommerce(HashMap<String,String> input) throws IOException,InterruptedException {

		String country = "India";
		country.equalsIgnoreCase(country);
		A_01LandingPage landing = test01();
		A_02ProductCatalogue catalogue = landing.loginApplication(input.get("email"), input.get("password"));
		A_03CartPage cartpage = catalogue.findProduct(input.get("productName"));
		cartpage.cartpage(productName);
		Assert.assertTrue(cartpage.cartpage(input.get("productName")));
		A_04checkOutPage page04 = cartpage.wrap();
		A_05confirmationpage page05 = page04.actions(country);
		page05.lastpage();
		System.out.println(page05.lastpage());
		Assert.assertTrue(page05.lastpage().equalsIgnoreCase("Thankyou for the order."));
	}

	/*@Test(dependsOnMethods = { "ecommerce" })
	public void ordersPage() throws IOException {

		A_01LandingPage landing = test01();
		A_02ProductCatalogue catalogue = landing.loginApplication("surya83@gmail.com", "Surya@4142");
		A_06OrdersPage page = catalogue.orderspage01();
		Assert.assertTrue(page.orderspagedetails(productName));
	}*/
	
	
//01.) general way there is other way to make it generic and by using json concept
	
	/*@DataProvider
	public Object[][] jsonConcept() {
//here we used object (means it can be used as string or int or char any thing it can worked)
		return new Object[][] {{"surya83@gmail.com","Surya@4142"}, {"shetty@gmail.com","iamking@000"}};
	}*/

//02.) using json Haspmap concept
	@DataProvider
	public Object[][] jsoncoObject1() {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "surya83@gmail.com");
		map.put("password", "Surya@4142");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "surya83@gmail.com");
		map1.put("password", "Surya@4142");
		map1.put("productName", "ADIDAS ORIGINALS");
		
		
		return new Object[][] {{map},{map1}};
		
		
	
	}
}
