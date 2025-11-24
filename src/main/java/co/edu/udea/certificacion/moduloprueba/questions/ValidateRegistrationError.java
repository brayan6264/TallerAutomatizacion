package co.edu.udea.certificacion.moduloprueba.questions;

import co.edu.udea.certificacion.moduloprueba.userinterfaces.RegistrationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateRegistrationError implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(RegistrationPage.ERROR_MESSAGE_TXT).answeredBy(actor);
    }

    public static ValidateRegistrationError errorMessage() {
        return new ValidateRegistrationError();
    }
}
