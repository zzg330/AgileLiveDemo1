package com.autodesk.agiledemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class WeatherTest extends JBehaveStories {
	@Given("I am on the weather page")
	@Pending
	public void givenIAmOnTheWeatherPage() {
	  // PENDING
	}

	@When("I type in a zipcode $zip")
	@Pending
	public void whenITypeInAZipcode(String zip) {
	  // PENDING
	}

	@When("I click the $name button")
	@Pending
	public void whenIClickTheGetButton(String name) {
	  // PENDING
	}

	@Then("$field should be displayed as $value")
	@Pending
	public void thenCityShouldBeDisplayedAsNewOrleans(String field, String value) {
	  // PENDING
	}

	@Then("$field should be displayed")
	@Pending
	public void thenShouldBeDisplayed(String field) {
	  // PENDING
	}
}
