package co.edu.udea.certificacion.e2e.moduloprueba.tasks;

import co.edu.udea.certificacion.e2e.moduloprueba.interactions.PauseFor;
import co.edu.udea.certificacion.e2e.moduloprueba.userinterfaces.AuthenticationPageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SubmitThe {

    public static Performable registerButton() {
        return Task.where("Click the register button",
                Click.on(AuthenticationPageObject.REGISTER_BUTTON),
                PauseFor.seconds(1)
        );
    }

    public static Performable loginButton() {
        return Task.where("Click the login button",
                Click.on(AuthenticationPageObject.LOGIN_BUTTON),
                PauseFor.seconds(1)
        );
    }
}
