package lumaStepDef;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import lumaBase.BaseClass;

@CucumberOptions(
    features = "C:\\Users\\Dinesh\\eclipse-workspace\\LumaTestAutomation2\\src\\test\\resources",
    glue = "lumaStepDef",
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
        BaseClass.getDriver();  // Start browser
    }

    @AfterClass
    public void teardown() {
        BaseClass.closeBrowser();  // Close browser
    }
}
