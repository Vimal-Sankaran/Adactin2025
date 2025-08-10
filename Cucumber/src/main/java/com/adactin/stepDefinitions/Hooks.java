package com.adactin.stepDefinitions;

import com.adactin.utitlities.BaseClass;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void afterScenario() {
        if (BaseClass.driver != null) {
            BaseClass.driver.quit();
            BaseClass.driver = null;
        }
    }
}
