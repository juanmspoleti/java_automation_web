package com.example;

import com.example.core.Context;
import com.example.core.DriverService;
import com.example.core.api.ComputerService;
import com.example.core.api.RetrofitManager;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import okhttp3.ResponseBody;
import org.apache.log4j.Logger;
import com.example.core.ScenarioContext;
import com.example.models.ComputerModel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import retrofit2.Response;

import java.io.IOException;

public class Hooks {

    @Before("(@EditComputer or @DeleteComputer) and @Smoke")
    public void addComputer() throws IOException {
        ComputerService service = RetrofitManager.getInstance().getRetrofit().create(ComputerService.class);
        ComputerModel computer = new ComputerModel();
        Response<ResponseBody> response = service.createComputer(
                computer.getName(), computer.getIntroducedDate(),
                computer.getDiscontinuedDate(), computer.getCompany()
        ).execute();
        Assert.assertEquals(response.code(), 200);
        ScenarioContext.setContext(Context.COMPUTER, computer);
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        Logger.getLogger(getClass()).info(">>>Running scenario: ".concat(scenario.getName()));
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) DriverService
                    .getInstance()).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        Logger.getLogger(getClass()).info(">>>Ending scenario: ".concat(scenario.getName()));
        DriverService.dismissDriver();
        ScenarioContext.clear();
    }

    @After("(@AddComputer or @EditComputer) and @Smoke")
    public void deleteComputer() throws IOException {
        ComputerModel computer = (ComputerModel) ScenarioContext.getContext(Context.COMPUTER);
        ComputerService service = RetrofitManager.getInstance().getRetrofit().create(ComputerService.class);

        Response<ResponseBody> response = service.deleteComputer(computer.getId()).execute();
        Assert.assertEquals(response.code(), 200);
    }
}
