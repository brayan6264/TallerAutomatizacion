package com.udea.tallercalidad.moduloprueba.stepdefinitions;

import com.udea.tallercalidad.moduloprueba.questions.ValidateSignIn;
import com.udea.tallercalidad.moduloprueba.tasks.FillTheLogin;
import com.udea.tallercalidad.moduloprueba.tasks.OpenThe;
import com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class SignInStepDefinition {
    public final Actor buyer = Actor.named("Juanito");
    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        buyer.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }
    @Given("I am on the BuggyCars platform")
    public void iAmOnTheBuggyCarsPlatform() {
        buyer.attemptsTo(OpenThe.navigator(new BuggyPage()));
    }

    @When("I provide valid credentials to access my account")
    public void iProvideValidCredentialsToAccessMyAccount() {
        buyer.attemptsTo(FillTheLogin.userForm());
    }

    @Then("The system allows me to log in as a user")
    public void theSystemAllowsMeToLogInAsAUser() {
        buyer.should(
                seeThat(ValidateSignIn.singInMessage(),
                        equalTo("Hi, Usuario"))
        );
    }
}
