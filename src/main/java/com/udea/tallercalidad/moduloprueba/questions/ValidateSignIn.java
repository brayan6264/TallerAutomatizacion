package com.udea.tallercalidad.moduloprueba.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.TXT_HI_USERNAME;

public class ValidateSignIn implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade element = TXT_HI_USERNAME.resolveFor(actor);
        element.waitUntilVisible();

        return element.getText().trim();
    }
    public static ValidateSignIn singInMessage() {
        return new ValidateSignIn();
    }
}
