Feature: Registration automationpractice website
  New User , not able to register with inValid Email Address
  New User , Able to register with Valid Email Address

  Scenario Outline: Error Message Displayed if user enter invalid email address
    Given I am on the register an account page
    When I click the link create an account with email address "<email address>"
    Then An error message "<error message>" will appear on the page

    Examples: 
      | email address    | error message          |
      | invalidemail@abc | Invalid email address. |

  @sanity
  Scenario Outline: Successful registration
    New User , able to register with Valid Email Address

    Given I am on the register an account page
    When I click the link create an account with email address "<email address>"
    Then I enter personal information "<cfirstname>" "<clastname>" "<cpassword>"
    Then I enter address contact information "<firstname>" "<lastname>" "<address>" "<city>" "<state>" "<postal>" "<mbphone>"
    When I click on "create an account"
    Then Validate "<cfirstname>" "<clastname>"

    Examples: 
      | cfirstname   | clastname    | cpassword   | firstname  | lastname   | address    | city | state    | postal | mbphone   | email address       |
      | firstnameOne | clastnameOne | cpassword@1 | firstname1 | clastname1 | cpassword1 | city | Colorado |  56000 | 123456791 | validemail1@abc.com |
