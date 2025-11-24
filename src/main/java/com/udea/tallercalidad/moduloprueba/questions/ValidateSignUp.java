package com.udea.tallercalidad.moduloprueba.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.SUCCESSFUL_REGISTRATION_TXT;
import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.USERNAME_ALREADY_EXIST;

public class ValidateSignUp implements Question<String> {
    private static WebElementFacade element;
    @Override
    public String answeredBy(Actor actor) {
        element.waitUntilVisible();
        return element.getText().trim();
    }

    public static ValidateSignUp registrationMessage(Actor actor) {
        element  = SUCCESSFUL_REGISTRATION_TXT.resolveFor(actor);
        return new ValidateSignUp();
    }
    public static ValidateSignUp usernameExist(Actor actor) {
        element  = USERNAME_ALREADY_EXIST.resolveFor(actor);
        return new ValidateSignUp();
    }
}