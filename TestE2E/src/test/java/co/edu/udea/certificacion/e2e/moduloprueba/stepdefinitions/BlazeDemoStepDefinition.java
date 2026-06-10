package co.edu.udea.certificacion.e2e.moduloprueba.stepdefinitions;

import co.edu.udea.certificacion.e2e.moduloprueba.models.LoginData;
import co.edu.udea.certificacion.e2e.moduloprueba.models.RegisterData;
import co.edu.udea.certificacion.e2e.moduloprueba.models.TestUsers;
import co.edu.udea.certificacion.e2e.moduloprueba.questions.ValidationThe;
import co.edu.udea.certificacion.e2e.moduloprueba.interactions.PauseFor;
import co.edu.udea.certificacion.e2e.moduloprueba.tasks.CompleteThe;
import co.edu.udea.certificacion.e2e.moduloprueba.tasks.OpenThe;
import co.edu.udea.certificacion.e2e.moduloprueba.tasks.SubmitThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;

public class BlazeDemoStepDefinition {

    public Actor client;
    private String registeredEmail;
    private String registeredPassword;

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        client = OnStage.theActorCalled("User");
        client.can(BrowseTheWeb.with(theDriver));
    }

    @Given("I am on the register page")
    public void iAmOnTheRegisterPage() {
        client.attemptsTo(OpenThe.registerPage());
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        client.attemptsTo(OpenThe.loginPage());
    }

    @When("I register a valid user")
    public void iRegisterAValidUser() {
        RegisterData registerData = TestUsers.newUser();
        registeredEmail = registerData.getEmail();
        registeredPassword = registerData.getPassword();
        client.attemptsTo(CompleteThe.registerForm(registerData));
    }

    @When("I register with an existing email")
    public void iRegisterWithAnExistingEmail() {
        RegisterData registerData = TestUsers.existingRegistration();
        registeredEmail = registerData.getEmail();
        registeredPassword = registerData.getPassword();
        client.attemptsTo(CompleteThe.registerForm(registerData));
    }

    @And("I click the Register button")
    public void iClickTheRegisterButton() {
        client.attemptsTo(SubmitThe.registerButton());
    }

    @And("I wait a moment before login")
    public void iWaitAMomentBeforeLogin() {
        client.attemptsTo(PauseFor.seconds(2));
    }

    @And("I login with the registered user")
    public void iLoginWithTheRegisteredUser() {
        LoginData loginData = new LoginData(registeredEmail, registeredPassword);
        client.attemptsTo(CompleteThe.loginForm(loginData));
    }

    @When("I login with invalid credentials")
    public void iLoginWithInvalidCredentials() {
        LoginData loginData = TestUsers.invalidUser();
        client.attemptsTo(CompleteThe.loginForm(loginData));
    }

    @And("I enter email {string} and password {string}")
    public void iEnterEmailAndPassword(String email, String password) {
        LoginData loginData = new LoginData(email, password);
        client.attemptsTo(CompleteThe.loginForm(loginData));
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        client.attemptsTo(SubmitThe.loginButton());
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        GivenWhenThen.then(client).should(
                GivenWhenThen.seeThat(ValidationThe.homePageIsDisplayed(), equalTo(true))
        );
    }

    @Then("I should see the registration success message")
    public void iShouldSeeTheRegistrationSuccessMessage() {
        GivenWhenThen.then(client).should(
                GivenWhenThen.seeThat(ValidationThe.registrationSuccessMessageIsDisplayed(), equalTo(true))
        );
    }

    @Then("I should stay on the register screen and get an error message")
    public void iShouldStayOnTheRegisterScreenAndGetAnErrorMessage() {
        GivenWhenThen.then(client).should(
                GivenWhenThen.seeThat(ValidationThe.registerPageIsDisplayed(), equalTo(true))
        );
        GivenWhenThen.then(client).should(
                GivenWhenThen.seeThat(ValidationThe.errorMessageIsDisplayed(), equalTo(true))
        );
    }

    @Then("I should stay on the login page and see an error message")
    public void iShouldStayOnTheLoginPageAndSeeAnErrorMessage() {
        GivenWhenThen.then(client).should(
                GivenWhenThen.seeThat(ValidationThe.loginPageIsDisplayed(), equalTo(true))
        );
        GivenWhenThen.then(client).should(
                GivenWhenThen.seeThat(ValidationThe.errorMessageIsDisplayed(), equalTo(true))
        );
    }

}
