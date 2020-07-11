#ViewAssessments_SearchAssessments
Version: 1.1 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 31/03/20 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


​
### Directory Schema
​
```jshelllanguage
.
├── ViewAssessments_SearchAssessments.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── Controllers
│       │   │    ├── LoginController.java
│       │   │    └── AssessmentSearch.java 
│       │   │       
│       │   └── Helpers
│       │   │    ├── BrowserInitHelper.java
│       │   │    ├── DriverHelper.java
│       │   │    ├── JavascriptHelper.java
│       │   │    ├── LoggerHelper.java
│       │   │    └── ScreenshotHelper.java
│       │   │   
│       │   └── Pom
│		│	│    ├── AssessmentsNavbar.java
│       │   │    ├── AssessmentsViewPage.java
│       │   │    └── Dashboard.java
│       │   │    ├──ItembankAssessment.java
│       │   │    ├── LoginPageTest.java
│       │   │    └── ViewAssessmentsPage.java 
│       │   │    
│       │   │  
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── Config.java
│       │   │    ├── ConsoleLogger.java
│       │   │    └── DataReader.java
│       │   │    └── DataReaderViewAssessmentsSearch.java
│       │   └── LoginPageTest.java
│       │   
│       │
│       └── resources
│           ├── SearchAssessment.graphml
│           └── ViewAssessmentsSearch.csv   
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── LoginController.class
    │   │     └── AssessmentSearchController.class
	│   │      
	│   └── Helpers
    │   │     ├── BrowserInitHelper.class
    │   │     ├── DriverHelper.class
    │   │     ├── JavascriptHelper.class
    │   │     ├── LoggerHelper.class
    │   │     └── ScreenshotHelper.class
	│   │
	│   └── Pom
    │	│     ├── AssessmentsNavbar.class
    │   │     ├── AssessmentsViewPage.class
    │   │     └── Dashboard.class
	│   │     │── ItembankAssessment.class
    │   │     ├──LoginPageTest.class
    │   │     └── ViewAssessmentsPage.class
	│   │
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── Config.class
    │   │     ├── ConsoleLogger.class
    │   │     └── DataReader.class
	│   │     └── DataReaderViewAssessmentsSearch.class
	│   ├── SearchAssessment.class 
    │   ├── SearchAssessment.graphml    
    │   ├── ViewAssessmentsSearch.csv     
    │   └── LoginPageTest.class    
    │          
    │           
    ├── generated-sources
    │   └── graphwalker
    │       ├── cache.json
    │       └── SearchAssessment
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
