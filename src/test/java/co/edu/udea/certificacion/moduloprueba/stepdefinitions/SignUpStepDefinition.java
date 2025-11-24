package co.edu.udea.certificacion.moduloprueba.stepdefinitions;

import co.edu.udea.certificacion.moduloprueba.tasks.*;
import co.edu.udea.certificacion.moduloprueba.questions.*;
import co.edu.udea.certificacion.moduloprueba.userinterfaces.*;
import co.edu.udea.certificacion.moduloprueba.interactions.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import java.time.Instant;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class SignUpStepDefinition {
    public final Actor actor = Actor.named("User");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config() {
        actor.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    @Given("I am on the Parabank registration page")
    public void iAmOnTheRegistrationPage() {
        theDriver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I complete the registration with valid information")
    public void iCompleteRegistrationWithValidInformation() {
        String uniqueUsername = "usuarioPrueba" + Instant.now().getEpochSecond();
        actor.attemptsTo(
            ClickOnTarget.element(RegistrationPage.REGISTER_LINK),
            EnterValue.intoField("Juan", RegistrationPage.FIRST_NAME_INPUT),
            EnterValue.intoField("Perez", RegistrationPage.LAST_NAME_INPUT),
            EnterValue.intoField("Calle 123", RegistrationPage.ADDRESS_INPUT),
            EnterValue.intoField("Medellin", RegistrationPage.CITY_INPUT),
            EnterValue.intoField("Antioquia", RegistrationPage.STATE_INPUT),
            EnterValue.intoField("050001", RegistrationPage.ZIP_CODE_INPUT),
            EnterValue.intoField("3001234567", RegistrationPage.PHONE_INPUT),
            EnterValue.intoField("123456789", RegistrationPage.SSN_INPUT),
            EnterValue.intoField(uniqueUsername, RegistrationPage.USERNAME_INPUT),
            EnterValue.intoField("Password123.", RegistrationPage.PASSWORD_INPUT),
            EnterValue.intoField("Password123.", RegistrationPage.CONFIRM_PASSWORD_INPUT),
            ClickOnTarget.element(RegistrationPage.REGISTER_BUTTON)
        );
    }

    @Then("the system confirms that the account was created successfully")
    public void systemConfirmsAccountCreated() {
        actor.should(seeThat(ValidateRegistration.registrationMessage(), containsString("Welcome")));
    }

    @When("I complete the registration with mismatched passwords")
    public void iCompleteRegistrationWithMismatchedPasswords() {
        actor.attemptsTo(
            ClickOnTarget.element(RegistrationPage.REGISTER_LINK),
            EnterValue.intoField("Juan", RegistrationPage.FIRST_NAME_INPUT),
            EnterValue.intoField("Perez", RegistrationPage.LAST_NAME_INPUT),
            EnterValue.intoField("Calle 123", RegistrationPage.ADDRESS_INPUT),
            EnterValue.intoField("Medellin", RegistrationPage.CITY_INPUT),
            EnterValue.intoField("Antioquia", RegistrationPage.STATE_INPUT),
            EnterValue.intoField("050001", RegistrationPage.ZIP_CODE_INPUT),
            EnterValue.intoField("3001234567", RegistrationPage.PHONE_INPUT),
            EnterValue.intoField("123456789", RegistrationPage.SSN_INPUT),
            EnterValue.intoField("usuarioPrueba", RegistrationPage.USERNAME_INPUT),
            EnterValue.intoField("Password123.", RegistrationPage.PASSWORD_INPUT),
            EnterValue.intoField("DifferentPassword", RegistrationPage.CONFIRM_PASSWORD_INPUT),
            ClickOnTarget.element(RegistrationPage.REGISTER_BUTTON)
        );
    }

    @Then("the system shows the result")
    public void systemShowsResult() {
        actor.should(seeThat(ValidateRegistrationError.errorMessage(), not(isEmptyOrNullString())));
    }
}
