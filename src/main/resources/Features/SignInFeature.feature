#By creating a feature file which consists of feature, tags and scenarios and scenario outline as applicable.
#For automation testing with Selenium & Cucumber framework for Java, we need to create SignInFeature.feature file 
#under Features package with below content under “src/main/resources” path.
Feature: Signin Page feature file

  Scenario Outline: Check username and password entered
    When User Enter "<Username>" and "<Password>"
    Then Check user should login

    Examples: 
      | Username | Password |
      | abc      | abc@123  |
      | xyz			 | xyz@123  |
   
