package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.Register;
import tasks.RegisterUser;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterStepDefinitions {

    private static final String restApiUrl = "https://reqres.in/api";
    Actor park = Actor.named("Park");


    @Given("Park nesecita registrase en la pagina")
    public void parkNesecitaRegistraseEnLaPagina() {
        park.whoCan(CallAnApi.at(restApiUrl));
    }

    @When("el envia la informacion para registrase")
    public void elEnviaLaInformacionParaRegistrase() {
        String info = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";
        park.attemptsTo(RegisterUser.registerUser(info));
    }

    @Then("su registro es exitoso")
    public void suRegistroEsExitoso() {
        park.should(GivenWhenThen.seeThat("el codigo de respuesta", Register.was(),equalTo(200)));
    }
}
