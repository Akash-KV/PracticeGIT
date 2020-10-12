# Ibx_BuildMode_MassApply
Version: 3.0 <br />
Coverage: All Paths <br />
Last Updated: 03/08/2020 - IST Format <br />
​
###Run the test using Maven
​
```
mvn graphwalker:test
```
​
​
### Directory Schema
​
```jshelllanguage
.
```jshelllanguage
.
├── Ibx_BuildMode_MassApply.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── Controllers
│       │   │    ├── BecomeAnotherUserController.java
│       │   │    ├── BrowseModeController.java
│       │   │    ├── BuildModeController.java
│       │   │    ├── DashboardController.java
│       │   │    └── LoginController.java
│       │   │   
│       │   └── DataReaders
│		│	│    └── CSVDataReaderBuildMassApply.java
│       │   │
│       │   │       
│       │   └── Helpers
│       │   │    ├── BrowserInitHelper.java
│       │   │    ├── DriverHelper.java
│       │   │    ├── JavascriptHelper.java
│       │   │    ├── JSExecutorHelper.java
│       │   │    ├── LoggerHelper.java
│       │   │    └── ScreenshotHelper.java
│       │   │   
│       │   └── Pom
│		│	│    ├── BecomeAnotherUserPage.java
│       │   │    ├── BrowseModePage.java
│       │   │    ├── BuildModePage.java
│       │   │    ├── DashboardPage.java
│       │   │    └── LoginPage.java
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── ConsoleLogger.java
│       │   │    ├── Dynamic.java
│       │   │    ├── LoggerUtility.java
│       │   │    ├── Secure.java
│       │   │    └── Static.java
│       │   │     
│       │   ├── BuildModeMassApplyTest.java
│       │   ├── LoginPageTest.java
│       │   └── UserSwitchModelTest.java
│       │
│       └── resources
│           ├── BuildModeMassApply.csv
│           ├── BuildModeMassApply.graphml
│           ├── LoginPage.graphml
│           └── UserSwitchModel.graphml
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── BecomeAnotherUserController.class
    │   │     ├── BrowseModeController.class
    │   │     ├── BuildModeController.class
    │   │     ├── DashboardController.class
    │   │     └── LoginController.class
    │   │     
	│   └── Helpers
    │   │     ├── BrowserInitHelper.class
    │   │     ├── DriverHelper.class
    │   │     ├── JavascriptHelper.class
    │   │     ├── JSExecutorHelper.class
    │   │     ├── LoggerHelper.class
    │   │     └── ScreenshotHelper.class
	│   │
	│   └── Pom
    │	│     ├── BecomeAnotherUserPage.class
    │   │     ├── BrowseModePage.class
    │   │     ├── BuildModePage.class
	│   │     ├── DashboardPage.class
    │   │     └── LoginPage.class
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── ConsoleLogger.class
    │   │     ├── Dynamic.class
	│   │     ├── LoggerUtility.class
	│	│	  ├── Secure.class
    │   │     └── Static.class
	│   │
	│   ├── BuildModeMassApply.class 
    │   ├── BuildModeMassApply.csv
	│   ├── BuildModeMassApply.graphml 
    │   ├── BuildModeMassApplyTest.class
    │   ├── LoginPage.class
	│	├── LoginPage.graphml
	│   ├── LoginPageTest.class
	│	├── UserSwitchModel.class
	│	├── UserSwitchModel.graphml
	│	└── UserSwitchModelTest.class
    │
    │           
    ├── generated-sources
    │   └── graphwalker
    │       ├── BuildModeMassApply
    │       ├── cache.json
	│       ├── LoginPage
    │       └── UserSwitchModel
    │           
    ├── generated-test-sources
    │   └── graphwalker
    │       └── cache.json
	│       
    ├── graphwalker-reports
	├── maven-archiver
	│   └── pom.properties
    └── maven-status
        └── maven-compiler-plugin
            ├── compile
            │   └── default-compile
            │       ├── createdFiles.lst
            │       └── inputFiles.lst
            └── testCompile
                └── default-testCompile
                    └── inputFiles.lst