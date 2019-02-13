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
Feature: Validate Cart Summary page

  Scenario Outline: Validate selected productname color and quantity displayed in Cart Summary page
    Given I am on the "My Store" page
    When I click on "<Dressesscategory>" menu
    Then I should see "<Dressesscategory>" page
    Then Select the "<color>" color
    Then Store the productname color and quantity
		When I click on Add to cart
    Then I verify same productname color and quantity displayed in Cart Summary page
    Examples: 
      | Dressesscategory | color |
      | SUMMER DRESSES   | blue  |
