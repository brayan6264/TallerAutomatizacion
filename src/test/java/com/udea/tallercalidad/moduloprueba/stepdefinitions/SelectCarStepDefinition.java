package com.udea.tallercalidad.moduloprueba.stepdefinitions;

import com.udea.tallercalidad.moduloprueba.questions.ValidationSelectCar;
import com.udea.tallercalidad.moduloprueba.tasks.FillTheLogin;
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

public class SelectCarStepDefinition {
    public final Actor buyer = Actor.named("Juanito");
    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        buyer.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }


    @Given("I am logged into the BuggyCars platform")
    public void iAmLoggedIntoTheBuggyCarsPlatform() {
        buyer.attemptsTo(OpenThe.navigator(new BuggyPage()));
        buyer.attemptsTo(FillTheLogin.userForm());
    }

    @When("I choose a car from the catalog")
    public void iChooseACarFromTheCatalog() {
        buyer.attemptsTo(SelectThe.lamborghiniCar());
    }

    @Then("the system should display the details of the selected car")
    public void theSystemShouldDisplayTheDetailsOfTheSelectedCar() {
        buyer.should(
                seeThat(ValidationSelectCar.lamborghini(), equalTo("Lamborghini"))
        );
    }
}
