package com.example.steps;

import io.cucumber.java.en.Then;
import com.example.views.AddComputerView;
import org.testng.Assert;

public class AddComputerSteps {

    @Then("Add view is displayed")
    public void isViewDisplayed() {
        AddComputerView addComputerView = new AddComputerView();
        Assert.assertEquals(addComputerView.getViewTitle(), addComputerView.TITLE_TEXT);
    }

}
