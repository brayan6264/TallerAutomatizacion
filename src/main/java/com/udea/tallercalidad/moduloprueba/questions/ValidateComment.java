package com.udea.tallercalidad.moduloprueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static com.udea.tallercalidad.moduloprueba.userinterfaces.BuggyPage.COMMENT_SAVED_TXT;

public class ValidateComment implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(COMMENT_SAVED_TXT).getText();
    }
    public static ValidateComment savedComment(){
        return new ValidateComment();
    }
}
