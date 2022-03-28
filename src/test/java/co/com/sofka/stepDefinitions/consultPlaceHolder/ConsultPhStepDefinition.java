package co.com.sofka.stepDefinitions.consultPlaceHolder;

import co.com.sofka.model.create.ConsultPostPlaceHolder;
import co.com.sofka.questions.reqres.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ConsultPhStepDefinition {

    public static final Logger LOGGER = Logger.getLogger(ConsultPhStepDefinition.class);
    private final String restApiUrl= "https://jsonplaceholder.typicode.com";
    private final String resource = "/posts";
    private final String Id ="/?user=2";


    ConsultPostPlaceHolder consult ;
    Actor Robert = Actor.named("Robert the student");


    @Given("dado que me encuentro en la pagina web")
    public void dado_que_me_encuentro_en_la_pagina_web() {
        Robert.whoCan(CallAnApi.at(restApiUrl));

    }

    @When("deseo hacer la consulta de los post realizados")
    public void deseo_hacer_la_consulta_de_los_post_realizados() {
        Robert.attemptsTo(Get.resource(resource)
                .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))

        );

    }
    @Then("el usuario debera ver el codigo de respuesta exitoso")
    public void el_usuario_debera_ver_el_codigo_de_respuesta_exitoso() {
        Robert.should(
                seeThat("el codigo de respuesta exitoso", new ResponseCode(),
                        equalTo(HttpStatus.SC_OK))
        );

    }
    //segundo escenario

    @Given("dado que me encuentro dentro de la pagina web")
    public void dado_que_me_encuentro_dentro_de_la_pagina_web() {
        Robert.whoCan(CallAnApi.at(restApiUrl));

    }
    @When("deseo hacer la consulta de la informacion del userId2")
    public void deseo_hacer_la_consulta_de_la_informacion_del_userId2() {
        Robert.attemptsTo(Get.resource(resource + Id)
                .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))

        );

    }
    @Then("el usuario debera ver el codigo de respuesta correcta")
    public void el_usuario_debera_ver_el_codigo_de_respuesta_correcta() {
        Robert.should(
                seeThat("el codigo de respuesta exitoso", new ResponseCode(),
                        equalTo(HttpStatus.SC_OK))
        );


    }

}
