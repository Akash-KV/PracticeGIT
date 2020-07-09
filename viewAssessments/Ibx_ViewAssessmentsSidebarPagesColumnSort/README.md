# Create a Assessment View
Version: 1.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 4/4/20 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── ViewAssessmentsSidebarPagesColumnSort.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── org
│       │  		└── Controllers
│       │       │   ├── LoginController.java
│       │       │   └──ViewAssessmentsSidebarPagesColumnSortController.java
│       │       │ 
│       │       ├── Data Readers
│		│		│	└──CSVDataReaderViewAssessmentsColumnSort.java
│		│		│
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
│       │       │   ├── ConsoleLogger.java
│       │       │   └── DataReader.java
│       │       │   
│       │       ├──ViewAssessmentsSidebarPagesColumnSortSelectionTest.java
│       │   	└──ViewAssessmentsSidebarPagesColumnSortTest.java
│       │
│       └── resources
│			 ├── CSVDataReaderViewAssessmentsColumnSort.csv  
│            ├── ViewAssessmentsSidebarPagesColumnSortTest.graphml
│            └──ViewAssessmentsSidebarPagesColumnSortSelectionTest.graphml   
│
│
└── target
     ├── classes
     │   └── Controllers
     │          │   ├── LoginController.java
     │          │   └──ViewAssessmentsSidebarPagesColumnSortController.java
     │          │ 
     │          ├── Data Readers
 	 │			│	└──CSVDataReaderViewAssessmentsColumnSort.java    
     │			│
     │			│
     │          └── Helpers
     │          │   ├── BrowserInitHelper.java
     │          │   ├── DriverHelper.java
     │          │   ├── JavascriptHelper.java
     │          │   ├── LoggerHelper.java
 	 │	 	    │   ├── JSExecutorHelper.java
     │          │   └── ScreenshotHelper.java
     │          │
     │          └── Pom
 	 │		    │   ├── AssessmentsNavbar.java
 	 │		    │   ├── AssessmentViewPage.java
 	 │		    │   ├── Dashboard.java
     │          │   ├── ItembankAssessment.java
     │          │   └── LoginPage.java
     │          │   └── ResultsPage.java 
 	 │	        │   └── ViewAssessments.java 
 	 │ 		    │
 	 │          └── Utils
     │          ├── ViewAssessmentsSidebarColumnSort.csv
     │          ├── ViewAssessmentsSidebarPagesColumnSort.class 
     │          ├── ViewAssessmentsSidebarPagesColumnSort.graphml
 	 │			├── ViewAssessmentsSidebarPagesColumnSortSelection.class
 	 │			├── ViewAssessmentsSidebarPagesColumnSortSelectionTest.graphml
 	 │			├── ViewAssessmentsSidebarPagesColumnSortSelectionTest.class
     │          └── ViewAssessmentsSidebarPagesColumnSortTest.class
 	 │   
     │	   
     │     
     │      
     │       
     │          
     │           
     ├── generated-sources
     │   └── graphwalker
     │       ├── cache.json
 	 │		 ├── ViewAssessmentsSidebarPagesColumnSort.graphml
     │       └── ViewAssessmentsSidebarPagesColumnSortSelection.graphml 
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
     │    └── maven-compiler-plugin
     │        ├── compile
     │        │   └── default-compile
     │        │       ├── createdFiles.lst
     │        │       └── inputFiles.lst
     │        └── testCompile
     │                └── default-testCompile
     │                └── inputFiles.lst└── graphwalker
     │               ├── Utils.Config.java
     │            ├── CreateNewAssessmentViewTest.java
     │            └── Helpers.Helper.java
     └── resources
            └── org
                └── graphwalker
                    └── ViewAssessmentsSidebarPagesColumnSort.graphml
                    └── ViewAssessmentsSidebarPagesColumnSortSelection.graphml 