package com.udea.tallercalidad.moduloprueba.tasks;

import com.udea.tallercalidad.moduloprueba.interactions.SignUpAs;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FillTheRegister implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SignUpAs.newBuyerUser());
    }
    public static FillTheRegister userForm(){
        return Tasks.instrumented(FillTheRegister.class);
    }
}
