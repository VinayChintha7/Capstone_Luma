package lumaTestNG;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lumaBase.BaseClass;
import lumaTest.CheckoutTest;
import lumaTest.LoginPageTest;
import lumaTest.RegistrationTest;
import lumaTest.SearchAndAddToCartTest;

public class Runner extends BaseClass {

	@Test(priority = 1)
	public void runnerRegistration() {
		RegistrationTest rt = new RegistrationTest();
		rt.testRegistration();
	}
	
	@Test(priority = 2)
	public void runnerLogin() {
		LoginPageTest lt = new LoginPageTest();
		lt.testLogin("VK1234@gmail.com","Test@1234");
	}
	
	@Test(priority = 3)
	public void runnerAddToCart() throws InterruptedException {
		SearchAndAddToCartTest addToCart = new SearchAndAddToCartTest();
		addToCart.testSearchAndAddToCart();
	}
	
	@Test(priority = 4)
	public void checkout() {
		CheckoutTest Checkout = new CheckoutTest();
		Checkout.testCheckoutProcess();
	}
}
