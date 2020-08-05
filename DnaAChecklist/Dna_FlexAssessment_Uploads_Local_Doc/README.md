# Create a Assessment View
Version: 1.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 5/13/20 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── CreateFlexAssessmentAllTestCasesTest.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│		│	└──	Controllers
│		│	│		└──AdministrationController.java
│		│	│		├──AssessmentPanelController.java
│		│	│		├──EnterEditController.java
│		│	│		├──FlexAssessmentController.java
│		│	│		├──FlexOverviewController.java
│		│	│		├──ManualOverviewController.java
│		│	│		├──OnlineTestingController.java
│		│	│		└──PortalController.java	
│		│	│
│       │   └──org
│       │       └── graphwalker
│		│			│	└──PageObjectModel
│		│			│		└──AnswerKey.java
│		│			│		├──AssessmentsNavbar.java
│		│			│		├──Dashboard.java
│		│			│		├──FlexAnswerKeyPage.java
│		│			│		├──ItembankAssessment.java
│		│			│		├──LoginPage.java
│		│			│		├──OnlineTestingAdministrationPage.java
│		│			│		└──PageObjectModelBase.java
│		│			│
│       │           ├── Config.java
│       │           ├── CreateFlexAssessmentAllTestCasesTest.java
│       │           └── Helper.java
│       └── resources
│           └── org
│               └── graphwalker
│                   └── CreateFlexAssessmentAllTestCases.graphml
└── target
    ├── classes
    │   └── org
    │       └── graphwalker
    │           ├── Config.class
    │           ├── CreateFlexAssessmentAllTestCases.class
    │           ├── CreateFlexAssessmentAllTestCases.graphml
    │           ├── CreateFlexAssessmentAllTestCases.class
    │           └── Helper.class
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