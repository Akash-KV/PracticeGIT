# Ibx_ListAssessments_CreateButtonDropdown
Version: 1.0 <br />
Coverage: All Paths <br />
Last Updated: 30/03/2020 - IST Format <br />
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
├── Ibx_ListAssessments_CreateButtonDropdown.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── Controllers
│       │   │    ├── ListAssessmentsController.java
│       │   │    ├── LoginController.java
│       │   │    ├── NavbarController.java
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
│		│	│    ├── AssessmentsNavbar.java
│       │   │    ├── AssessmentViewPage.java
│       │   │    └── Dashboard.java
│       │   │    └── ItembankAssessment.java
│       │   │    └── LoginPage.java
│       │   │    └── ViewAssessmentsPage.java
│       │   │
│       │   │       
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── Config.java
│       │   │    ├── ConsoleLogger.java
│       │   │    └── DataReader.java
│       │   │     
│       │   └── CreateNewAssessmentViewTest.java
│       │   
│       │
│       └── resources
│           ├── CreateNewAssessmentView.graphml
│              
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── ListAssessmentsController.class
    │   │     ├── LoginController.class
    │   │     ├── NavbarController.class
    │   │     
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
    │	│     ├── AssessmentsNavbar.class
    │   │     ├── AssessmentViewPage.class
    │   │     └── Dashboard.class
	│   │     └── ItembankAssessment.class
    │   │     └── LoginPage.class
    │   │     └── ViewAssessmentsPage.class
	│   │
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── Config.class
    │   │     ├── ConsoleLogger.class
    │   │     └── DataReader.class
	│   │
	│   ├── CreateNewAssessmentView.class 
    │   ├── CreateNewAssessmentView.graphml    
    │   ├    
    │   └── CreateNewAssessmentViewTest.class    
    │          
    │           
    ├── generated-sources
    │   └── graphwalker
    │       ├── cache.json
    │       └── CreateNewAssessmentView
    │           
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