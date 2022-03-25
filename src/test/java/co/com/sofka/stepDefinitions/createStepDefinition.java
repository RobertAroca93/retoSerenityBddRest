package co.com.sofka.stepDefinitions;

import co.com.sofka.model.create.CreateUser;
import co.com.sofka.questions.respondeCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static co.com.sofka.tasks.PostCreate.postCreate;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class createStepDefinition {
    public static final Logger LOGGER = Logger.getLogger(createStepDefinition.class);
    private Response response;
    private RequestSpecification request;




    private final String restApiUrl= "https://reqres.in/";
    private final String resource = "api/users";

    CreateUser create;
    Actor Robert = Actor.named("Robert the student");



    @Given("cuando el usuario hace un peticion create")
    public void cuandoElUsuarioHaceUnPeticionCreate() {

                Robert.whoCan(CallAnApi.at(restApiUrl));



    }
    @When("el usuario hace la peticion con el name {string} y el job {string}")
    public void  elUsuarioHaceLaPeticionConElNameYElJob(String name, String job){
        create =  new CreateUser();
        create.setName(name);
        create.setJob(job);
        Robert.attemptsTo(postCreate().usingResource(resource).withBodyRequest(create)
        );


    }
    @Then("el usuario debera ver el codigo de respuesta exitosa")
    public void elUsuarioDeberaVerElCodigoDeRespuestaExitosa() {
        Robert.should(seeThat("el codigo de respuesta exitoso", new respondeCode(), equalTo(HttpStatus.SC_CREATED))
        );

    }

}
