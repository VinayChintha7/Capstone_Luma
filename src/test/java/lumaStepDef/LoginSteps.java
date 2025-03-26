package lumaStepDef;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import lumaBase.BaseClass;
import lumaPages.LoginPage;
import lumaTestNG.ExtentReportManager;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    ExtentTest test;

    @Given("the user is on the login page")
    public void user_is_on_login_page() {
    	test = ExtentReportManager.createTest("Login Test");
        driver = BaseClass.getDriver();  // Get driver from BaseClass
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        loginPage = new LoginPage(driver);
        test.log(Status.INFO,"Navigated to login page");
    }

    @When("the user enters a valid {string} and {string}")
    public void enter_valid_credentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        test.log(Status.INFO, "Entered valid credentials");
    }

    @And("clicks the login button")
    public void click_login_button() {
        loginPage.clickLogin();
        test.log(Status.INFO, "Clicked login button");
    }

    @Then("the user should be redirected to the account dashboard")
    public void verify_account_dashboard() {
    	 String expectedTitle = "My Account";
         try {
             Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Login failed!");
             test.log(Status.PASS, "User successfully logged in");
         } catch (AssertionError e) {
             test.log(Status.FAIL, "Login failed: " + e.getMessage());
             throw e;
         } finally {
             ExtentReportManager.flushReport();
         }
    	
//        String expectedTitle = "My Account";
//        Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Login failed!");
    }
}
