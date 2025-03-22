package lumaTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import lumaBase.BaseClass;
import lumaPages.RegistrationPage;
import lumaTestNG.ExtentReportManager;
import lumaUtils.ConfigReader;

public class RegistrationTest extends BaseClass {
	RegistrationPage registrationPage;
	ExtentTest test;

	@Test(priority = 1)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test to verify user Registration functionality")
	@Feature("User Registration")
	@Story("Register a new user with valid credentials")
	public void testRegistration() {
		ExtentReportManager.getReportInstance();
		test = ExtentReportManager.createTest("Registration Test");
		try {

			// Open the registration page
			test.info("Opening the registration page.");
			Allure.step("Opening Registration page.");
			driver.get(ConfigReader.getProperty("registration_url"));
			registrationPage = new RegistrationPage(driver);

			// Read user details from config.properties
			test.info("Reading the details from properties.");
			Allure.step("Reading details from config.properties");
			String firstName = ConfigReader.getProperty("firstname");
			String lastName = ConfigReader.getProperty("lastname");
			String email = ConfigReader.getProperty("email");
			String password = ConfigReader.getProperty("password");
			String confirmPassword = ConfigReader.getProperty("confirmPassword");

			// Perform registration
			test.info("Filling registration form.");
			Allure.step("Filling registration form with user credentials");
			registrationPage.registerUser(firstName, lastName, email, password, confirmPassword);
			test.pass("User created Successfully.");
			Allure.step("User registered successfully");
		} catch (Exception e) {
			test.fail("Registration test failed due to exception : ");
			Allure.addAttachment("Error",e.getMessage());
		}
		// flush the report
		ExtentReportManager.flushReport();
	}
}

