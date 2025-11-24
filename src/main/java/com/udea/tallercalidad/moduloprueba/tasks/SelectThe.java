package com.udea.tallercalidad.moduloprueba.tasks;

import com.udea.tallercalidad.moduloprueba.interactions.SelectCar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SelectThe implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectCar.lamborghini());
    }
    public static SelectThe lamborghiniCar(){
        return Tasks.instrumented(SelectThe.class);
    }
}
