package com.aronim.cloud.common.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * User: Kevin W. Sewell
 * Date: 2015-12-13
 * Time: 19h25
 */
public class WebDriverFactory {

    public static final String REMOTE_URL = "http://hub:4444/wd/hub";

    public static String getBaseUrl() {

        return isGoEnvironment() ? "http://gocd-agent-build:8080" : "http://localhost:8080";
    }

    public static WebDriver getWebDriver() {

        return isGoEnvironment() ? getRemoteWebDriver() : new ChromeDriver();
    }

    private static boolean isGoEnvironment() {

        String goEnvironmentName = System.getenv("GO_ENVIRONMENT_NAME");

        return goEnvironmentName != null;
    }

    private static WebDriver getRemoteWebDriver() {

        URL remoteAddress = getUrl(REMOTE_URL);
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();

        return new RemoteWebDriver(remoteAddress, desiredCapabilities);
    }

    private static URL getUrl(String url) {

        try {

            return new URL(url);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver init(String path) {

        WebDriver driver = getWebDriver();
        driver.get(WebDriverFactory.getBaseUrl() + path);

        return driver;
    }
}
