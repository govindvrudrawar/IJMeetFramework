#By creating a feature file which consists of feature, tags and scenarios and scenario outline as applicable.
#For automation testing with Selenium & Cucumber framework for Java, we need to create SignInFeature.feature file 
#under Features package with below content under “src/main/java” path.
Feature: Signin Page feature file 
#This is how background can be used to eliminate duplicate steps 
Background: 
	User navigates to IJMeet
	Given I am on IJMeet Signinin page 
	
	#Scenario with AND 
Scenario: 
	When I enter username as "abc" 
	And I enter password as "abc@123"
	Then Login should fail 
	
	#Scenario with BUT 
Scenario: 
	When I enter username as "xyz" 
	And I enter password as "xyz@123" 
	Then Login should fail
	But Relogin option should be available
		
		
		
