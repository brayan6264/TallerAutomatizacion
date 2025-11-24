package co.edu.udea.certificacion.moduloprueba.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certificacion.moduloprueba.userinterfaces.AccountCreationPage.CONFIRMATION_MESSAGE;

public class ValidateAccountCreation implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade element = CONFIRMATION_MESSAGE.resolveFor(actor);
        element.waitUntilVisible();
        return element.getText().trim();
    }
    public static ValidateAccountCreation accountCreated() {
        return new ValidateAccountCreation();
    }
}
