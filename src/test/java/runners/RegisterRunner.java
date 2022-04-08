package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/register.feature",
        glue = "stepsdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RegisterRunner {
}
