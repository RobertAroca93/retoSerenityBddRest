package co.com.sofka.tasks;

import co.com.sofka.model.create.CreateUserReqres;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostCreate implements Task {

    private String resource;
    private CreateUserReqres create;



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(resource)
                        .with(
                                requestSpecification -> requestSpecification.relaxedHTTPSValidation()
                                        .contentType(ContentType.JSON)
                                        .body(create)
                        )
        );

    }

    public PostCreate usingResource(String resource) {
        this.resource = resource;
        return this;
    }

    public PostCreate withBodyRequest (CreateUserReqres create) {
        this.create = create;
        return this;
    }

    public static PostCreate postCreate(){
        return new PostCreate();
    }
}

