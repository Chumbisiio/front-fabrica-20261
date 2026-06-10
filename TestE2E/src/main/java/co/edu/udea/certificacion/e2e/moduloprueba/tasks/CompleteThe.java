package co.edu.udea.certificacion.e2e.moduloprueba.tasks;

import co.edu.udea.certificacion.e2e.moduloprueba.interactions.PauseFor;
import co.edu.udea.certificacion.e2e.moduloprueba.models.LoginData;
import co.edu.udea.certificacion.e2e.moduloprueba.models.RegisterData;
import co.edu.udea.certificacion.e2e.moduloprueba.userinterfaces.AuthenticationPageObject;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class CompleteThe {

    public static Performable registerForm(RegisterData data) {
        return Task.where("Complete the register form",
                Enter.theValue(data.getName()).into(AuthenticationPageObject.NAME),
                PauseFor.seconds(1),
                Enter.theValue(data.getEmail()).into(AuthenticationPageObject.EMAIL),
                PauseFor.seconds(1),
                Enter.theValue(data.getPassword()).into(AuthenticationPageObject.PASSWORD),
                PauseFor.seconds(1)
        );
    }

    public static Performable loginForm(LoginData data) {
        return Task.where("Complete the login form",
                Enter.theValue(data.getEmail()).into(AuthenticationPageObject.EMAIL),
                PauseFor.seconds(1),
                Enter.theValue(data.getPassword()).into(AuthenticationPageObject.PASSWORD),
                PauseFor.seconds(1)
        );
    }
}
