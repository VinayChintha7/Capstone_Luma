package lumaTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "C:\\Users\\Dinesh\\eclipse-workspace\\LumaTestAutomation\\src\\test\\resources\\cart.feature",
    glue = "stepDef",
    plugin = {"pretty", "html:target/cucumber-reports/TestNGReport.html"},
    monochrome = true,
    tags = "@Cart"
)
public class cartRunner extends AbstractTestNGCucumberTests {
}
