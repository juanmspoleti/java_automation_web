package org.swaglabs.steps;

import io.cucumber.java.en.Then;
import org.swaglabs.views.HomeView;
import org.testng.Assert;

public class HomeSteps {

    private final String HOME_NOT_DISPLAYED_MESSAGE = "Home view is not displayed.";
    private HomeView homeView;

    @Then("Home view is displayed")
    public void isHomeViewDisplayed() {
        Assert.assertTrue(getHomeView().isHomeDisplayed(), HOME_NOT_DISPLAYED_MESSAGE);
    }

    private HomeView getHomeView() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;
    }
}
