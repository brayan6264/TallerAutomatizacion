package com.udea.tallercalidad.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.TXT_CAR_DETAILS;

public class ValidationSelectCar implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return TXT_CAR_DETAILS.resolveFor(actor).getText();
    }
    public static ValidationSelectCar lamborghini() {
        return new ValidationSelectCar();
    }
}
