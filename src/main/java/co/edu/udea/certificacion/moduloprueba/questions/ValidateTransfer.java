package co.edu.udea.certificacion.moduloprueba.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certificacion.moduloprueba.userinterfaces.TransferFundsPage.CONFIRMATION_MESSAGE;

public class ValidateTransfer implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade element = CONFIRMATION_MESSAGE.resolveFor(actor);
        element.waitUntilVisible();
        return element.getText().trim();
    }
    public static ValidateTransfer transferCompleted() {
        return new ValidateTransfer();
    }
}
