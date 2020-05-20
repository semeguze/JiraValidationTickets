package com.globant.web.tests;

import com.globant.web.driver.Driver;
import com.globant.web.pages.HomePage;
import com.globant.web.properties.MyProperties;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * Parent of the other classes of test.
 *
 * @author Sebastian Mesa
 */
@Slf4j
public class BaseTest {

    Driver driver;
    private HomePage home;
    MyProperties myProperties = new MyProperties();

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url, String user, String pass) {
        driver = new Driver(browser);
        home = new HomePage(driver.getDriver(), url);
        home.logIn(myProperties.getProperty("jira.auth.username"),
                myProperties.getProperty("jira.auth.password"));
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        home.dispose();
    }

    /**
     * Get the home page.
     *
     * @return HomePage
     */
    public HomePage getHomePage() {
        return home;
    }

}
