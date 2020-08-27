package com.StepDefinition;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Step Definition file created would be consisting of a code which defines the
 * steps for annotations created in feature file. 
 * Here, in this class Test Steps are defined for sign in functionality 
 * according to feature file
 * 
 * @author Priyanka
 *
 */

public class TestSigninFeature {
	RemoteWebDriver driver;

//	@Before
//	public void setup() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.get("https://ijmeet.com/login");
//		
//	}
//	@After
//	public void teardown() {
//		
//		driver.close();
//	}

	@When("User Enter {string} and {string}")
	public void user_Enter_and(String string, String string2) {

		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();

	}

	@Then("Check user should login")
	public void check_user_should_login() {

		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();

	}

}
