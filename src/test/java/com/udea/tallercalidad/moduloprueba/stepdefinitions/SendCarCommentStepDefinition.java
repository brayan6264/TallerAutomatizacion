package com.udea.tallercalidad.moduloprueba.stepdefinitions;

import com.udea.tallercalidad.moduloprueba.questions.ValidateComment;
import com.udea.tallercalidad.moduloprueba.tasks.FillTheLogin;
import com.udea.tallercalidad.moduloprueba.tasks.Generate;
import com.udea.tallercalidad.moduloprueba.tasks.OpenThe;
import com.udea.tallercalidad.moduloprueba.tasks.SelectThe;
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

public class SendCarCommentStepDefinition {
    public final Actor buyer = Actor.named("Juanito");
    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        buyer.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }
    @Given("I am viewing the details of a selected car")
    public void iAmViewingTheDetailsOfASelectedCar() {
        buyer.attemptsTo(OpenThe.navigator(new BuggyPage()));
        buyer.attemptsTo(FillTheLogin.userForm());
        buyer.attemptsTo(SelectThe.lamborghiniCar());
    }
    @When("I submit a comment about that car")
    public void iSubmitACommentAboutThatCar() {
        buyer.attemptsTo(Generate.theComment());
    }
    @Then("the system should confirm that my comment was successfully saved")
    public void theSystemShouldConfirmThatMyCommentWasSuccessfullySaved() {
        buyer.should(
                seeThat(ValidateComment.savedComment(), equalTo("Renteria hermoso"))
        );
    }
}
