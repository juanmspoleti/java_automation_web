package com.example.steps;

import io.cucumber.java.en.When;
import com.example.views.EditComputerView;

public class EditComputerSteps {

    @When("The user deletes computer created")
    public void deleteComputer() {
        EditComputerView editComputerView = new EditComputerView();
        editComputerView.clickDeleteComputer();
    }
}
