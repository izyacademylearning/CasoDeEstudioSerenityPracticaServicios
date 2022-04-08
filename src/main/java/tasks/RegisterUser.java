package tasks;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class RegisterUser implements Task {
    private final String userInfo;

    public RegisterUser(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register")
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo))
        );
    }

    public static RegisterUser registerUser(String userInfo) {
        return Tasks.instrumented(RegisterUser.class, userInfo);
    }
}
