import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features" ,
plugin = {"html:target/cucumber/wekipedia.html"} ,
        monochrome = true ,
        snippets = SnippetType.CAMELCASE ,
        glue = "java"
)

public class test1 {

}