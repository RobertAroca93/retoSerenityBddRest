package co.com.sofka.questions;

import co.com.sofka.model.create.CreateUser;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class postCreateQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(CreateUser.class);
    }
}
