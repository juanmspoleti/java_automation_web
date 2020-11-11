# Swaglabs

## Installation
You need to have JDK 1.8 and Maven installed. Follow this link to install both in Mac OS: https://www.journaldev.com/2348/install-maven-mac-os

## Run
### all testcases:
mvn clean test

### only smoke:
mvn clean test "-Dcucumber.filter=-t @Smoke"

### only login:
mvn clean test "-Dcucumber.filter=-t @Login"

## Debug:
mvn clean test -DforkCount=0

## Multi browsers
For default the framework runs with Chrome, to run with Firefox add to the mvn command line: -Pfirefox
For example: mvn clean test -Pfirefox

## Technologies used:
* Java jdk 1.8
* Maven
* Selenium
* TestNG
* Cucumber
* Log4j
* Bonigarcia

## Reports
The report, once we run the test, are located in target/cucumber-reports

## Testcases
The testcases requested in exercise 1) are located in ./testCases.txt

## Project structure
* src/test/resources/features = features files with the scenarios and gherkin
* src/test/java/Hooks = hooks of cucumber for this project (before and after)
* src/main/resources = properties files: cucumber options, log4 and project configs (config.properties)
* src/main/java/steps = steps that matches with gherkin from features files
* src/main/java/views = interactions with the views of the application
* src/main/java/core = different implementations:
    * DriverService: manage the driver instance
    * ProjectTypeEnum: enum with the different types of project
    * PropertyManager: loads the properties (located in config.properties) and use them in the lifecycle