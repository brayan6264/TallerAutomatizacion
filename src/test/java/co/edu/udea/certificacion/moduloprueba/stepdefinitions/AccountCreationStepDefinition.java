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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class AccountCreationStepDefinition {
    public final Actor actor = Actor.named("User");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config() {
        actor.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    @Given("I am logged into my Parabank account")
    public void iAmLoggedIntoMyAccount() {
        // Implementar login si es necesario
    }

    @When("I request the creation of a Savings account")
    public void iRequestSavingsAccountCreation() {
        actor.attemptsTo(
            ClickOnTarget.element(AccountCreationPage.OPEN_NEW_ACCOUNT_LINK),
            SelectOption.byText("SAVINGS", AccountCreationPage.ACCOUNT_TYPE_DROPDOWN)
        );
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        WebElement fromAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='fromAccountId']")));
        if (!fromAccountElement.getTagName().equalsIgnoreCase("select")) {
            throw new RuntimeException("FROM_ACCOUNT_DROPDOWN is not a <select> element");
        }
        Select fromAccountSelect = new Select(fromAccountElement);
        String firstAccountOption = fromAccountSelect.getOptions().get(0).getText();
        actor.attemptsTo(
            SelectOption.byText(firstAccountOption, AccountCreationPage.FROM_ACCOUNT_DROPDOWN),
            ClickOnTarget.element(AccountCreationPage.OPEN_ACCOUNT_BUTTON)
        );
    }

    @Then("the system confirms the creation of the Savings account")
    public void systemConfirmsSavingsAccountCreation() {
        actor.should(seeThat(ValidateAccountCreation.accountCreated(), containsString("Account Opened")));
    }

    @When("I request the creation of a Checking account")
    public void iRequestCheckingAccountCreation() {
        actor.attemptsTo(
            ClickOnTarget.element(AccountCreationPage.OPEN_NEW_ACCOUNT_LINK),
            SelectOption.byText("CHECKING", AccountCreationPage.ACCOUNT_TYPE_DROPDOWN)
        );
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        WebElement fromAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='fromAccountId']")));
        if (!fromAccountElement.getTagName().equalsIgnoreCase("select")) {
            throw new RuntimeException("FROM_ACCOUNT_DROPDOWN is not a <select> element");
        }
        Select fromAccountSelect = new Select(fromAccountElement);
        String firstAccountOption = fromAccountSelect.getOptions().get(0).getText();
        actor.attemptsTo(
            SelectOption.byText(firstAccountOption, AccountCreationPage.FROM_ACCOUNT_DROPDOWN),
            ClickOnTarget.element(AccountCreationPage.OPEN_ACCOUNT_BUTTON)
        );
    }

    @Then("the system confirms the creation of the Checking account")
    public void systemConfirmsCheckingAccountCreation() {
        actor.should(seeThat(ValidateAccountCreation.accountCreated(), containsString("Account Opened")));
    }
}
