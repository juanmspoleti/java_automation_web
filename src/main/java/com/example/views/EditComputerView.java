package com.example.views;

import com.example.views.common.ComputerView;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Here goes the implementation that is only in Edit view
 */
public class EditComputerView extends ComputerView {

    @FindBy(css = "form[method='POST'] > input[type='submit']")
    private WebElement deleteComputerButton;

    public void clickDeleteComputer() {
        click(deleteComputerButton);
    }
}
