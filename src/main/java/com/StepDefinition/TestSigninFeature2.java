package com.StepDefinition;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Step Definition file created would be consisting of a code which defines the
 * steps for annotations created in feature file. 
 * Here, in this class Test Steps(Another way) are defined for sign in functionality 
 * according to feature file
 * 
 * @author Priyanka
 *
 */

public class TestSigninFeature2 {
	RemoteWebDriver driver;
	
	
//	@Before
//	public void setup() {
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		driver.get("https://www.ijmeet.com");
//		
//	}
//	@After
//	public void teardown() {
//		
//		driver.close();
//	}
	
	@Given("I am on IJMeet Signinin page")
	public void setupIJMeetSignIn() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://ijmeet.com/login");
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter username as {string}")
	public void enterUsername(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter password as {string}")
	public void enterPassword(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Login should fail")
	public void checkSignInFails() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	
	@Then("Relogin option should be available")
	public void checkForRelogin() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	


}
