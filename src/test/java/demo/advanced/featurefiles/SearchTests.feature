
@SmokeTest
Feature: Amazon Test Feature
  I want to use this template for my feature file

Background: 


@Smoke
  Scenario: Verify upon Searching Apple mobile on Amazon it displays the list of mobile
    Given Admin is going to login using "<username>"
    And enter "<password>" as Password I am changing it
    When admin clicks Login
    Then admin should get logged In
    And there should be name of admin getting logged on Home Page.
    And Login name should be as "<LoggedInUser>"
    
    Examples: 
      | username  | password		   | LoggedInUser  |
      | admin1			 |     automate   	| admin1 						|
			| admin2 			|     automate	  | admin2 						|
  