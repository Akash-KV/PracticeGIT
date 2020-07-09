# Ibx_ViewAssessments_BlankState
Version: 1.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 30/03/2020 IST 4:00 PM <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── Ibx_ViewAssessments_BlankState.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── Controllers
│       │   │    ├── LoginController.java
│       │   │    └── ViewAssessments.java 
│       │   │       
│       │   └── Helpers
│       │   │    ├── BrowserInitHelper.java
│       │   │    ├── DriverHelper.java
│       │   │    ├── JavascriptHelper.java
│       │   │    ├── LoggerHelper.java
│       │   │    └── ScreenshotHelper.java
│       │   │   
│       │   └── Pom
│		│	│    ├── Dashboard.java
│       │   │    ├── LoginPage.java
│       │   │    └── ViewAssessmentsPage.java
│       │   │       
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── Config.java
│       │   │    ├── ConsoleLogger.java
│       │   │    └── DataReader.java
│       │   │     
│       │   └── ViewAssessmentsBlankStateTest.java
│       │   
│       │
│       └── resources
│           ├── ViewAssessmentsBlankState.graphml
│           └── ViewAssessmentsBlankStateData.csv   
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── LoginController.class
    │   │     └── ViewAssessments.class
	│   │      
	│   └── Helpers
    │   │     ├── BrowserInitHelper.class
    │   │     ├── DriverHelper.class
    │   │     ├── JavascriptHelper.class
    │   │     ├── LoggerHelper.class
    │   │     └── ScreenshotHelper.class
	│   │
	│   └── Pom
    │	│     ├── Dashboard.class
    │   │     ├── LoginPage.class
    │   │     └── ViewAssessmentsPage.class
	│   │
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── Config.class
    │   │     ├── ConsoleLogger.class
    │   │     └── DataReader.class
	│   │
	│   ├── ViewAssessmentsBlankState.class 
    │   ├── ViewAssessmentsBlankState.graphml    
    │   ├── ViewAssessmentsBlankStateData.csv     
    │   └── ViewAssessmentsBlankStateTest.class    
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