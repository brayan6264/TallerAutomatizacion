package com.udea.tallercalidad.moduloprueba.tasks;

import com.udea.tallercalidad.moduloprueba.interactions.SignInAs;
import com.udea.tallercalidad.moduloprueba.interactions.SignUpAs;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FillTheLogin implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SignInAs.buyerUser());
    }
    public static FillTheLogin userForm(){
        return Tasks.instrumented(FillTheLogin.class);
    }
}
