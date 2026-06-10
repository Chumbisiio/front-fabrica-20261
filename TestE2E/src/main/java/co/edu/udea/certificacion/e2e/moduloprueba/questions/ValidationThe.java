package co.edu.udea.certificacion.e2e.moduloprueba.questions;

import co.edu.udea.certificacion.e2e.moduloprueba.userinterfaces.AuthenticationPageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ValidationThe implements Question<Boolean> {

    private final Question<Boolean> question;

    private ValidationThe(Question<Boolean> question) {
        this.question = question;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return question.answeredBy(actor);
    }

    public static ValidationThe registerPageIsDisplayed() {
        return new ValidationThe(Visibility.of(AuthenticationPageObject.REGISTER_TITLE));
    }

    public static ValidationThe loginPageIsDisplayed() {
        return new ValidationThe(Visibility.of(AuthenticationPageObject.LOGIN_TITLE));
    }

    public static ValidationThe registrationSuccessMessageIsDisplayed() {
        return new ValidationThe(Visibility.of(AuthenticationPageObject.SUCCESS_MESSAGE));
    }

    public static ValidationThe errorMessageIsDisplayed() {
        return new ValidationThe(Visibility.of(AuthenticationPageObject.ERROR_MESSAGE));
    }

    public static ValidationThe homePageIsDisplayed() {
        return new ValidationThe(Visibility.of(AuthenticationPageObject.HOME_TITLE));
    }
}
