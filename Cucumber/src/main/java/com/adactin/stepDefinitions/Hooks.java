package com.adactin.stepDefinitions;

import com.adactin.utitlities.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @After
    public void afterScenario() {
        if (BaseClass.driver != null) {
            BaseClass.driver.quit();
            BaseClass.driver = null;
        }
    }
}
