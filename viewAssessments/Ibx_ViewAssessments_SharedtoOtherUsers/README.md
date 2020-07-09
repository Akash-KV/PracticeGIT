# SharedtoOtherUsers
Version: 1.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 31/03/2020 IST 4:50 PM <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── SharedtoOtherUsers.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── Controllers
│       │   │    ├── AddFilterController.java
│       │   │    ├── AssessmentSearchController.java 
│       │   │    ├── LoginController.java
│       │   │    └── SharedtoOtherUserController.java 
│       │   │       
│       │   └── Helpers
│       │   │    ├── BrowserInitHelper.java
│       │   │    ├── DriverHelper.java
│       │   │    ├── JavascriptHelper.java
│       │   │    ├── LoggerHelper.java
│       │   │    └── ScreenshotHelper.java
│       │   │   
│       │   └── Pom
│		│	│    ├── AssessmentsNavbar.java
│       │   │    ├── AssessmentViewPage.java
│       │   │    ├── Dashboard.java
│       │   │    ├── ItembankAssessment.java
│       │   │    ├── LoginPage.java
│		│	│	 ├── ViewAssessments_AddFilters.java
│       │   │    └── ViewAssessmentsPage.java
│       │   │       
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── Config.java
│       │   │    ├── ConsoleLogger.java
│       │   │    ├── DataReader.java
│       │   │    └── DataReaderViewAssessmentsSearch.java
│       │   │     
│       │   └── ViewAssessmentSharedwithMeTest.java
│       │   
│       │
│       └── resources
│           ├── ViewAssessmentSharedwithMe.graphml
│           └── ViewAssessmentsSharetoOthers.csv   
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── AddFilterController.class
	│   │     ├── AssessmentSearchController.class
	│   │     ├── LoginController.class
    │   │     └── SharedtoOtherUserController.class
	│   │      
	│   └── Helpers
    │   │     ├── BrowserInitHelper.class
    │   │     ├── DriverHelper.class
    │   │     ├── JavascriptHelper.class
    │   │     ├── LoggerHelper.class
    │   │     └── ScreenshotHelper.class
	│   │
	│   └── Pom
    │	│     ├── AssessmentsNavbar.class
    │   │     ├── AssessmentViewPage.class
	│   │     ├── Dashboard.class
	│   │     ├── ItembankAssessment.class
    │   │     ├── LoginPage.class
	│   │     ├── ViewAssessments_AddFilters.class
    │   │     └── ViewAssessmentsPage.class
	│   │
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── Config.class
    │   │     ├── ConsoleLogger.class
	│   │     ├── DataReader.class
    │   │     └── DataReaderViewAssessmentsSearch.class
	│   │
	│   ├── ViewAssessmentSharedwithMe.class 
    │   ├── ViewAssessmentSharedwithMe.graphml    
    │   ├── ViewAssessmentSharedwithMeTest.class     
    │   └── ViewAssessmentsSharetoOthers.csv    
    │          
    │           
    ├── generated-sources
    │   └── graphwalker
    │       ├── cache.json
    │       └── ViewAssessmentsBlankState
    │           
    │    
    ├── generated-test-sources
    │   └── graphwalker
    │       └── cache.json
	│       
    ├── graphwalker-reports
	├── maven-archiver
	│   └── pom.properties
    └── maven-status
        └── maven-compiler-plugin
            ├── compile
            │   └── default-compile
            │       ├── createdFiles.lst
            │       └── inputFiles.lst
            └── testCompile
                └── default-testCompile
                    └── inputFiles.lst
```