Feature: User Registration
  As a visitor
  I want to register a new account
  So that I can access the home features

  Scenario: Successful user registration and login
    Given I am on the register page
    When I register a valid user
    And I click the Register button
    Then I should see the registration success message
    And I wait a moment before login
    Given I am on the login page
    And I login with the registered user
    And I click the login button
    Then I should be redirected to the home page

  @exceptions
  Scenario: Registration with an already registered email
    Given I am on the register page
    When I register with an existing email
    And I click the Register button
    Then I should stay on the register screen and get an error message
