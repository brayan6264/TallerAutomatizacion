package com.udea.tallercalidad.moduloprueba.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenThe implements Task {
    PageObject page;
    public OpenThe(PageObject page){
        this.page=page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(page));
    }

    public static OpenThe navigator(PageObject page){
        return Tasks.instrumented(OpenThe.class,page);
    }
}