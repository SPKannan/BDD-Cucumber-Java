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
Feature: Product are in selected sort by order

  Scenario Outline: Validate product are selected sort by order
    Given I am on the "My Store" page
    When I click on "<Dressesscategory>" menu
    Then I should see "<Dressesscategory>" page
    When I select sort by "<sortbyvalue>" and store the product price
    Then Verify grid is in selected "<sortbyvalue>" order

    Examples: 
      | Dressesscategory | sortbyvalue          |
      | SUMMER DRESSES   | Price: Lowest first |
