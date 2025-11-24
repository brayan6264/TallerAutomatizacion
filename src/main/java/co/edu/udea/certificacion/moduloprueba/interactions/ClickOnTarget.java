package co.edu.udea.certificacion.moduloprueba.interactions;

import co.edu.udea.certificacion.moduloprueba.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Click;

public class ClickOnTarget implements Interaction {
    private final Target target;

    public ClickOnTarget(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(target));
        WaitTime.putWaitTimeOf(2000);
    }

    public static ClickOnTarget element(Target target) {
        return Tasks.instrumented(ClickOnTarget.class, target);
    }
}
