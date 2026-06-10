package co.edu.udea.certificacion.e2e.moduloprueba.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class PauseFor implements Interaction {

    private final long milliseconds;

    public PauseFor(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public static PauseFor seconds(int seconds) {
        return Tasks.instrumented(PauseFor.class, seconds * 1000L);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
