package org.backbase.views.common;

import org.apache.log4j.Logger;
import org.backbase.core.DriverService;
import org.backbase.core.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class ViewBase {

    /**
     * Page factory implementation
     */
    public ViewBase() {
        PageFactory.initElements(DriverService.getInstance(), this);
    }

    /**
     * ThreadLocal is used for parallel testing
     */
    private ThreadLocal<FluentWait> fluentWait = new ThreadLocal<>();

    /**
     * We can improve this by getting the timeouts from config.properties file
     * @return
     */
    public FluentWait getFluentWait() {
        if (fluentWait.get() == null) {
            fluentWait.set(new FluentWait(DriverService.getInstance()).withTimeout(Duration.ofSeconds(20L))
                    .pollingEvery(Duration.ofMillis(500L)).ignoring(NoSuchElementException.class));
        }
        return fluentWait.get();
    }

    protected void waitClickable(WebElement locator){
        getFluentWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * We can add other implementations for Select, like by index, value
     * @param element
     * @param text
     */
    protected void setPickerByText(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    protected void setInput(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    protected void click(WebElement element) {
        waitClickable(element);
        scroll(element);
        element.click();
    }

    private void scroll(WebElement element) {
        ((JavascriptExecutor) DriverService.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * I didn't needed to use, because of Page factory
     * @param locator
     * @return
     */
    protected boolean isPresent(By locator) {
        DriverService.getInstance().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isPresent = DriverService.getInstance().findElements(locator).size() > 0;
        DriverService.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return isPresent;
    }

    /**
     * Checks if elements is visible, but as well fails if its not even present.
     * @param element
     * @return
     */
    protected boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            Logger.getLogger(getClass()).info("Element was not even present: ".concat(e.getLocalizedMessage()));
            return false;
        }
    }

    public void goToBaseUrl() {
        DriverService.getInstance().get(PropertyManager.getProperty("base.url"));
    }
}
