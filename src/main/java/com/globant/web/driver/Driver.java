package com.globant.web.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Driver class
 *
 * @author Sebastian Mesa
 */
public class Driver {

    private WebDriver driver;

    /**
     * Constructor.
     *
     * @param browser : String
     */
    public Driver(String browser) {
        switch (browser) {
            case "remoteFirefox":
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "remoteChrome":
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriverMac");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver83.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                break;
        }
    }

    /**
     * Get the driver.
     *
     * @return WebDriver with the driver
     */
    public WebDriver getDriver() {
        return this.driver;
    }

}