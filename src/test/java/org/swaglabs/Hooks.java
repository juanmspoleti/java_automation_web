package org.swaglabs;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.swaglabs.core.DriverService;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        Logger.getLogger(getClass()).info(">>>Running scenario: ".concat(scenario.getName()));
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) DriverService
                    .getDriverInstance()).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        Logger.getLogger(getClass()).info(">>>Ending scenario: ".concat(scenario.getName()));
        DriverService.dismissDriver();
    }
}
