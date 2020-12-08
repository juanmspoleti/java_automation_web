package org.backbase.views;

import org.backbase.core.Utils;
import org.backbase.models.ComputerModel;
import org.backbase.views.common.ViewBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeView extends ViewBase {

    @FindBy(id = "searchbox")
    private WebElement filterComputerInput;

    @FindBy(id = "searchsubmit")
    private WebElement filterComputerButton;

    @FindBy(id = "add")
    private WebElement addComputerButton;

    @FindBy(css = "div.alert-message.warning")
    private WebElement textMessage;

    @FindBy(css = "table > tbody > tr > td")
    private List<WebElement> firstRow;

    @FindBy(css = "div.well")
    private WebElement tableEmpty;

    private final int NAME_COLUMN_POSITION = 0;
    private final int INTRODUCED_DATE_COLUMN_POSITION = 1;
    private final int DISCONTINUED_DATE_COLUMN_POSITION = 2;
    private final int COMPANY_COLUMN_POSITION = 3;

    public boolean isViewDisplayed() {
        return isVisible(addComputerButton);
    }

    public ComputerModel getFirstComputer() {
        ComputerModel computer = new ComputerModel();
        computer.setName(getRowText(NAME_COLUMN_POSITION));
        computer.setIntroducedDate(getRowText(INTRODUCED_DATE_COLUMN_POSITION));
        computer.setDiscontinuedDate(getRowText(DISCONTINUED_DATE_COLUMN_POSITION));
        computer.setCompany(getRowText(COMPANY_COLUMN_POSITION));
        return computer;
    }

    public String getComputerId() {
        WebElement element = firstRow.get(NAME_COLUMN_POSITION).findElement(By.tagName("a"));
        return Utils.getOnlyNumbers(element.getAttribute("href"));
    }

    private String getRowText(int row) {
        String text = firstRow.get(row).getText();
        if (text.equals("-")) {
            return "";
        } else {
            return text;
        }
    }

    private void setFilterComputer(String computerName) {
        setInput(filterComputerInput, computerName);
    }

    private void clickFilterComputer() {
        click(filterComputerButton);
    }

    public void clickAddComputer() {
        click(addComputerButton);
    }

    public String getTextMessage() {
        return textMessage.getText();
    }

    public void doFilterProcess(ComputerModel computer) {
        setFilterComputer(computer.getName());
        clickFilterComputer();
    }

    public void goToEditComputer(){
        WebElement element = firstRow.get(NAME_COLUMN_POSITION).findElement(By.tagName("a"));
        click(element);
    }

    public boolean isTableEmpty(){
        return isVisible(tableEmpty);
    }
}
