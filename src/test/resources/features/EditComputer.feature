@EditComputer
Feature: As a potential user i want to interact with the Edit computer functionalities

  @Smoke
  Scenario Outline: The user edits successfully a computer with <name> - <introducedDate> - <discontinuedDate> - <company>
    Given The user is located in computers database homepage
    When The user goes to edit the computer created
    And The user completes the computer form:
      | name             | <name>             |
      | introducedDate   | <introducedDate>   |
      | discontinuedDate | <discontinuedDate> |
      | company          | <company>          |
    Then Home view is displayed
    And The message '<message>' appears in home view
    And The computer is created successfully

    Examples:
      | name             | introducedDate | discontinuedDate | company | message                            |
      | automation ##### | 1996-01-01     | 2000-01-01       | ASUS    | Done! Computer %s has been updated |
      | automation ##### |                |                  | Sony    | Done! Computer %s has been updated |
      | automation ##### | 1996-01-01     | 2000-01-01       |         | Done! Computer %s has been updated |