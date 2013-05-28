package com.autodesk.agiledemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WeatherTest extends JBehaveStories {
	@Given("I am on the weather page")
	public void givenIAmOnTheWeatherPage() {
		pages.weather().open();
	}

	@When("I type in a zipcode $zip")
	public void whenITypeInAZipcode(String zip) {
    	pages.weather().typeInZip(zip);
	}

	@When("I click the $name button")
	public void whenIClickTheGetButton(String name) {
        pages.weather().clickSubmit();
	}

	@Then("$field should be displayed as $value")
	public void thenFieldShouldBeDisplayedAsValue(String field, String value) {
        assertEquals(value, pages.weather().getText(pages.weather().getFieldId(field)));
	}

	@Then("$field should be displayed")
	public void thenFieldShouldBeDisplayed(String field) {
        assertTrue(pages.weather().isElementPresent(pages.weather().getFieldId(field)));
	}
}
