package com.autodesk.agiledemo;

import org.jbehave.web.selenium.SeleniumPage;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;

public class WeatherPage extends SeleniumPage  {
 
    public WeatherPage(Selenium selenium, ConditionRunner conditionRunner) {
        super(selenium, conditionRunner);
    }
    
    public void open(){
    	open("/");
    }
    
    public void typeInZip(String zipcode){
    	type("zip", zipcode);
    }
    
    public void clickSubmit(){
    	clickButton("submit");
        waitForPageToLoad();
    }
	
	public String getFieldId(String field){
		return field.replaceAll(" ", "-").toLowerCase()+"-value";
	}
}