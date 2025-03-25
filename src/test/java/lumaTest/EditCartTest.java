package lumaTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import lumaBase.BaseClass;
import lumaPages.EditCartPage;
import lumaTestNG.ExtentReportManager;

public class EditCartTest extends BaseClass{
	EditCartPage editCartPage;

	@Test(priority = 4, dependsOnMethods = "lumaTest.testSearchAndAddToCart.testSearchAndAddToCart")
    public void editCart() throws InterruptedException {
    	
    	ExtentTest test = ExtentReportManager.getReportInstance().createTest("Edit cart Test.");
    	
    	driver.get("https://magento.softwaretestingboard.com/");
    	test.info("Navigating to cart...");
    	editCartPage = new EditCartPage(driver);
        
        test.info("Editing the items count in the cart.");
        editCartPage.editCount();
        test.pass("Successfully edited to cart items count.");

   
        ExtentReportManager.flushReport();
    }
	

}
