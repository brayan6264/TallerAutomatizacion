package com.udea.tallercalidad.moduloprueba.interactions;

import com.udea.tallercalidad.moduloprueba.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.CAR_IMAGE;

public class SelectCar implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        //Todo
        WaitTime.putWaitTimeOf(3000);
        actor.attemptsTo(Click.on(CAR_IMAGE));
        WaitTime.putWaitTimeOf(10000);
    }
    public static SelectCar lamborghini() {
        return Tasks.instrumented(SelectCar.class);
    }
}
