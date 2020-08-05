# Dna_FlexAssessment_Demo
Version: 2.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 05/09/2020 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── Dna_FlexAssessment_Demo.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │    └── Controllers
│       │    │      ├── AdministrationController.java
│		│	 │	    ├── AssessmentPanelController.java
│		│	 │	    ├── EnterEditController.java
│		│	 │	    ├── FlexAssessmentController.java
│		│	 │	    ├── FlexOverviewController.java
│		│	 │	    ├── ManualOverviewController.java
│		│	 │	    ├── OnlineTestingController.java
│		│	 │	    └── PortalController.java
│       │    │
│       │    │
│       │    └── org
│       │           └── PageObjectModels
│       │           │      ├── AnswerKey.java
│       │           │      ├── AssessmentsNavbar.java
│		│		    │	   ├── Dashboard.java
│       │           │      ├── FlexAnswerKeyPage.java
│		│		    │	   ├── ItembankAssessment.java
│       │           │      ├── OnlineTestingAdministrationPage.java
│		│			│	   ├── PageObjectModelBase.java
│       │           │      └── ViewAssessmentsPage.java
│       │           │
│       │           │
│       │           └── graphwalker
│       │                 ├── Config.java
│       │                 ├── CreateFlexAssessmentAllTestCasesTest.java
│       │                 └── Helper.java
│       └── resources
│           └── org
│               └── graphwalker
│                   └── CreateFlexAssessmentAllTestCasesTest.graphml
└── target
    │    ├── classes
	│    │      └── Controllers
    │    │          ├── AdministrationController.class
    │	 │	        ├── AssessmentPanelController.class
	│	 │	        ├── EnterEditController.class
	│	 │	        ├── FlexAssessmentController.class
	│	 │	        ├── FlexOverviewController.class
	│	 │	        ├── ManualOverviewController.class
	│	 │	        ├── OnlineTestingController.class
	│	 │	        └── PortalController.class
    │    └── org
    │         └── graphwalker
	│           │   └── PageObjectModels
    │           │      ├── AnswerKey.class
    │           │      ├── AssessmentsNavbar.class
	│		    │	   ├── Dashboard.class
    │           │      ├── FlexAnswerKeyPage.cache
	│		    │	   ├── ItembankAssessment.class
    │           │      ├── OnlineTestingAdministrationPage.class
	│			│	   ├── PageObjectModelBase.class
    │           │      └── ViewAssessmentsPage.class
    │           │
    │           ├── Config.class
    │           ├── CreateFlexAssessmentAllTestCasesTest.class
    │           ├── CreateFlexAssessmentAllTestCasesTest.graphml
    │           ├── CreateFlexAssessmentAllTestCasesTest.class
    │           └── Helper.class
	│
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── org
    │           └── graphwalker
    │               └── CreateFlexAssessmentAllTestCasesTest.java
    ├── generated-test-sources
    │   └── graphwalker
    │       └── cache.json
    ├── graphwalker-reports
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