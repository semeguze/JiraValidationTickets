package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the New Dash Page.
 *
 * @author Sebastian Mesa
 */
public class NewDashPage extends BasePage {

    @FindBy(css = "#dashboard-content .maximized > .dashboard-item-header")
    private WebElement tableLabel;

    @FindBy(css = "#dashboard-content .maximized .issuekey")
    private List<WebElement> listKeysTable;

    /**
     * Constructor.
     *
     * @param driver     : {@link WebDriver}
     * @param urlNewDash : {@link String}
     */
    public NewDashPage(WebDriver driver, String urlNewDash) {
        super(driver);
        driver.get(urlNewDash);
    }

    /**
     * Get the list of keys related to New Dash
     *
     * @return list with the keys
     */
    public List<String> getListNewDashKeys() {
        waitElementVisibility(tableLabel);
        waitAllElementsVisibility(listKeysTable);
        List<String> newDashKeys = new ArrayList<>();
        for (WebElement element : listKeysTable) newDashKeys.add(element.getText());
        return newDashKeys;
    }


}
