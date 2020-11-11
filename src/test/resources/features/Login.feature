@Login
Feature: As a potential user i want to interact with the Login functionalities

  @Smoke
  Scenario Outline: The user logs in successfully into the app with <username>
    Given The user is located in swaglabs login page
    When The user do the login process with '<username>' and '<password>'
    Then Home view is displayed

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |

  Scenario Outline: The user tries to log into the app with invalid data: username: <username> and password: <password>
    Given The user is located in swaglabs login page
    When The user do the login process with '<username>' and '<password>'
    Then The message '<message>' is displayed in login view

    Examples:
      | username      | password     | message                                                                   |
      |               |              | Epic sadface: Username is required                                        |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user | invalid      | Epic sadface: Username and password do not match any user in this service |
      | invalid       | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user |              | Epic sadface: Password is required                                        |
