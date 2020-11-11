package org.swaglabs.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverService {

    private static WebDriver driver;

    private static WebDriver createDriver() {
        ProjectTypeEnum projectType = ProjectTypeEnum.get(PropertyManager.getProperty("platform"));
        WebDriverManager.getInstance(projectType.getDriver()).setup();
        return projectType.initDriver();
    }

    public static void dismissDriver() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriverInstance() {
        if (driver == null) {
            driver = createDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
