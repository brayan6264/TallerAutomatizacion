package co.edu.udea.certificacion.moduloprueba.tasks;

import co.edu.udea.certificacion.moduloprueba.userinterfaces.AccountCreationPage;
import co.edu.udea.certificacion.moduloprueba.interactions.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountTask implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        Select fromAccountSelect = new Select(AccountCreationPage.FROM_ACCOUNT_DROPDOWN.resolveFor(actor));
        String firstAccountOption = fromAccountSelect.getOptions().get(0).getText();
        
        actor.attemptsTo(
            ClickOnTarget.element(AccountCreationPage.OPEN_NEW_ACCOUNT_LINK),
            SelectOption.byText("SAVINGS", AccountCreationPage.ACCOUNT_TYPE_DROPDOWN),
            SelectOption.byText(firstAccountOption, AccountCreationPage.FROM_ACCOUNT_DROPDOWN),
            ClickOnTarget.element(AccountCreationPage.OPEN_ACCOUNT_BUTTON)
        );
    }

    public static OpenNewAccountTask accountForm() {
        return Tasks.instrumented(OpenNewAccountTask.class);
    }
}
