@fineos
Feature: Automate As an Engr. Candidate I need to automate http://www.way2automation.com/angularjs-protractor/webtables/ So I can show my automation capabilities

  @fineos1
  Scenario: Add a user and validate the user has been added to the table
    Given I navigate to Way2Automation "webtables"
    When I click Add User button
    Then Add User pop up window is present
    When I fill out all fields
    And I click Save button
    Then New user is added to webtable

  @fineos2
  Scenario: Delete user User Name: novak and validate user has been deleted
    Given I navigate to Way2Automation "webtables"
    When I delete user with User Name "novak"
    Then Confirmation dialog is displayed
    When I click Ok
    Then User with User Name "novak" is deleted and not present in table
