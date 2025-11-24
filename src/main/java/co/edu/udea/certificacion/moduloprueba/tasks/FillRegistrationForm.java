package co.edu.udea.certificacion.moduloprueba.tasks;

import co.edu.udea.certificacion.moduloprueba.userinterfaces.RegistrationPage;
import co.edu.udea.certificacion.moduloprueba.interactions.*;
import co.edu.udea.certificacion.moduloprueba.utils.Util;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

public class FillRegistrationForm implements Task {

    private final String username;

    public FillRegistrationForm(String username) {
        this.username = username;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            ClickOnTarget.element(RegistrationPage.REGISTER_LINK),
            EnterValue.intoField("Camilo", RegistrationPage.FIRST_NAME_INPUT),
            EnterValue.intoField("Perez", RegistrationPage.LAST_NAME_INPUT),
            EnterValue.intoField("Calle 123", RegistrationPage.ADDRESS_INPUT),
            EnterValue.intoField("Medellin", RegistrationPage.CITY_INPUT),
            EnterValue.intoField("Antioquia", RegistrationPage.STATE_INPUT),
            EnterValue.intoField("050001", RegistrationPage.ZIP_CODE_INPUT),
            EnterValue.intoField("3001234567", RegistrationPage.PHONE_INPUT),
            EnterValue.intoField("123456789", RegistrationPage.SSN_INPUT),
            EnterValue.intoField(username, RegistrationPage.USERNAME_INPUT),
            EnterValue.intoField("Password123.", RegistrationPage.PASSWORD_INPUT),
            EnterValue.intoField("Password123.", RegistrationPage.CONFIRM_PASSWORD_INPUT),
            ClickOnTarget.element(RegistrationPage.REGISTER_BUTTON)
        );
    }

    public static FillRegistrationForm withUsername(String username) {
        return Tasks.instrumented(FillRegistrationForm.class, username);
    }
    
    public static FillRegistrationForm userForm() {
        return Tasks.instrumented(FillRegistrationForm.class, Util.generateRandomUsername());
    }
}
