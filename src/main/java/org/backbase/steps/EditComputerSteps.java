package org.backbase.steps;

import io.cucumber.java.en.When;
import org.backbase.views.EditComputerView;

public class EditComputerSteps {

    @When("The user deletes computer created")
    public void deleteComputer() {
        EditComputerView editComputerView = new EditComputerView();
        editComputerView.clickDeleteComputer();
    }
}
