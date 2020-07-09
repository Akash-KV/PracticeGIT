# Ibx_ListAssessments_LocalIdentifier
Version: 1.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 04/06/2020 IST 10:30 AM <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── LocalIdentifier.iml
├── README.md
├── classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── Controllers
│       │   │    ├── AddFilterController.java
│       │   │    └── LoginController.java                          
│       │   │ 
│       │   │
│       │   └── DataReaders
│       │   │    └── CSVDataReaderLocalIdentifier.java
│       │   │
│       │   └── Helpers
│       │   │    ├── BrowserInitHelper.java
│       │   │    ├── DriverHelper.java
│       │   │    ├── JavascriptHelper.java
│       │   │    ├── JSExecutorHelper.java
│       │   │    ├── LoggerHelper.java
│       │   │    └── ScreenshotHelper.java
│       │   │   
│       │   └── Pom		
│       │   │    ├── Dashboard.java      
│       │   │    ├── LoginPage.java
│       │   │    └── ViewAssessmentsPage.java
│       │   │       
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── Config.java
│       │   │    ├── ConsoleLogger.java
│       │   │    └── DataReader.java
│       │   │     
│       │   │     
│       │   └── Ibx_ListAssessments_LocalIdentifierTest.java
│       │
│       └── resources
│           ├── Assessments.csv
│           └──Ibx_ListAssessments_LocalIdentifier.graphml
│            
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── AddFilterController.class
	│   │     └── LoginController.class
	│   │ 
	│   └── DataReaders
    │   │     └── CSVDataReaderLocalIdentifier.class
	│   │      
	│   └── Helpers
    │   │     ├── BrowserInitHelper.class
    │   │     ├── DriverHelper.class
    │   │     ├── JavascriptHelper.class
	│   │     ├── JSExecutorHelper.class
    │   │     ├── LoggerHelper.class
    │   │     └── ScreenshotHelper.class
	│   │
	│   └── Pom
	│   │     ├── Dashboard.class
    │   │     ├── LoginPage.class
    │   │     └── ViewAssessmentsPage.class
	│   │
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── Config.class
    │   │     ├── ConsoleLogger.class
	│   │     └── DataReader.class
    │   │      
	│   │
	│   ├── Assessments.class 
	│   ├── Ibx_ListAssessments_LocalIdentifier.class
	│   ├── Ibx_ListAssessments_LocalIdentifier.graphml
	│   └──	Ibx_ListAssessments_LocalIdentifierTest.class
    │               
    │           
    ├── generated-sources
    │   └── graphwalker
    │       ├── cache.json
	│       └── Ibx_ListAssessments_LocalIdentifier        
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