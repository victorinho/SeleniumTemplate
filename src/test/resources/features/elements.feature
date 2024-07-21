Feature: Demo QA tests

  Background: navigate to Demo QA page
    Given The user visit the 'https://demoqa.com' page.

  Scenario: Go to elements page
    When The user select elements
    Then The left panel is displayed

  Scenario: Go to elements page
    When The user select elements
    Then The left panel is displayed
    When The user select Text Box item
    When The user type username: username




