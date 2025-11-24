package co.edu.udea.certificacion.moduloprueba.interactions;

import co.edu.udea.certificacion.moduloprueba.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SelectOption implements Interaction {
    private final String option;
    private final Target target;

    public SelectOption(String option, Target target) {
        this.option = option;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(SelectFromOptions.byVisibleText(option).from(target));
        WaitTime.putWaitTimeOf(3000);
    }

    public static SelectOption byText(String option, Target target) {
        return Tasks.instrumented(SelectOption.class, option, target);
    }
}
