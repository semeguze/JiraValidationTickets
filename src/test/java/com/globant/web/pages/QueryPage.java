package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the Query Page.
 *
 * @author Sebastian Mesa
 */
public class QueryPage extends BasePage {

    @FindBy(id = "summary-val")
    private WebElement summaryLabel;

    @FindBy(className = "issue-link-key")
    private List<WebElement> listKeysQuery;

    /**
     * Constructor.
     *
     * @param driver   : {@link WebDriver}
     * @param urlQuery : {@link String}
     */
    public QueryPage(WebDriver driver, String urlQuery) {
        super(driver);
        driver.get(urlQuery);
    }

    /**
     * Get the list of keys related to Query
     *
     * @return list with the keys
     */
    public List<String> getListQueryKeys() {
        waitElementVisibility(summaryLabel);
        List<String> queryKeys = new ArrayList<>();
        for (WebElement element : listKeysQuery) queryKeys.add(element.getText());
        return queryKeys;
    }


}
