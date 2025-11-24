package co.edu.udea.certificacion.moduloprueba.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.edu.udea.certificacion.moduloprueba.userinterfaces.RegistrationPage.SUCCESSFUL_REGISTRATION_TXT;

public class ValidateRegistration implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade element = SUCCESSFUL_REGISTRATION_TXT.resolveFor(actor);
        element.waitUntilVisible();
        return element.getText().trim();
    }
    public static ValidateRegistration registrationMessage() {
        return new ValidateRegistration();
    }
}
