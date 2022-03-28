package co.com.sofka.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetConsult implements Task {

    private String resource;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(resource)
        );
    }
    public GetConsult usingResource (String resource){
        this.resource = resource;
        return this;
    }
    public static GetConsult getConsult(){
        return new GetConsult();
    }
}
