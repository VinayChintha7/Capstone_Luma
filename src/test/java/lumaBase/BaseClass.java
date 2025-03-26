package lumaBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.google.common.io.Files;

import lumaUtils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {
    protected static WebDriver driver;
    
    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("firefox") String browser) {
    	System.out.println("Launching a browser.");
//        String browser = ConfigReader.getProperty("browser");

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name in config file: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Waiting for the browser to load.
        driver.manage().window().maximize(); //maximising the browser window(for chrome).
    }
    
    
    @AfterClass
    public void tearDown() {
    	System.out.println("Closing the browser.");//closing the browser
        driver.close();
        
    }
    //taking screenshot
    public static void screenshot() throws IOException
  	{
    	
  		//Take the screenshot as proof
  		File src=null;
  		src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  		Files.copy(src, new File("./screenshots/"+"page-"+System.currentTimeMillis()+".png"));
  	}
    
    
    
    //Added only for Bdd Cucumber
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
//to here
    
}

