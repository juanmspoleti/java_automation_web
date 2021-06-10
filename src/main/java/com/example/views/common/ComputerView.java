package com.example.views.common;

import com.example.core.Context;
import com.example.core.ScenarioContext;
import com.example.core.Utils;
import com.example.models.ComputerModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Because of EditComputer and AddComputer views are almost equals, i set his implementations here.
 */
public class ComputerView extends ViewBase {

    @FindBy(id = "name")
    private WebElement computerNameInput;

    @FindBy(id = "introduced")
    private WebElement introducedDateInput;

    @FindBy(id = "discontinued")
    private WebElement discontinuedDateInput;

    @FindBy(id = "company")
    private WebElement companyPicker;

    @FindBy(css = "div[class='actions'] > input[type='submit']")
    private WebElement actionButton;

    @FindBy(css = "a[href='/computers']")
    private WebElement cancelButton;

    @FindBy(css = "#main > h1")
    private WebElement title;

    @FindBy(css = "div.clearfix.error")
    private WebElement error;

    public String getViewTitle() {
        return title.getText();
    }

    private void setComputerName(String name) {
        if (name != null && !name.isEmpty()) {
            setInput(computerNameInput, name);
        }
    }

    private void setIntroducedDate(String date) {
        if (date != null && !date.isEmpty()) {
            setInput(introducedDateInput, date);
        }
    }

    private void setDiscontinuedDate(String date) {
        if (date != null && !date.isEmpty()) {
            setInput(discontinuedDateInput, date);
        }
    }

    private void selectCompany(String company) {
        if (company != null && !company.isEmpty()) {
            setPickerByText(companyPicker, company);
        }
    }

    private void clickActionButton() {
        click(actionButton);
    }

    public void clickCancel() {
        click(cancelButton);
    }

    public void setComputerData(ComputerModel computer) {
        computer.setName(Utils.fillWithRandom(computer.getName()));
        setComputerName(computer.getName());
        setIntroducedDate(computer.getIntroducedDate());
        setDiscontinuedDate(computer.getDiscontinuedDate());
        selectCompany(computer.getCompany());
        clickActionButton();

        ScenarioContext.setContext(Context.COMPUTER, computer);
    }

    public boolean isErrorPresent() {
        return isVisible(error);
    }
}
