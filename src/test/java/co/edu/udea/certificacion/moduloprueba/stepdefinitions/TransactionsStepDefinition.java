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
    public final Actor actor = Actor.named("User");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config() {
        actor.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }


    @When("I transfer money from Savings to Checking")
    public void iTransferMoneyFromSavingsToChecking() {
        actor.attemptsTo(
            SelectOption.byText("SAVINGS", TransferFundsPage.FROM_ACCOUNT_DROPDOWN),
            SelectOption.byText("CHECKING", TransferFundsPage.TO_ACCOUNT_DROPDOWN),
            EnterValue.intoField("100", TransferFundsPage.AMOUNT_INPUT),
            ClickOnTarget.element(TransferFundsPage.TRANSFER_BUTTON)
        );
    }

    @Then("the system confirms the transfer")
    public void systemConfirmsTransfer() {
        actor.should(seeThat(ValidateTransfer.transferCompleted(), containsString("Transfer Complete")));
    }

    @Then("the balances are updated")
    public void balancesAreUpdated() {
        actor.should(seeThat(ValidateTransfer.transferCompleted(), containsString("successfully")));
    }

    @When("I attempt to transfer more money than I have")
    public void iAttemptToTransferMoreThanAvailable() {
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        WebElement fromAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='fromAccountId']")));
        WebElement toAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='toAccountId']")));
        if (!fromAccountElement.getTagName().equalsIgnoreCase("select") || !toAccountElement.getTagName().equalsIgnoreCase("select")) {
            throw new RuntimeException("Dropdown is not a <select> element");
        }
        Select fromAccountSelect = new Select(fromAccountElement);
        Select toAccountSelect = new Select(toAccountElement);
        String fromAccount = fromAccountSelect.getOptions().get(0).getText();
        String toAccount = toAccountSelect.getOptions().size() > 1 ? toAccountSelect.getOptions().get(1).getText() : toAccountSelect.getOptions().get(0).getText();
        actor.attemptsTo(
            SelectOption.byText(fromAccount, TransferFundsPage.FROM_ACCOUNT_DROPDOWN),
            SelectOption.byText(toAccount, TransferFundsPage.TO_ACCOUNT_DROPDOWN),
            EnterValue.intoField("999999", TransferFundsPage.AMOUNT_INPUT),
            ClickOnTarget.element(TransferFundsPage.TRANSFER_BUTTON)
        );
    }


    @Given("I have completed a transfer")
    public void iHaveCompletedATransfer() {
        WebDriverWait wait = new WebDriverWait(theDriver, Duration.ofSeconds(10));
        WebElement fromAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='fromAccountId']")));
        WebElement toAccountElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='toAccountId']")));
        if (!fromAccountElement.getTagName().equalsIgnoreCase("select") || !toAccountElement.getTagName().equalsIgnoreCase("select")) {
            throw new RuntimeException("Dropdown is not a <select> element");
        }
        Select fromAccountSelect = new Select(fromAccountElement);
        Select toAccountSelect = new Select(toAccountElement);
        String fromAccount = fromAccountSelect.getOptions().get(0).getText();
        String toAccount = toAccountSelect.getOptions().size() > 1 ? toAccountSelect.getOptions().get(1).getText() : toAccountSelect.getOptions().get(0).getText();
        actor.attemptsTo(
            SelectOption.byText(fromAccount, TransferFundsPage.FROM_ACCOUNT_DROPDOWN),
            SelectOption.byText(toAccount, TransferFundsPage.TO_ACCOUNT_DROPDOWN),
            EnterValue.intoField("100", TransferFundsPage.AMOUNT_INPUT),
            ClickOnTarget.element(TransferFundsPage.TRANSFER_BUTTON)
        );
    }

    @When("I access the transaction history")
    public void iAccessTransactionHistory() {
        actor.attemptsTo(
            ClickOnTarget.element(TransactionHistoryPage.ACCOUNT_NUMBER_LINK),
            SelectOption.byText("All", TransactionHistoryPage.ACTIVITY_PERIOD_SELECT),
            SelectOption.byText("All", TransactionHistoryPage.TYPE_SELECT),
            ClickOnTarget.element(TransactionHistoryPage.GO_BUTTON)
        );
    }

    @Then("the system shows the recorded movement")
    public void systemShowsRecordedMovement() {
        actor.should(seeThat(ValidateTransactionHistory.tableContent(), not(isEmptyOrNullString())));
    }
}
