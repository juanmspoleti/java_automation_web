package com.example.steps;

import com.example.core.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.core.ScenarioContext;
import com.example.core.Utils;
import com.example.models.ComputerModel;
import com.example.views.HomeView;
import org.testng.Assert;

public class HomeSteps {

    private final String VIEW_NOT_DISPLAYED_MESSAGE = "Home view is not displayed.";
    private final String VIEW_DISPLAYED_MESSAGE = "Home view is displayed.";
    private final String TABLE_NOT_EMPTY_MESSAGE = "The computer was not removed properly.";
    private HomeView homeView;

    @Given("The user is located in computers database homepage")
    public void goToBaseUrl() {
        getHomeView().goToBaseUrl();
    }

    @When("The user goes to add a computer view")
    public void goToAddComputer() {
        getHomeView().clickAddComputer();
    }

    @When("The user goes to edit the computer created")
    public void goToEditComputer() {
        filterComputer();
        getHomeView().goToEditComputer();
    }

    @Then("Home view is displayed")
    public void isViewDisplayed() {
        Assert.assertTrue(getHomeView().isViewDisplayed(), VIEW_NOT_DISPLAYED_MESSAGE);
    }

    @Then("Home view is not displayed")
    public void isViewNotDisplayed() {
        Assert.assertFalse(getHomeView().isViewDisplayed(), VIEW_DISPLAYED_MESSAGE);
    }

    @Then("The message {string} appears in home view")
    public void isMessageDisplayed(String message) {
        ComputerModel computer = (ComputerModel) ScenarioContext.getContext(Context.COMPUTER);
        String expectedMessage = String.format(message, computer.getName());
        Assert.assertEquals(getHomeView().getTextMessage(), expectedMessage);
    }

    @Then("The computer is created successfully")
    public void verifyCreatedComputer() {
        ComputerModel expectedComputer = filterComputer();

        ComputerModel actualComputer = getHomeView().getFirstComputer();
        Assert.assertEquals(actualComputer.getName(), expectedComputer.getName());
        Assert.assertEquals(getDate(actualComputer.getIntroducedDate()), expectedComputer.getIntroducedDate());
        Assert.assertEquals(getDate(actualComputer.getDiscontinuedDate()), expectedComputer.getDiscontinuedDate());
        Assert.assertEquals(actualComputer.getCompany(), expectedComputer.getCompany());
        expectedComputer.setId(getHomeView().getComputerId());
    }

    @Then("The computer is deleted successfully")
    public void verifyDeletedComputer() {
        filterComputer();
        Assert.assertTrue(getHomeView().isTableEmpty(), TABLE_NOT_EMPTY_MESSAGE);
    }

    private ComputerModel filterComputer() {
        ComputerModel expectedComputer = (ComputerModel) ScenarioContext.getContext(Context.COMPUTER);
        getHomeView().doFilterProcess(expectedComputer);
        return expectedComputer;
    }

    private String getDate(String date) {
        if (!date.isEmpty()) {
            return Utils.getFormattedDate("dd MMM yyyy", "yyyy-MM-dd", date);
        } else {
            return date;
        }
    }

    private HomeView getHomeView() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;
    }
}
