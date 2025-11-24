package com.udea.tallercalidad.moduloprueba.tasks;

import com.udea.tallercalidad.moduloprueba.interactions.SendComment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Generate implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SendComment.carComment());
    }
    public static Generate theComment(){
        return Tasks.instrumented(Generate.class);
    }
}
