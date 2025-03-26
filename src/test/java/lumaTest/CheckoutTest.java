package lumaTest;

import java.io.IOException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import lumaBase.BaseClass;
import lumaPages.CheckoutPage;
import lumaTestNG.ExtentReportManager;

public class CheckoutTest extends BaseClass {
    private CheckoutPage checkoutPage;

    @Test(priority = 5)
    public void testCheckoutProcess() throws InterruptedException, IOException {
        ExtentTest test = ExtentReportManager.getReportInstance().createTest("Checkout Process");

        checkoutPage = new CheckoutPage(driver);
        
        try {
            // Step 1: Enter Shipping Details
            test.info("Entering shipping details...");
//            checkoutPage.enterShippingDetails(
//                "John", "Doe", "123 Main St", "New York", "United States", "New York", "10001", "9876543210"
//            );

            // Step 2: Select Shipping Method and Continue
            test.info("Selecting shipping method and proceeding...");
            checkoutPage.selectShippingAndContinue();

            // Step 3: Place Order
            test.info("Placing order...");
            checkoutPage.placeOrder();
            
            screenshot();

//             Step 4: Verify Order Success
            test.pass("Order Placed Successfully");
            checkoutPage.isOrderSuccessful();


        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
            throw e; // Rethrow for TestNG to log failure properly
        }

        ExtentReportManager.flushReport(); // Uncomment this if you're flushing the report manually
    }
}
