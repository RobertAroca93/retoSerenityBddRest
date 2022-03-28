package co.com.sofka.questions.reqres;

import co.com.sofka.model.create.CreateUserReqres;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PostCreateQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(CreateUserReqres.class);
    }
}
