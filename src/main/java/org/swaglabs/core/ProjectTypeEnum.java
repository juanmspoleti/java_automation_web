package org.swaglabs.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum ProjectTypeEnum {

    CHROME {
        @Override
        public Class<? extends WebDriver> getDriver() {
            return ChromeDriver.class;
        }

        @Override
        public WebDriver initDriver() {
            return new ChromeDriver();
        }
    },
    FIREFOX {
        @Override
        public Class<? extends WebDriver> getDriver() {
            return FirefoxDriver.class;
        }

        @Override
        public WebDriver initDriver() {
            return new FirefoxDriver();
        }
    };

    public abstract Class<? extends WebDriver> getDriver();

    public abstract WebDriver initDriver();

    public static ProjectTypeEnum get(String key) {
        try {
            return Enum.valueOf(ProjectTypeEnum.class, key);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid value for enum ProjectTypeEnum : " + key);
        }
    }


}