package SeleniumFrameworkTutorial;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumframe.datafiles.A_01javaJsonMethods;

public class A_05jsonconcept extends A_02BaseTest {

	

	@Test(dataProvider = "map01")

	// here we are input method to retreiving the data from hashmap tp actual method
	// and by using (input.get) method the will come
	public void ecommerce(HashMap<String, String> input) throws IOException, InterruptedException {

		String country = "India";
		country.equalsIgnoreCase(country);
		A_01LandingPage landing = test01();
		A_02ProductCatalogue catalogue = landing.loginApplication(input.get("email"), input.get("password"));
		A_03CartPage cartpage = catalogue.findProduct(input.get("productName"));
		cartpage.cartpage(input.get("email"));
		Assert.assertTrue(cartpage.cartpage(input.get("productName")));
		A_04checkOutPage page04 = cartpage.wrap();
		A_05confirmationpage page05 = page04.actions(country);
		page05.lastpage();
		System.out.println(page05.lastpage());
		Assert.assertTrue(page05.lastpage().equalsIgnoreCase("Thankyou for the order."));

	}

	@DataProvider
	public Object[][] map01() throws IOException {

		A_01javaJsonMethods javajson = new A_01javaJsonMethods();

		List<HashMap<String, String>> data = javajson.jsonDataReaders(
				System.getProperty("user.dir") + "\\src\\test\\java\\seleniumframe\\datafiles\\pruchaseorder.JsonFile");
		return new Object[][] { {data.get(0)}, {data.get(1)} };
	}

}
