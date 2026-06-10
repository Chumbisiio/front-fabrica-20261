package co.edu.udea.certificacion.e2e.moduloprueba.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AuthenticationPageObject {

    public static final String BASE_URL = System.getProperty("webdriver.base.url", "http://localhost:5173");
    public static final String REGISTER_URL = BASE_URL + "/register";
    public static final String LOGIN_URL = BASE_URL + "/login";

    public static final Target NAME = Target.the("name field").located(By.id("nombre"));
    public static final Target EMAIL = Target.the("email field").located(By.id("email"));
    public static final Target PASSWORD = Target.the("password field").located(By.id("password"));
    public static final Target REGISTER_BUTTON = Target.the("register button").located(By.cssSelector(".auth-btn[type='submit'], .auth-btn"));
    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.cssSelector(".auth-btn[type='submit'], .auth-btn"));
    public static final Target HOME_TITLE = Target.the("home greeting").located(By.cssSelector(".dash-greeting"));
    public static final Target REGISTER_TITLE = Target.the("register page title").located(By.cssSelector(".auth-title"));
    public static final Target LOGIN_TITLE = Target.the("login page title").located(By.cssSelector(".auth-title"));
    public static final Target ERROR_MESSAGE = Target.the("auth error message").located(By.cssSelector(".auth-error"));
    public static final Target SUCCESS_MESSAGE = Target.the("auth success message").located(By.cssSelector(".auth-success"));
}
