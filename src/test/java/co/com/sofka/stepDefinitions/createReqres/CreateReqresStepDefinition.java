package co.com.sofka.stepDefinitions.createReqres;

import co.com.sofka.model.create.CreateUserReqres;
import co.com.sofka.questions.reqres.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static co.com.sofka.tasks.PostCreate.postCreate;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

    public class CreateReqresStepDefinition {
    public static final Logger LOGGER = Logger.getLogger(CreateReqresStepDefinition.class);


    private final String restApiUrl= "https://reqres.in/";
    private final String resource = "api/users";

    CreateUserReqres create;
    Actor Robert = Actor.named("Robert the student");



    @Given("cuando el usuario hace un peticion create")
    public void cuandoElUsuarioHaceUnPeticionCreate() {

                Robert.whoCan(CallAnApi.at(restApiUrl));



    }
    @When("el usuario hace la peticion con el name {string} y el job {string}")
    public void  elUsuarioHaceLaPeticionConElNameYElJob(String morpheus, String leader){
        create =  new CreateUserReqres();
        create.setName(morpheus);
        create.setJob(leader);
        Robert.attemptsTo(postCreate().usingResource(resource).withBodyRequest(create)
        );

    }
    @Then("el usuario debera ver el codigo de respuesta exitosa")
    public void elUsuarioDeberaVerElCodigoDeRespuestaExitosa() {
        Robert.should(seeThat("el codigo de respuesta exitoso", new ResponseCode(),
                equalTo(HttpStatus.SC_CREATED))
        );

    }
    //segundo escenario

    @Given("dado que el usuario hace una peticion create")
    public void dado_que_el_usuario_hace_una_peticion_create() {
        Robert.whoCan(CallAnApi.at(restApiUrl));

    }


    @When("el usuario realiza el create solo con el name {string}")
    public void el_usuario_realiza_el_create_solo_con_el_name(String morpheus) {
        create =  new CreateUserReqres();
        create.setName(morpheus);
        Robert.attemptsTo(postCreate().usingResource(resource).withBodyRequest(create)
        );

    }


    @Then("el usuario debera ver tambien el codigo de respuesta exitoso")
    public void el_usuario_debera_ver_tambien_el_codigo_de_respuesta_fallido() {
        Robert.should(seeThat("el codigo de respuesta exitoso", new ResponseCode(),
                equalTo(HttpStatus.SC_CREATED))
        );

    }


}
