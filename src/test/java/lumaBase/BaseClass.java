package lumaBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import lumaUtils.ConfigReader;

import java.time.Duration;

public class BaseClass {
    protected static WebDriver driver;

    @BeforeClass
    public void setUp() {
    	System.out.println("Launching a browser.");
        String browser = ConfigReader.getProperty("browser");

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
    	System.out.println("Closing the browser.");
        driver.close();
        
    }
}

