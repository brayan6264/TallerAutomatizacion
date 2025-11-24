package com.udea.tallercalidad.moduloprueba.interactions;

import com.udea.tallercalidad.moduloprueba.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.BTN_SUBMIT_COMMENT;
import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.COMMENT_TXTINP;

public class SendComment implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        //todo
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Enter.theValue("Renteria hermoso").into(COMMENT_TXTINP));
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Click.on(BTN_SUBMIT_COMMENT));
        WaitTime.putWaitTimeOf(10000);
    }
    public static SendComment carComment(){
        return Tasks.instrumented(SendComment.class);
    }
}
