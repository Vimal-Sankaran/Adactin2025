import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepDefinitions"},
        plugin = {"pretty,tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@TC01"
)
public class TestRunner {
}

