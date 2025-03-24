package lumaTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import lumaBase.BaseClass;
import lumaPages.LoginPage;
import lumaTestNG.ExtentReportManager;
import lumaUtils.ExcelUtil;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    ExcelUtil excelReader = new ExcelUtil("C:\\Users\\Dinesh\\eclipse-workspace\\LumaTestAutomation\\src\\test\\resources\\LoginDataExcel.xslx");
    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() {
        int rows = excelReader.getRowCount("Sheet1");
        Object[][] data = new Object[rows][2];

        for (int i = 1; i <= rows; i++) {  // Skip header row
            data[i - 1][0] = excelReader.getCellData("Sheet1", i, 0); // Email
            data[i - 1][1] = excelReader.getCellData("Sheet1", i, 1); // Password
        }
        return data;
    }

//    @Test(priority = 2,dependsOnMethods = "testRegistration" ,dataProvider = "LoginData")  // Runs after Registration (priority 1)
//    @Test(priority = 2,dataProvider = "LoginData")
    public void testLogin(String email, String password) throws IOException {
        ExtentTest test = ExtentReportManager.getReportInstance().createTest("Login Test for : "+ email);
    	
    	
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        test.info("Navigated to Login Page.");
        loginPage = new LoginPage(driver);

        loginPage.loginUser(email, password);
        test.info("Entered credentials and clicked login");

        // Validate login success
        try {
        	if(driver.getCurrentUrl().contains("customer/account")){
        		test.pass("Login Successful for "+email);
        	}else if(loginPage.getErrorMessage().contains("The account sign-in was incorrect")) {
        		test.fail("Login failed for "+email+"-Incorrect credentials.");
        	}
        	Assert.assertTrue(driver.getCurrentUrl().contains("customer/account") || 
                          loginPage.getErrorMessage().contains("The account sign-in was incorrect"));
        }catch(Exception e) {
        	test.fail("Test failed due to exception.");
        }
        
        ExtentReportManager.flushReport();
    }
}



