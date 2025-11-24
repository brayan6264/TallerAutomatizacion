package com.udea.tallercalidad.moduloprueba.stepdefinitions;

import com.udea.tallercalidad.moduloprueba.questions.ValidateSignUp;
import com.udea.tallercalidad.moduloprueba.tasks.FillTheRegister;
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

public class SignUpStepDefinition {
    public final Actor buyer = Actor.named("Juanito");
    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        buyer.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @When("I provide the necessary information to create a new account")
    public void iProvideTheNecessaryInformationToCreateANewAccount() {
        buyer.attemptsTo(FillTheRegister.userForm());
    }

    @Then("the system should confirm that my registration was completed successfully")
    public void theSystemShouldConfirmThatMyRegistrationWasCompletedSuccessfully() {
        buyer.should(
                seeThat(ValidateSignUp.registrationMessage(buyer), equalTo("Registration is successful"))
        );
    }

    @When("I attempt to create a new account using a username that already exists")
    public void iAttemptToCreateANewAccountUsingAUsernameThatAlreadyExists() {
        buyer.attemptsTo(FillTheRegister.userForm());
    }

    @Then("the system should notify me that the username is already taken")
    public void theSystemShouldNotifyMeThatTheUsernameIsAlreadyTaken() {
        buyer.should(
                seeThat(ValidateSignUp.usernameExist(buyer),
                        equalTo("UsernameExistsException: User already exists"))
        );
    }
}
