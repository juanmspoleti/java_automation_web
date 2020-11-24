package org.backbase.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * If we needed, we can add a method to return the DesiredCapabilities, but in this project, is not necessary for now.
 */
public enum ProjectTypeEnum {

    CHROME {
        @Override
        public Class<? extends WebDriver> getDriverClass() {
            return ChromeDriver.class;
        }

        @Override
        public WebDriver initDriver() {
            return new ChromeDriver();
        }
    },
    FIREFOX {
        @Override
        public Class<? extends WebDriver> getDriverClass() {
            return FirefoxDriver.class;
        }

        @Override
        public WebDriver initDriver() {
            return new FirefoxDriver();
        }
    };

    public abstract Class<? extends WebDriver>  getDriverClass();

    public abstract WebDriver initDriver();

    public static ProjectTypeEnum get(String key) {
        try {
            return Enum.valueOf(ProjectTypeEnum.class, key);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid value for enum ProjectTypeEnum : ".concat(key));
        }
    }


}