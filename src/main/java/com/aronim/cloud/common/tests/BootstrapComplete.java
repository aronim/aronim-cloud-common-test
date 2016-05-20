package com.aronim.cloud.common.tests;

import com.google.common.base.Predicate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * User: Kevin W. Sewell
 * Date: 2015-12-13
 * Time: 19h20
 */
public final class BootstrapComplete implements Predicate<WebDriver> {

    @Override
    public boolean apply(WebDriver webDriver) {

        Boolean bootstrapComplete =
                (Boolean) ((JavascriptExecutor) webDriver)
                        .executeScript("return window.aronim.cloud.bootstrap.done");

        return bootstrapComplete == null ? false : bootstrapComplete;
    }
}
