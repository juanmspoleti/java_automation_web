package org.backbase.steps.common;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.ResponseBody;
import org.backbase.core.Context;
import org.backbase.core.ScenarioContext;
import org.backbase.core.api.ComputerService;
import org.backbase.core.api.RetrofitManager;
import org.backbase.models.ComputerModel;
import org.backbase.views.common.ComputerView;
import org.testng.Assert;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

public class ComputerSteps {

    private final String ERROR_NOT_PRESENT_MESSAGE = "Error did not appear.";
    private ComputerView computerView;

    @When("The user completes the computer form:")
    public void doAddComputerProcess(Map<String, String> map) {
        ObjectMapper mapper = new ObjectMapper();
        ComputerModel computer = mapper.convertValue(map, ComputerModel.class);
        getComputerView().setComputerData(computer);
    }

    @When("The user cancels the operation with the computer")
    public void doCancelProcess() {
        getComputerView().clickCancel();
    }

    @Then("An error appears in computer view")
    public void verifyError() {
        Assert.assertTrue(getComputerView().isErrorPresent(), ERROR_NOT_PRESENT_MESSAGE);
    }

    private ComputerView getComputerView() {
        if (computerView == null) {
            computerView = new ComputerView();
        }
        return computerView;
    }
}
