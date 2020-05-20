package com.globant.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents the Home Page.
 *
 * @author Sebastian Mesa
 */
public class HomePage extends BasePage {

    // TextFields
    @FindBy(id = "login-form-username")
    private WebElement usernameTextField;
    @FindBy(id = "login-form-password")
    private WebElement passwordTextField;

    // Buttons
    @FindBy(id = "login")
    private WebElement loginButton;

    // Containers
    @FindBy(className = "aui-avatar-inner")
    private WebElement avatarContainer;

    /**
     * Constructor.
     *
     * @param driver : {@link WebDriver}
     * @param url:   {@link String}
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Method to perform the logic in Jira
     *
     * @param user {@link String}
     * @param pass {@link String}
     */
    public void logIn(String user, String pass) {
        sendKeys(usernameTextField, user);
        sendKeys(passwordTextField, pass);
        click(loginButton);
        waitElementVisibility(avatarContainer);
    }


}
