package com.aronim.cloud.common.tests;

import com.google.common.base.Predicate;
import org.openqa.selenium.WebDriver;

/**
 * User: Kevin W. Sewell
 * Date: 2015-12-13
 * Time: 19h21
 */
public class AronimCloudExpectedConditions {

    public static Predicate<WebDriver> bootstrapComplete() {
        return new BootstrapComplete();
    }

}
