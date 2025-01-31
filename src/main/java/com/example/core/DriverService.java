package com.example.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Create, get and dismiss the driver
 */
public class DriverService {

    private static WebDriver driver;

    private static WebDriver createDriver() {
        ProjectTypeEnum projectType = ProjectTypeEnum.get(PropertyManager.getProperty("browser").toUpperCase());
        WebDriverManager.getInstance(projectType.getDriverClass()).clearDriverCache().setup();
        return projectType.initDriver();
    }

    public static void dismissDriver() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = createDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
