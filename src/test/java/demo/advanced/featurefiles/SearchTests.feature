#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

@Background
Given Chrome Broswer should be launched
And User should login in the the application


  @SmokeTest
  Scenario: Verify upon Searching Apple mobile on Amazon it displays the list of mobile
    Given Admin is going to login using <username>
    And enter <password> as Password
    When admin clicks Login
    Then admin should get logged In
    And there should be name of admin getting logged on Home Page.
    And Login name should be as <LoggedInUser>
    
    Examples: 
      | username  | password | LoggedInUser  |
      | admin1 |     automate | admin1 |

  @tag2
  Scenario Outline: verifyCategories
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |

