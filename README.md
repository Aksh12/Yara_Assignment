# Yara_Assignment

- Application : LCC QA
- Application Version : 0.0.0
- Programming Language: Java
- Automation tool : Appium
- Framework : DDT with test NG
- Pattern : Page Object model with design factory
- Build Automtation : Maven

Notes:-
- As per the POM protocols, maintained separate class for every screen and each class holds the methods and members of that screen.
- Maintained separate packages for screens and test scripts.
- Maintained TestBase class, which is responsible for setting of capabilities and initialization of AndroidDriver.
- Properties folder contains properties files required for application and Log4j properties.
- ITestListener is used to capture Screenshot when any failure is observed, captures even for success case.
- TestNG annotations are used for assertions
- Application level logs and server logs are captured in separate log files.
- Appium Server start and stop is handled programmatically (To run from other system, need to change Appiumjs and nodejs path)
