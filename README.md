# GK_Automation_Selenium
Tools-> Selenium for communicating with the browser and Maven as the build tool
Language-> Java
Framework-> Cucumber BDD framework in which we can simply write our test scenarios in plain english text which is called the Gherkin language.
Reports-> All type of cucumber reports are being generated but the most extensive ones are the extent report and extent PDF report which demonstrates the Feature, scenarios in each feature and steps in each scenario in details.
Locator Identifications-> The first preference was given to ID and Name in order to identify the webelements. The xpaths are only used where the ID and Name is not available or are not working for eg: class or text property is available instead of ID or Name
Separate file named as Object Repository is being created for storing the properties of all the webelements.
Parameterisation is being done using the config.properties file. However not much parameterisation was required for the given website and the scenarios I automated.
Variables are being effectively used for the scenarios created. Separate class named as 'BaseUtil' is being created for the reusable functions.
Proper assertions have been used where ever required for eg: Validating the correct product being added to the cart.
Execution-> Since this is the maven project, the tests can simply be run by using the command mvn clean install. The relevant test runner file is being configured in the POM.xml file.
This scenarios is being selected in order to demonstrate the simple go through of the application and showcase all the best practices whereever applicable.
