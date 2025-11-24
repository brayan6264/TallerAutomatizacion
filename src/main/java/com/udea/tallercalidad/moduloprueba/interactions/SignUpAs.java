package com.udea.tallercalidad.moduloprueba.interactions;

import com.udea.tallercalidad.moduloprueba.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.*;

public class SignUpAs implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        //todo activity
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Click.on(REGISTER_BOTTON));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.theValue("usuarioPruebaV13Bray").into(USERNAME_TXTINP));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.theValue("Usuario").into(FIRSTNAME_TXTINP));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.theValue("Prueba").into(LASTNAME_TXTINP));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.theValue("Password123.").into(PASSWORD_TXTINP));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.theValue("Password123.").into(CONFIRMPASSWORD_TXTINP));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Click.on(REGISTER_BTN));
        WaitTime.putWaitTimeOf(3000);

    }
    public static SignUpAs newBuyerUser() {
        return Tasks.instrumented(SignUpAs.class);
    }
}
