package org.swaglabs.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.swaglabs.views.LoginView;
import org.testng.Assert;

public class LoginSteps {

    private final String LOGIN_NOT_DISPLAYED_MESSAGE = "Login view is not displayed.";
    private LoginView loginView;

    @Given("The user is located in swaglabs login page")
    public void goToLoginPage() {
        getLoginView().goToBaseUrl();
        Assert.assertTrue(getLoginView().isLoginDisplayed(), LOGIN_NOT_DISPLAYED_MESSAGE);
    }

    @When("The user do the login process with '(.*)' and '(.*)'")
    public void doLoginProcess(String email, String password) {
        LoginView loginView = getLoginView();
        loginView.setEmail(email);
        loginView.setPassword(password);
        loginView.clickSignIn();
    }

    @Then("The message '(.*)' is displayed in login view")
    public void isErrorMessageDisplayed(String message) {
        Assert.assertEquals(getLoginView().getErrorMessage(), message);
    }

    private LoginView getLoginView() {
        if (loginView == null) {
            loginView = new LoginView();
        }
        return loginView;
    }
}
