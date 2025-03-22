package lumaTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import lumaBase.BaseClass;
import lumaPages.CheckoutPage;

public class CheckoutTest extends BaseClass {

    @Test(priority = 1)
    public void testCheckoutProcess() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Step 1: Click on Cart and Proceed to Checkout
        checkoutPage.proceedToCheckout();

        // Step 2: Enter Shipping Details
        checkoutPage.enterShippingDetails("V", "K", "Hafeezpet", "Hyderabad","India","Telangana", "90001", "9876543210");

        // Step 3: Select Shipping Method and Continue
        checkoutPage.selectShippingAndContinue();

        // Step 4: Place Order
        checkoutPage.placeOrder();

        // Step 5: Verify Order Success
        Assert.assertTrue(checkoutPage.isOrderSuccessful(), "Order Placement Failed!");
    }
}
