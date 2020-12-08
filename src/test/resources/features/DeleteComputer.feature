@DeleteComputer
Feature: As a potential user i want to interact with the Delete computer functionalities

  @Smoke
  Scenario Outline: The user deletes successfully a computer
    Given The user is located in computers database homepage
    When The user goes to edit the computer created
    And The user deletes computer created
    Then Home view is displayed
    And The message '<message>' appears in home view
    And The computer is deleted successfully

    Examples:
      | message                         |
      | Done! Computer has been deleted |