package lumaTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            String reportPath = "./target/Extent-Report.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            // Set system details
            extent.setSystemInfo("Tester", "Your Name");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }
        return extent;
    }

    public static ExtentTest createTest(String testName) {
        if(extent == null) {
        	getReportInstance();
        }
    	
    	test = extent.createTest(testName);
        return test;
    }

    public static void logInfo(String message) {
        if (test != null) {
            test.info(message);
        }
    }

    public static void logPass(String message) {
        if (test != null) {
            test.pass(message);
        }
    }

    public static void logFail(String message) {
        if (test != null) {
            test.fail(message);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}






































//package lumaTestNG;
// 
// 
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
// 
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// 
// 
//public class ExtentReportManager {
//	public static ExtentReports extent;
//	public static ExtentTest test;
//	private static ExtentSparkReporter spark;
//	WebDriver driver;
//	@BeforeClass
//	public static void startTest()
//	{
//		spark = new ExtentSparkReporter("./target/Extent-Report.html");
//		extent = new ExtentReports();
//		extent.attachReporter(spark);
//	}
//	@Test
//	public void extentReportsDemo() throws InterruptedException
//	{
//		//System.setProperty("webdriver.chrome.driver", "D:SubmittalExchange_TFSQAAutomation3rdpartychromechromedriver.exe");
//		driver = new FirefoxDriver();
//		test = extent.createTest("LoginPage");
//		driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
//		Thread.sleep(3000);
//		test.log(Status.INFO, "Login Page");
//		try
//		{
//			if(driver.getTitle().equals("Customer Login"))
//			{
//				test.log(Status.PASS, "Navigated to the specified URL");
//				//test.log(Status.INFO, "Taken the screen shot");
//			}
//			else
//			{
//				test.log(Status.FAIL, "Test Failed");
//			}
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			Thread.sleep(3000);
//			driver.quit();
//		}
//	}
//	
//	@AfterClass
//	public static void endTest()
//	{
//		//extent.endTest(test);
//		extent.flush();
// 
//	}
//}