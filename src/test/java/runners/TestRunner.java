package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        plugin = {"pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"},
        tags = "@regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
