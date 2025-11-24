package co.edu.udea.certificacion.moduloprueba.tasks;

import co.edu.udea.certificacion.moduloprueba.userinterfaces.TransferFundsPage;
import co.edu.udea.certificacion.moduloprueba.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Click;

public class TransferFundsTask implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            ClickOnTarget.element(TransferFundsPage.TRANSFER_FUNDS_LINK),
            SelectOption.byText("SAVINGS", TransferFundsPage.FROM_ACCOUNT_DROPDOWN),
            SelectOption.byText("CHECKING", TransferFundsPage.TO_ACCOUNT_DROPDOWN),
            EnterValue.intoField("100", TransferFundsPage.AMOUNT_INPUT),
            ClickOnTarget.element(TransferFundsPage.TRANSFER_BUTTON)
        );
    }

    public static TransferFundsTask transferForm() {
        return Tasks.instrumented(TransferFundsTask.class);
    }
}
