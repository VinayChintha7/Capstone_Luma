package lumaTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import lumaBase.BaseClass;
import lumaPages.CheckoutPage;
import lumaTestNG.ExtentReportManager;

public class CheckoutTest extends BaseClass {
	private CheckoutPage checkoutPage;
	
    @Test(priority = 4)//,dependsOnMethods = "lumaTest.SearchAndAddToCartTest.testSearchAndAddToCart")
    public void testCheckoutProcess() throws InterruptedException, IOException {
    	
    	ExtentTest test = ExtentReportManager.getReportInstance().createTest("Going to cart and proceed to buy.");
        
    	checkoutPage = new CheckoutPage(driver);
    	
    	Thread.sleep(2000);
        // Step 1: Click on Cart and Proceed to Checkout
//        checkoutPage.proceedToCheckout();
        test.info("Clicking on cart and proceed to checkout");

        // Step 2: Enter Shipping Details
        checkoutPage.enterShippingDetails(" ", " ", "Hafeezpet", "Hyderabad","India","Telangana", "500084", "9876543210");
        test.info("Entered details for shipping.");

        // Step 3: Select Shipping Method and Continue
        checkoutPage.selectShippingAndContinue();

        // Step 4: Place Order
        checkoutPage.placeOrder();

        // Step 5: Verify Order Success
        Assert.assertTrue(checkoutPage.isOrderSuccessful(), "Order Placement Failed!");
        
//        screenshot();
        
        ExtentReportManager.flushReport();
    }
}
