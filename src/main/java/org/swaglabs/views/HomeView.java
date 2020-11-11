package org.swaglabs.views;

import org.openqa.selenium.By;
import org.swaglabs.views.common.ViewBase;

public class HomeView extends ViewBase {

    private final String INVENTORY_CONTAINER_ID = "inventory_container";

    public boolean isHomeDisplayed() {
        return isPresent(By.id(INVENTORY_CONTAINER_ID));
    }
}
