# View_Assessments_NavigatingToPage
Version: 1.0 <br />
Coverage: All Paths <br />
Last Updated: 30/03/2020 - IST Format <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage

.
├── View_Assessments_NavigatingToPage.iml
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
│       │   │   
│       │   │       
│       │   └── Helpers
│       │   │    ├── BrowserInitHelper.java
│       │   │    ├── DriverHelper.java
│       │   │    ├── JavascriptHelper.java
│       │   │    ├── LoggerHelper.java
│       │   │    └── ScreenshotHelper.java
│       │   │   
│       │   └── Pom
│		│	│    ├── Dashboard.java
│       │   │    ├── LoginPageTest.java
│       │   │    └── ViewAssessmentsPage.java
│       │   │     └── AssessmentViewPage.java 
│       │   │       
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── Config.java
│       │   │    ├── ConsoleLogger.java
│       │   │    └── DataReader.java
│       │   │     
│       │   └── LoginPageTest.java
│       │   
│       │
│       └── resources
│           ├── ViewAssessmentsNavigation.graphml
│              
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── LoginController.class
    │   │     
	│   │      
	│   └── Helpers
    │   │     ├── BrowserInitHelper.class
    │   │     ├── DriverHelper.class
    │   │     ├── JavascriptHelper.class
    │   │     ├── LoggerHelper.class
    │   │     └── ScreenshotHelper.class
	│   │
	│   └── Pom
    │	│     ├── Dashboard.class
    │   │     ├── LoginPageTest.class
    │   │     └── ViewAssessmentsPage.class
	│   │     └── AssessmentViewPage.class
	│   │
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── Config.class
    │   │     ├── ConsoleLogger.class
    │   │     └── DataReader.class
	│   │
	│   ├── ViewAssessmentsNavigation.class 
    │   ├── ViewAssessmentsNavigation.graphml    
    │   ├    
    │   └── LoginPageTest.class    
    │          
    │           
    ├── generated-sources
    │   └── graphwalker
    │       ├── cache.json
    │       └── ViewAssessmentsNavigation
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
