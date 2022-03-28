package co.com.sofka.runners.consultPlaceHolder;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/consultPlaceHolder.feature"},
        glue = {"co.com.sofka.stepDefinitions.consultPlaceHolder"}
)
public class ConsutlPlaceHolderTest {
}
