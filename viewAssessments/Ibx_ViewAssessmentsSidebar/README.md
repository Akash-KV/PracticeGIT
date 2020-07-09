# Create a Assessment View
Version: 1.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 01/03/20 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── ViewAssessmentSidebar.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │  		└── Controllers
│       │       │   ├── LoginController.java
│       │       │   └──ViewAssessmentsController.java
│       │       │ 
│       │       │       
│       │       └── Helpers
│       │       │   ├── BrowserInitHelper.java
│       │       │   ├── DriverHelper.java
│       │       │   ├── JavascriptHelper.java
│       │       │   ├── LoggerHelper.java
│		│		│	├── JSExecutorHelper.java
│       │       │   └── ScreenshotHelper.java
│       │       │
│       │       └── Pom
│		│	    │   ├── AssessmentsNavbar.java
│		│		│   ├── AssessmentViewPage.java
│		│		│   ├── Dashboard.java
│       │       │   ├── ItembankAssessment.java
│       │       │   └── LoginPage.java
│       │       │   └── ResultsPage.java 
│		│		│   └── ViewAssessments.java 
│       │       │       
│       │       │
│       │  		└── Utils
│       │       │   ├── Colors.java
│       │       │   ├── Config.java
│       │       │     ├── ConsoleLogger.java
│       │       │     └── DataReader.java
│       │       │   
│       │       ├──ViewAssessmentsSidebarSelectionTest.java
│       │   	└──ViewAssessmentsSidebarTest.java
│       │
│       └── resources
│			 ├── ViewAssessmentsSidebar.csv  
│            ├── ViewAssessmentsSidebar.graphml
│            └──ViewAssessmentsSidebarSelection.graphml   
│
│
└── target
│    ├── classes
│    │   └── Controllers
│    │          │   ├── LoginController.java
│    │          │   └──ViewAssessmentsController.java
│    │          │ 
│    │          │       
│    │          └── Helpers
│    │          │   ├── BrowserInitHelper.java
│    │          │   ├── DriverHelper.java
│    │          │   ├── JavascriptHelper.java
│    │          │   ├── LoggerHelper.java
│	 │	 	    │   ├── JSExecutorHelper.java
│    │          │   └── ScreenshotHelper.java
│    │          │
│    │          └── Pom
│	 │		    │   ├── AssessmentsNavbar.java
│	 │		    │   ├── AssessmentViewPage.java
│	 │		    │   ├── Dashboard.java
│    │          │   ├── ItembankAssessment.java
│    │          │   └── LoginPage.java
│    │          │   └── ResultsPage.java 
│	 │	        │   └── ViewAssessments.java 
│	 │ 		    │
│	 │          └── Utils
│    │          ├── ViewAssessmentsSidebar.class
│    │          ├── ViewAssessmentsSidebar.csv 
│    │          ├── ViewAssessmentsSidebar.graphml
│	 │			├── ViewAssessmentsSidebarSelection.class
│	 │			├── ViewAssessmentsSidebarSelection.graphml
│	 │			├── ViewAssessmentsSidebar.graphml
│    │          └── ViewAssessmentsSidebarSelectionTest.class
│	 │   
│    │	   
│    │     
│    │      
│    │       
│    │          
│    │           
│    ├── generated-sources
│    │   └── graphwalker
│    │       ├── cache.json
│	 │		 ├── ViewAssessmentsSidebar.graphml
│    │       └── ViewAssessmentsSidebarSelection.graphml 
│    │           
│    │    
│    ├── generated-test-sources
│    │   └── graphwalker
│    │       └── cache.json
│	 │       
│    ├── graphwalker-reports
│	 ├── maven-archiver
│	 │   └── pom.properties
│    └── maven-status
│    │    └── maven-compiler-plugin
│    │        ├── compile
│    │        │   └── default-compile
│    │        │       ├── createdFiles.lst
│    │        │       └── inputFiles.lst
│    │        └── testCompile
│    │                └── default-testCompile
│    │                └── inputFiles.lst└── graphwalker
│    │               ├── Utils.Config.java
│    │            ├── CreateNewAssessmentViewTest.java
│    │            └── Helpers.Helper.java
│    └── resources
│           └── org
│               └── graphwalker
│                   └── ViewAssessmentsSidebarSelection.graphml
