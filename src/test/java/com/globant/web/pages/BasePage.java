package com.globant.web.pages;

import com.globant.web.properties.MyProperties;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent of the other classes of pages.
 *
 * @author Sebastian Mesa
 */
@Slf4j
@Getter
public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final MyProperties properties;

    /**
     * Constructor.
     *
     * @param pDriver : WebDriver
     */
    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 20);
        driver = pDriver;
        properties = getProperties();
    }

    /**
     * Close the web driver.
     */
    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Method to go to the Backlog Page
     *
     * @param backlog {@link String}
     * @return a new instance of BacklogPage
     */
    public BacklogPage goToBacklog(String backlog) {
        return new BacklogPage(driver, backlog);
    }

    /**
     * Method to go to the NewDashPage Page
     *
     * @param newDash {@link String}
     * @return a new instance of NewDashPage
     */
    public NewDashPage goToNewDash(String newDash) {
        return new NewDashPage(driver, newDash);
    }

    /**
     * Method to go to the QueryPage Page
     *
     * @param query {@link String}
     * @return a new instance of QueryPage
     */
    public QueryPage goToQuery(String query) {
        return new QueryPage(driver, query);
    }

    // WAITS

    /**
     * Wait element to be visible.
     *
     * @param element : {@link WebElement}
     */
    public void waitElementVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait element to be staleness.
     *
     * @param element : {@link WebElement}
     */
    public void waitElementStaleness(WebElement element) {
        getWait().until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * Wait for all elements to be visible.
     *
     * @param element : {@link List}<{@link WebElement}>
     */
    public void waitAllElementsVisibility(List<WebElement> element) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(element));
    }

    /**
     * Wait element to be invisible.
     *
     * @param element : {@link WebElement}
     */
    public void waitElementInvisibility(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Wait element to be clickable.
     *
     * @param element : {@link WebElement}
     */
    public void waitElementClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    // ACTIONS

    /**
     * Click on element.
     *
     * @param element : {@link WebElement}
     */
    public void click(WebElement element) {
        waitElementVisibility(element);
        element.click();
    }

    /**
     * Fill element with a sequence of chars as String
     *
     * @param element  : {@link WebElement}
     * @param sequence : {@link String}
     */
    public void sendKeys(WebElement element, String sequence) {
        waitElementVisibility(element);
        element.sendKeys(sequence);
    }

    /**
     * Clear existing data, and then fill element with a sequence of chars as String
     *
     * @param element  : {@link WebElement}
     * @param sequence : {@link String}
     */
    public void clearAndSendKeys(WebElement element, String sequence) {
        waitElementVisibility(element);
        element.clear();
        element.sendKeys(sequence);
    }

    /**
     * Method to move into view of an element
     *
     * @param element : {@link WebElement}
     */
    public void scrollIntoView(WebElement element) {
        waitElementVisibility(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // DATA

    /**
     * Method to select an value from a dropdown element
     *
     * @param element : {@link WebElement}
     * @param value   : {@link String}
     * @return WebElement with the option selectd
     */
    public WebElement selectFromDropdownByValue(WebElement element, String value) {
        waitElementVisibility(element);
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
        return dropdown.getFirstSelectedOption();
    }

    /**
     * Method to compare two lists of data. It could be improved
     *
     * @param listA {@link List<String>}
     * @param listB {@link List<String>}
     * @param idA   {@link String}
     * @param idB   {@link String}
     */
    public void compareTwoLists(final List<String> listA, final List<String> listB, String idA, String idB) {

        List<String> auxList = new ArrayList<>(listA);
        auxList.removeAll(listB);

        log.info("{} vs {}", idA, idB);
        if (!auxList.isEmpty()) {
            log.warn("{} tickets missing in {}", auxList.size(), idB);
            for (String ticket : auxList) log.warn("-> {} is missing", ticket);
        } else {
            log.info("No missing tickets in {}", idB);
        }

        auxList.clear();
        auxList = new ArrayList<>(listB);
        auxList.removeAll(listA);

        log.info("{} vs {}", idB, idA);
        if (!auxList.isEmpty()) {
            log.warn("{} tickets missing in {}", auxList.size(), idA);
            for (String ticket : auxList) log.warn("The ticket : {} is missing", ticket);
        } else {
            log.info("No missing tickets in {}", idA);
        }

    }


}
