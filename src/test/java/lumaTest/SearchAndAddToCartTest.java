package lumaTest;

import lumaBase.BaseClass;
import lumaPages.SearchAndAddToCartPage;
import lumaTestNG.ExtentReportManager;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

public class SearchAndAddToCartTest extends BaseClass {
    SearchAndAddToCartPage searchPage;

    @Test(priority = 3, dependsOnMethods = "lumaTest.LoginPageTest.testLogin")
    public void testSearchAndAddToCart() throws InterruptedException {
    	
    	ExtentTest test = ExtentReportManager.getReportInstance().createTest("Search and Add to cart Test.");
    	
    	driver.get("https://magento.softwaretestingboard.com/");
        searchPage = new SearchAndAddToCartPage(driver);
        
        test.info("Navigating to Jackets section...");
        searchPage.navigateToJackets();
        test.info("Successfully navigated to Jackets section.");

        test.info("Selecting Jupiter All-Season Jacket and adding to cart...");
        searchPage.addJupiterJacketToCart();
        test.pass("Jacket added to cart Successfully.");
   
        ExtentReportManager.flushReport();
    }
}
