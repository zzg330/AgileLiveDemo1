package com.autodesk.agiledemo;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class Pages {

    private final Selenium selenium;
    private final ConditionRunner conditionRunner;
    private WeatherPage weather;
 
    public Pages(Selenium selenium, ConditionRunner conditionRunner) {
        this.selenium = selenium;
        this.conditionRunner = conditionRunner;
    }
 
    public WeatherPage weather() {
        if (weather == null) {
            weather = new WeatherPage(selenium, conditionRunner);
        }
        return weather;
    }
}