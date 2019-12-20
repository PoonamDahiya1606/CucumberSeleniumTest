# CucumberSeleniumTest

CucumberSeleniumTest is a test framework created using selenium webDriver with cucumber JVM.

It is a behaviour driven development (BDD) approach to write automated test scripts to test Web Application. It enables you to write and execute Automated Unit/Acceptance test scenarios.

## Setup
* Install Java and set path
* Install Maven and set path
* Clone this repository or download zip.

## How to run End-toEnd test
* Goto Project Directory
* Use `mvn test` to run features.

## Application Under Test
Testing Web Application - "ebay.com.au" 
* Scenario - Single Item Purchase using Credit Card as a Guest User.

## Test Design Approach
* Used Page Object Model (Page factory). Benefits of using it:

1. Code reusability – We can achieve code reusability by writing the code once and use it in different tests.
2. Code maintainability – There is a clean separation between test code and page specific code such as locators and layout which becomes very easy to maintain code. Code changes only on Page Object Classes when a UI change occurs. It enhances test maintenance and reduces code duplication.
3. Object Repository – Each page will be defined as a java class. All the fields in the page will be defined in an interface as members. The class will then implement the interface.
4. Readability – Improves readability due to clean separation between test code and page specific code
 

* Used Cucumber-JVM v4.2.0 to get latest features and debug fixes.
* Used Selenium Extend Reports. Benefits of using it:
1. Generate more interactive reports which includes a dashboard view, graphical view, Total Execution time and many more features.
2. Easy to integrate with common test frameworks(TestNG, Selenium-Cucumber).
3. Can capture the screenshots and embed the screesnhots in report with test steps.

* Used webDriverManager to automate the management of the binary drivers(eg.. chromedriver, geckodriver, etc.)
* Used cucumber hooks:
 1. To better manage the code workflow.
 2. To reduce the code redundancy.
 3. To initiate and kill the webDriver session in @Before and @After hooks.
 
* Created SeleniumDriver class to capture all driver actions.




