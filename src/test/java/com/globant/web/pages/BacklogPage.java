package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Backlog Page.
 *
 * @author Sebastian Mesa
 */
public class BacklogPage extends BasePage {

    @FindBy(css = ".ghx-sprint-group .ghx-name")
    private WebElement sprintLabel;

    @FindBy(css = ".ghx-sprint-group .js-key-link")
    private List<WebElement> listKeysSprint;

    /**
     * Constructor.
     *
     * @param driver      : {@link WebDriver}
     * @param urlBacklog: {@link String}
     */
    public BacklogPage(WebDriver driver, String urlBacklog) {
        super(driver);
        driver.get(urlBacklog);
    }

    /**
     * Get the list of keys related to Backlog
     *
     * @return list with the keys
     */
    public List<String> getListBacklogKeys() {
        waitElementVisibility(sprintLabel);
        scrollIntoView(sprintLabel);
        List<String> backlogKeys = new ArrayList<>();
        for (WebElement element : listKeysSprint) backlogKeys.add(element.getText());
        return backlogKeys;
    }


}
