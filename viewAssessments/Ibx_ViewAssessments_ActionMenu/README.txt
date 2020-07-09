# Ibx_ListAssessments_CreateButtonDropdown
Version: 1.0 <br />
Coverage: All Paths <br />
Last Updated: 19/04/2020 - IST Format <br />
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
│       │   │    ├── LoginController.java
│       │   │    ├── ViewAssessmentsController.java
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
│		│	│    ├── AssessmentsSharePage.java
│		│	│    ├── CameraGraderPage.java
│       │   │    └── Dashboard.java
│       │   │    └── LoginPage.java
│       │   │    └── OnlineAssessmentPreviewWindow.java
│       │   │    └── OnlineTestingAssessmentAdministrations.java
│		│	│    ├── ViewAssessments_AddFilters.java
│       │   │    ├── ViewAssessmentsPage.java
│       │   │    ├── ViewStudentResponsesPage.java
│       │   │
│       │   │       
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── Config.java
│       │   │    ├── ConsoleLogger.java
│       │   │    └── DataReader.java
│       │   │     
│       │   └── ViewAssessmentsActionMenuColumnTest.java
│       │   └── ViewAssessmentsAssessmentsDropDownOptionsTest.java
│       │   └── ViewAssessmentsAssessmentViewDropDownOptionsTest.java
│       │   └── ViewAssessmentsDemographicsDropDownOptionsTest.java
│       │   └── ViewAssessmentsDibelsDropDownOptionsTest.java
│       │   └── ViewAssessmentsFlexibleDropDownOptionsTest.java
│       │   └── ViewAssessmentsFluenceDropDownOptionsTest.java
│       │   └── ViewAssessmentsItemBankDropDownOptionsTest.java
│       │   └── ViewAssessmentsPFTAssessmentDropDownOptionsTest.java
│       │   └── ViewAssessmentsSkillsAssessmentDropDownOptionsTest.java
│       │   └── ViewAssessmentsSummaryDropDownOptionsTest.java
│       │   └── ViewAssessmentsSurveyDropDownOptionsTest.java
│       │   └── ViewAssessmentsUnpublishedDropDownOptionsTest.java
│       │   
│       │
│       └── resources
│       │   └── ViewAssessmentsActionMenuColumn.graphml
│       │   └── ViewAssessmentsAssessmentsDropDownOptions.graphml
│       │   └── ViewAssessmentsAssessmentViewDropDownOptions.graphml
│       │   └── ViewAssessmentsDemographicsDropDownOptions.graphml
│       │   └── ViewAssessmentsDibelsDropDownOptions.graphml
│       │   └── ViewAssessmentsFlexibleDropDownOptions.graphml
│       │   └── ViewAssessmentsFluenceDropDownOptions.graphml
│       │   └── ViewAssessmentsItemBankDropDownOptions.graphml
│       │   └── ViewAssessmentsPFTAssessmentDropDownOptions.graphml
│       │   └── ViewAssessmentsSkillsAssessmentDropDownOptions.graphml
│       │   └── ViewAssessmentsSummaryDropDownOptions.graphml
│       │   └── ViewAssessmentsSurveyDropDownOptions.graphml
│       │   └── ViewAssessmentsUnpublishedDropDownOptions.graphml
│              
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── LoginController.class
    │   │     ├── ViewAssessmentsController.class
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
	│	│    ├── AssessmentsSharePage.class
	│	│    ├── CameraGraderPage.class
    │   │    └── Dashboard.class
    │   │    └── LoginPage.class
    │   │    └── OnlineAssessmentPreviewWindow.class
    │   │    └── OnlineTestingAssessmentAdministrations.class
	│	│    ├── ViewAssessments_AddFilters.class
    │   │    ├── ViewStudentResponsesPage.class
	│   │
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── Config.class
    │   │     ├── ConsoleLogger.class
    │   │     └── DataReader.class
	│   │
	│   ├── ViewAssessmentsActionMenuColumnTest.class 
    │   └── ViewAssessmentsActionMenuColumn.graphml  
    │   └── ViewAssessmentsAssessmentsDropDownOptionsTest.class
    │   └── ViewAssessmentsAssessmentsDropDownOptions.graphml 
    │   └── ViewAssessmentsAssessmentViewDropDownOptionsTest.class
    │   └── ViewAssessmentsAssessmentViewDropDownOptions.graphml
    │   └── ViewAssessmentsDemographicsDropDownOptionsTest.class
    │   └── ViewAssessmentsDemographicsDropDownOptions.graphml 
    │   └── ViewAssessmentsDibelsDropDownOptionsTest.class
    │   └── ViewAssessmentsDibelsDropDownOptions.graphml
    │   └── ViewAssessmentsFlexibleDropDownOptionsTest.class
    │   └── ViewAssessmentsFlexibleDropDownOptions.graphml.graphml 
    │   └── ViewAssessmentsFluenceDropDownOptionsTest.class
    │   └── ViewAssessmentsFluenceDropDownOptions.graphml
    │   └── ViewAssessmentsItemBankDropDownOptionsTest.class
    │   └── ViewAssessmentsItemBankDropDownOptions.graphml 
    │   └── ViewAssessmentsPFTAssessmentDropDownOptionsTest.class
    │   └── ViewAssessmentsPFTAssessmentDropDownOptions.graphml 
    │   └── ViewAssessmentsSkillsAssessmentDropDownOptionsTest.class
    │   └── ViewAssessmentsSkillsAssessmentDropDownOptions.graphml 
    │   └── ViewAssessmentsSummaryDropDownOptionsTest.class
    │   └── ViewAssessmentsSurveyDropDownOptions.graphml 
    │   └── ViewAssessmentsUnpublishedDropDownOptionsTest.class
    │   └── ViewAssessmentsUnpublishedDropDownOptions.graphml   
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