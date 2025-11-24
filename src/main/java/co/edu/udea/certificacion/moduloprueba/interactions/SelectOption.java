package co.edu.udea.certificacion.moduloprueba.interactions;

import co.edu.udea.certificacion.moduloprueba.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectOption implements Interaction {
    private final String option;
    private final Target target;
    private final boolean byValue;

    public SelectOption(String option, Target target, boolean byValue) {
        this.option = option;
        this.target = target;
        this.byValue = byValue;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            WaitUntil.the(target, isPresent()).forNoMoreThan(10).seconds(),
            WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds()
        );
        
        WaitTime.putWaitTimeOf(500);
        
        if (byValue) {
            actor.attemptsTo(SelectFromOptions.byValue(option).from(target));
        } else {
            actor.attemptsTo(SelectFromOptions.byVisibleText(option).from(target));
        }
        WaitTime.putWaitTimeOf(1000);
    }

    public static SelectOption byText(String option, Target target) {
        return Tasks.instrumented(SelectOption.class, option, target, false);
    }
    
    public static SelectOption byValue(String option, Target target) {
        return Tasks.instrumented(SelectOption.class, option, target, true);
    }
}
