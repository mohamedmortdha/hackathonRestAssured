package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/backUp/ObjectScope/simpleBackUpAllNotCreateableObject.feature"},
        glue = {"steps"},
        plugin = {"json:target/cucumberTest2.json", "pretty",
                "html:target/cucumber-reports"}



)
public class JobsRunnerTest2 {

}
