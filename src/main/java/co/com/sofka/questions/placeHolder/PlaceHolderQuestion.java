package co.com.sofka.questions.placeHolder;

import co.com.sofka.model.create.ConsultPostPlaceHolder;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PlaceHolderQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as( ConsultPostPlaceHolder.class);
    }
}
