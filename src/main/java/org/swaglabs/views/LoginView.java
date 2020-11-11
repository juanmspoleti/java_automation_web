package org.swaglabs.views;

import org.openqa.selenium.By;
import org.swaglabs.views.common.ViewBase;

public class LoginView extends ViewBase {

    private final String USERNAME_INPUT_ID = "user-name";
    private final String PASSWORD_INPUT_ID = "password";
    private final String SIGN_IN_BUTTON_ID = "login-button";
    private final String ERROR_MESSAGE_LABEL_CSS = "h3[data-test='error']";

    public String getErrorMessage() {
        return getText(By.cssSelector(ERROR_MESSAGE_LABEL_CSS));
    }

    public void setEmail(String email) {
        setInput(By.id(USERNAME_INPUT_ID), email);
    }

    public void setPassword(String password) {
        setInput(By.id(PASSWORD_INPUT_ID), password);
    }

    public void clickSignIn() {
        click(By.id(SIGN_IN_BUTTON_ID));
    }

    public boolean isLoginDisplayed() {
        return isPresent(By.id(USERNAME_INPUT_ID));
    }
}
