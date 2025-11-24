package com.udea.tallercalidad.moduloprueba.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.SUCCESSFUL_REGISTRATION_TXT;

public class ValidateSignUp implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {

        WebElementFacade element = SUCCESSFUL_REGISTRATION_TXT.resolveFor(actor);
        element.waitUntilVisible();

        return element.getText().trim();
    }

    public static ValidateSignUp registrationMessage() {
        return new ValidateSignUp();
    }
}