# ViewAssessmentsFilters
Version: 1.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 04/02/2020 IST 01:30 PM <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── ViewAssessmentsFilters.iml
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
│       │   │    └── LoginController.java                          
│       │   │ 
│       │   │
│       │   └── DataReaders
│       │   │    └──CSVDataReaderViewAssessmentsFilter.java
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
│		│	│    ├── AssessmentsNavbar.java
│       │   │    ├── AssessmentViewPage.java
│       │   │    ├── Dashboard.java
│       │   │    ├── ItembankAssessment.java
│       │   │    ├── LoginPage.java
│       │   │    ├── ResultsPage.java
│		│	│	 ├── ViewAssessments_AddFilters.java
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
│       │   ├── ViewAssessmentsFiltersSelectionTest.java
│       │   └── ViewAssessmentsFiltersTest.java
│       │
│       └── resources
│           ├── ViewAssessmentsFilters.csv
│           ├── ViewAssessmentsFilters.graphml
│           └── ViewAssessmentsFilterSelection.graphml   
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── AddFilterController.class
	│   │     └── LoginController.class
	│   │ 
	│   └── DataReaders
    │   │     └── CSVDataReaderViewAssessmentsFilter.class
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
    │	│     ├── AssessmentsNavbar.class
    │   │     ├── AssessmentViewPage.class
	│   │     ├── Dashboard.class
	│   │     ├── ItembankAssessment.class
    │   │     ├── LoginPage.class
	│   │     ├── ResultsPage.class
	│   │     ├── ViewAssessments_AddFilters.class
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
	│   ├── ViewAssessmentsFilters.class 
	│   ├── ViewAssessmentsFilters.csv
	│   ├── ViewAssessmentsFilters.graphml
	│   ├──	ViewAssessmentsFilterSelection.class
    │   ├── ViewAssessmentsFilterSelection.graphml    
    │   ├── ViewAssessmentsFiltersSelectionTest.class     
    │   └── ViewAssessmentsFiltersTest.class    
    │          
    │           
    ├── generated-sources
    │   └── graphwalker
    │       ├── cache.json
	│       ├── ViewAssessmentsFilters
    │       └── ViewAssessmentsFilterSelection
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