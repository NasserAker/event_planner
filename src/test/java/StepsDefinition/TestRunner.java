package StepsDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        plugin = {"html:target/cucumber/wikipedia.html"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"StepsDefinition"},
      tags = "@raya"

)

public final class TestRunner {
}
