package com.autodesk.agiledemo;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.core.reporters.Format.HTML;
import static org.jbehave.core.reporters.Format.TXT;
import static org.jbehave.core.reporters.Format.XML;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.SilentStepMonitor;
import org.jbehave.web.selenium.PerStorySeleniumSteps;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumScreenshotOnFailure;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.jbehave.web.selenium.SeleniumSteps;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.condition.ConditionRunner;
public abstract class JBehaveStories extends JUnitStories {

	protected Selenium selenium;
	protected Pages pages;
	protected SeleniumSteps lifecycleSteps;
	
	private ConditionRunner conditionRunner;
	private SeleniumContext seleniumContext;
	
	public JBehaveStories(){
		
		final Properties testProp = new Properties();
		
		try {
			InputStream is = getClass().getClassLoader().getResourceAsStream("test.properties");
			testProp.load(is);
			
			this.selenium = new DefaultSelenium(
					testProp.getProperty("selenium.host"),
					Integer.parseInt(testProp.getProperty("selenium.port")),
					testProp.getProperty("selenium.driver"),
					testProp.getProperty("target.url"));
			
		} catch (IOException e) {
			// give some default value
			this.selenium = new DefaultSelenium("localhost", 4444,
					"*firefox",
					"http://localhost:8080");			
		}
		
		this.conditionRunner = SeleniumConfiguration.defaultConditionRunner(selenium);
		this.pages = new Pages(selenium, conditionRunner);
		this.lifecycleSteps = new PerStorySeleniumSteps(selenium);
		this.seleniumContext = new SeleniumContext();
	}
	
	@Override
	public Configuration configuration() {
		Class<? extends Embeddable> embeddableClass = this.getClass();
		return new SeleniumConfiguration()
				.useSelenium(selenium)
				.useSeleniumContext(seleniumContext)
				.useStepMonitor(
						new SeleniumStepMonitor(selenium, seleniumContext,
								new SilentStepMonitor()))
				.useStoryLoader(new LoadFromClasspath(embeddableClass))
				.useStoryReporterBuilder(
						new StoryReporterBuilder()
								.withCodeLocation(
										codeLocationFromClass(embeddableClass))
								.withDefaultFormats()
								.withFormats(CONSOLE, TXT, HTML, XML));
	}

	@Override
	protected List<String> storyPaths() {
		return new StoryFinder().findPaths(
				codeLocationFromClass(this.getClass()).getPath(), getStories(),
				null);
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), getSteps(),
				lifecycleSteps, new SeleniumScreenshotOnFailure(selenium));

	}

	protected Object getSteps(){
		return this;
	}
	
	protected List<String> getStories(){
		return asList("**/*.story");
	}
}
