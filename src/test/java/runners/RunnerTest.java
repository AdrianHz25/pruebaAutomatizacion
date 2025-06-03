package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        plugin = {
                "pretty",
                "html:target/build/cucumber-html-report",
                "pretty:target/build/cucumber-pretty.txt"
        },
        features = {"src/test/resources/features"},
        glue = {"stepDefinition"},
        tags = "@MercadoLibre",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class RunnerTest {
}
