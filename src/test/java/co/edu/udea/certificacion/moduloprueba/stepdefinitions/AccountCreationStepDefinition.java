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
    private Actor actor;
    private WebDriver theDriver;

    @Before(order = 1)
    public void setUp() {
        actor = OnStage.theActorInTheSpotlight();
        theDriver = BrowseTheWeb.as(actor).getDriver();
    }

    @Given("I am logged into my Parabank account")
    public void iAmLoggedIntoMyAccount() {
        String currentUrl = theDriver.getCurrentUrl();
        System.out.println("Current URL before navigation: " + currentUrl);
        
        if (currentUrl == null || currentUrl.isEmpty() || !currentUrl.contains("parabank")) {
            return;
        }
        
        theDriver.get("https://parabank.parasoft.com/parabank/overview.htm");
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("overview.htm"));
        System.out.println("Navigated to: " + theDriver.getCurrentUrl());
    }

    @When("I request the creation of a Savings account")
    public void iRequestSavingsAccountCreation() {
        actor.attemptsTo(
            ClickOnTarget.element(AccountCreationPage.OPEN_NEW_ACCOUNT_LINK)
        );
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type")));
        
        actor.attemptsTo(
            SelectOption.byValue("1", AccountCreationPage.ACCOUNT_TYPE_DROPDOWN)
        );
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromAccountId")));
        WebElement fromAccountElement = theDriver.findElement(By.id("fromAccountId"));
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
            ClickOnTarget.element(AccountCreationPage.OPEN_NEW_ACCOUNT_LINK)
        );
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type")));
        
        actor.attemptsTo(
            SelectOption.byValue("0", AccountCreationPage.ACCOUNT_TYPE_DROPDOWN)
        );
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromAccountId")));
        WebElement fromAccountElement = theDriver.findElement(By.id("fromAccountId"));
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
