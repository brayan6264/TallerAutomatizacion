package co.edu.udea.certificacion.moduloprueba.interactions;

import co.edu.udea.certificacion.moduloprueba.utils.WaitTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterValue implements Interaction {
    private final String value;
    private final Target target;

    public EnterValue(String value, Target target) {
        this.value = value;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(value).into(target));
        WaitTime.putWaitTimeOf(3000);
    }

    public static EnterValue intoField(String value, Target target) {
        return Tasks.instrumented(EnterValue.class, value, target);
    }
}
