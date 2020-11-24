@AddComputer
Feature: As a potential user i want to interact with the Add computer functionalities

  Background: The user goes to add a new computer
    Given The user is located in computers database homepage
    When The user goes to add a computer view

  @Smoke
  Scenario Outline: The user adds successfully a new computer with <name> - <introducedDate> - <discontinuedDate> - <company>
    When The user completes the computer form:
      | name             | <name>             |
      | introducedDate   | <introducedDate>   |
      | discontinuedDate | <discontinuedDate> |
      | company          | <company>          |
    Then Home view is displayed
    And The message '<message>' appears in home view
    And The computer is created successfully

    Examples:
      | name             | introducedDate | discontinuedDate | company | message                            |
      | automation ##### | 1996-01-01     | 2000-01-01       | ASUS    | Done! Computer %s has been created |


  Scenario Outline: The user tries to add a new computer with <name> - <introducedDate> - <discontinuedDate> - <company>
    When The user completes the computer form:
      | name             | <name>             |
      | introducedDate   | <introducedDate>   |
      | discontinuedDate | <discontinuedDate> |
      | company          | <company>          |
    Then Home view is not displayed
    And Add view is displayed
    And An error appears in computer view

    Examples:
      | name             | introducedDate | discontinuedDate | company |
      |                  |                |                  |         |
      | automation ##### |                | 1996/01/01       |         |
      | automation ##### | Characters     |                  |         |
    @Bug
    Examples:
      | name             | introducedDate | discontinuedDate | company |
      | automation ##### | 3000-01-01     |                  |         |
      | automation ##### | 01-01-1996     |                  |         |

  Scenario: The user cancel the addition of the computer
    When The user cancels the operation with the computer
    Then Home view is displayed