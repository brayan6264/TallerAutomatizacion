package com.udea.tallercalidad.moduloprueba.interactions;

import com.udea.tallercalidad.moduloprueba.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.PASSWORD_LOGIN_TXTINP;
import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.USERNAME_LOGIN_TXTINP;

public class SignInAs implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        //todo activities
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.theValue("usuarioPruebaV13Bray").into(USERNAME_LOGIN_TXTINP));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.theValue("Password123.").into(PASSWORD_LOGIN_TXTINP));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.keyValues(Keys.RETURN).into(PASSWORD_LOGIN_TXTINP));
        WaitTime.putWaitTimeOf(10000);
    }
    public static SignInAs buyerUser() {
        return Tasks.instrumented(SignInAs.class);
    }
}