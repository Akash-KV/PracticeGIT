# Dna_FlexAssessment_QuickRoster
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
├── Dna_FlexAssessment_QuickRoster.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │    └── Controllers
│		│	 │	    ├── FlexAssessmentController.java
│		│	 │	    ├── OverviewPageOverviewTabController.java
│		│	 │	    └── OverviewPagePerformanceTabController.java
│       │    │
│       │    │
│       │    └── org
│       │           └── PageObjectModels
│       │           │      ├── AnswerKey.java
│       │           │      ├── AssessmentPanelPage.java
│       │           │      ├── AssessmentsNavbar.java
│		│		    │	   ├── Dashboard.java
│       │           │      ├── FlexAnswerKeyPage.java
│		│		    │	   ├── ItembankAssessment.java
│       │           │      ├── OnlineTestingAdministrationPage.java
│		│			│	   ├── PageObjectModelBase.java
│       │           │      └── ViewAssessmentsPage.java
│       │           │
│       │           ├── Config.java
│       │           ├── CreateFlexAssessmentAllTestCasesTest.java
│       │           └── Helper.java
│       └── resources
│           └── org
│               └── graphwalker
│                   └── CreateFlexAssessmentAllTestCasesTest.graphml
└──target
    │    ├── classes
	│    │      └── Controllers
	│	 │	        ├── FlexAssessmentController.class
	│	 │	        ├── OverviewPageOverviewTabController.class
	│	 │	        └── OverviewPagePerformanceTabController.class
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