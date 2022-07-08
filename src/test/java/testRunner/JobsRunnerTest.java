package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // features = {"src/test/java/features/nextGen/SalesForceApiData&File.feature"},
        features = {"src/test/java/features/product.feature"},
        glue = {"steps"},
        plugin = {"json:target/cucumberTest.json", "pretty",
                "html:target/cucumber-reports.html"}
)
public class JobsRunnerTest {
}
