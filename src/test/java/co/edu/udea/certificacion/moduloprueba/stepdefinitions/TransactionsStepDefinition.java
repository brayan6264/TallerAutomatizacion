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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;
import static org.hamcrest.Matchers.*;
import static net.serenitybdd.screenplay.GivenWhenThen.*;

public class TransactionsStepDefinition {
    private Actor actor;
    private WebDriver theDriver;

    @Before(order = 1)
    public void setUp() {
        actor = OnStage.theActorInTheSpotlight();
        theDriver = BrowseTheWeb.as(actor).getDriver();
    }


    @When("I transfer money from Savings to Checking")
    public void iTransferMoneyFromSavingsToChecking() {
        actor.attemptsTo(
            ClickOnTarget.element(TransferFundsPage.TRANSFER_FUNDS_LINK)
        );
        
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromAccountId")));
        
        WebElement fromAccountElement = theDriver.findElement(By.id("fromAccountId"));
        WebElement toAccountElement = theDriver.findElement(By.id("toAccountId"));
        Select fromAccountSelect = new Select(fromAccountElement);
        Select toAccountSelect = new Select(toAccountElement);
        
        String fromAccount = fromAccountSelect.getOptions().get(0).getText();
        String toAccount = toAccountSelect.getOptions().size() > 1 ? 
            toAccountSelect.getOptions().get(1).getText() : 
            toAccountSelect.getOptions().get(0).getText();
        
        actor.attemptsTo(
            EnterValue.intoField("100", TransferFundsPage.AMOUNT_INPUT),
            SelectOption.byText(fromAccount, TransferFundsPage.FROM_ACCOUNT_DROPDOWN),
            SelectOption.byText(toAccount, TransferFundsPage.TO_ACCOUNT_DROPDOWN),
            ClickOnTarget.element(TransferFundsPage.TRANSFER_BUTTON)
        );
    }

    @Then("I saw the confirmation transfer")
    public void systemConfirmsTransfer() {
        actor.should(seeThat(ValidateTransfer.transferCompleted(), containsString("Transfer Complete")));
    }


    @When("I attempt to transfer more money than I have")
    public void iAttemptToTransferMoreThanAvailable() {
        actor.attemptsTo(
            ClickOnTarget.element(TransferFundsPage.TRANSFER_FUNDS_LINK)
        );
        
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromAccountId")));
        
        WebElement fromAccountElement = theDriver.findElement(By.id("fromAccountId"));
        WebElement toAccountElement = theDriver.findElement(By.id("toAccountId"));
        Select fromAccountSelect = new Select(fromAccountElement);
        Select toAccountSelect = new Select(toAccountElement);
        
        String fromAccount = fromAccountSelect.getOptions().get(0).getText();
        String toAccount = toAccountSelect.getOptions().size() > 1 ? 
            toAccountSelect.getOptions().get(1).getText() : 
            toAccountSelect.getOptions().get(0).getText();
        
        actor.attemptsTo(
            EnterValue.intoField("999999", TransferFundsPage.AMOUNT_INPUT),
            SelectOption.byText(fromAccount, TransferFundsPage.FROM_ACCOUNT_DROPDOWN),
            SelectOption.byText(toAccount, TransferFundsPage.TO_ACCOUNT_DROPDOWN),
            ClickOnTarget.element(TransferFundsPage.TRANSFER_BUTTON)
        );
    }

    @Then("I saw the result")
    public void systemShowsResult() {
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.id("showResult")),
            ExpectedConditions.visibilityOfElementLocated(By.id("showError"))
        ));
    }


    @Given("I have completed a transfer")
    public void iHaveCompletedATransfer() {
        actor.attemptsTo(
            ClickOnTarget.element(TransferFundsPage.TRANSFER_FUNDS_LINK)
        );
        
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromAccountId")));
        
        WebElement fromAccountElement = theDriver.findElement(By.id("fromAccountId"));
        WebElement toAccountElement = theDriver.findElement(By.id("toAccountId"));
        Select fromAccountSelect = new Select(fromAccountElement);
        Select toAccountSelect = new Select(toAccountElement);
        
        String fromAccount = fromAccountSelect.getOptions().get(0).getText();
        String toAccount = toAccountSelect.getOptions().size() > 1 ? 
            toAccountSelect.getOptions().get(1).getText() : 
            toAccountSelect.getOptions().get(0).getText();
        
        actor.attemptsTo(
            EnterValue.intoField("100", TransferFundsPage.AMOUNT_INPUT),
            SelectOption.byText(fromAccount, TransferFundsPage.FROM_ACCOUNT_DROPDOWN),
            SelectOption.byText(toAccount, TransferFundsPage.TO_ACCOUNT_DROPDOWN),
            ClickOnTarget.element(TransferFundsPage.TRANSFER_BUTTON)
        );
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showResult")));
    }

    @When("I access the transaction history")
    public void iAccessTransactionHistory() {
        actor.attemptsTo(
            ClickOnTarget.element(TransactionHistoryPage.ACCOUNTS_OVERVIEW_LINK)
        );
        
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("accountTable")));
        
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//table[@id='accountTable']//tr"), 1));
        
        actor.attemptsTo(
            ClickOnTarget.element(TransactionHistoryPage.ACCOUNT_NUMBER_LINK)
        );
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("month")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("month")));
        
        actor.attemptsTo(
            SelectOption.byText("All", TransactionHistoryPage.ACTIVITY_PERIOD_SELECT),
            SelectOption.byText("All", TransactionHistoryPage.TYPE_SELECT),
            ClickOnTarget.element(TransactionHistoryPage.GO_BUTTON)
        );
    }

    @Then("I saw  the recorded movement")
    public void systemShowsRecordedMovement() {
        actor.should(seeThat(ValidateTransactionHistory.tableContent(), not(isEmptyOrNullString())));
    }
}
