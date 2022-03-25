package co.com.sofka.runners.createReqres;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;



@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/create.feature"},
        glue = {"co.com.sofka.stepDefinitions"}
)
public class createTest {

}

