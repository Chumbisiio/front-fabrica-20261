Feature: User Login
  As a registered user
  I want to log into the application
  So that I can access my dashboard

  @exceptions
  Scenario: Login failure with invalid credentials
    Given I am on the login page
    When I login with invalid credentials
    And I click the login button
    Then I should stay on the login page and see an error message
