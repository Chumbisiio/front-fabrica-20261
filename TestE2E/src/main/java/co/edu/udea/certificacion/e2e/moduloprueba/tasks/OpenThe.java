package co.edu.udea.certificacion.e2e.moduloprueba.tasks;

import co.edu.udea.certificacion.e2e.moduloprueba.interactions.PauseFor;
import co.edu.udea.certificacion.e2e.moduloprueba.userinterfaces.AuthenticationPageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenThe {

    public static Performable registerPage() {
        return Task.where("Open register page",
                Open.url(AuthenticationPageObject.REGISTER_URL),
                PauseFor.seconds(1)
        );
    }

    public static Performable loginPage() {
        return Task.where("Open login page",
                Open.url(AuthenticationPageObject.LOGIN_URL),
                PauseFor.seconds(1)
        );
    }
}
