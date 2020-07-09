# ItemBank_Assessment_Extended
Version: 1.1 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 13/05/20 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── ItemBank_Assessment_Extended.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └──
│       │      ├── Controllers.ItemBankAssessmentController.java
│       │      ├── Controllers.LoginController.java
│       │      ├── DataReaders.CSVDataReaderItemBankAssessment.java
│       │      ├── Helpers.BrowserInitHelper.java
│       │      ├── Helpers.DriverHelper.java
│       │      ├── Helpers.JavascriptHelper.java
│       │      ├── Helpers.LoggerHelper.java
│       │      ├── Helpers.ScreenshotHelper.java
│       │      ├── Pom.AssessmentViewPage.java
│       │      ├── Pom.Dashboard.java
│       │      ├── Pom.ItemBankAssessmentPage.java
│       │      ├── Pom.LoginPage.java
|       |      |── Pom.OnlineTestingAdministrationPage.java
│       │      ├── Pom.ViewAssessmentsPage.java
│       │      ├── Utils.Colors.java
│       │      ├── Utils.Config.java
│       │      ├── Utils.ConsoleLogger.java
│       │      ├── Utils.DataReader.java
│       │      ├── ItemBankAssessmentTest.java
│       └── resources
│           └──
│              └── ItembankAssessment.graphml
│              └── ItemBankAssessmentTestData.csv
│              └── StudentPDF.pdf
└── target
    ├── classes
    │   └── org
    │       └── graphwalker
    │           ├── Controllers.ItemBankAssessmentController.class
    │           ├── Controllers.LoginController.class
    │           ├── DataReaders.CSVDataReaderFlexAssessment.class
    │           ├── Helpers.BrowserInitHelper.class
    │           ├── Helpers.DriverHelper.class
    │           ├── Helpers.JavascriptHelper.class
    │           ├── Helpers.LoggerHelper.class
    │           ├── Helpers.ScreenshotHelper.class
    │           ├── Pom.AssessmentViewPage.class
    │           ├── Pom.Dashboard.class
    │           ├── Pom.ItemBankAssessmentPage.class
    │           ├── Pom.LoginPage.class
	|           |── Pom.OnlineTestingAdministrationPage.class
    │           ├── Pom.ViewAssessmentsPage.class
    │           ├── Utils.Colors.class
    │           ├── Utils.Config.class
    │           ├── Utils.ConsoleLogger.class
    │           ├── Utils.DataReader.class
    │           ├── ItembankAssessment.class
    │           ├── ItembankAssessment.graphml
    │           ├── ItemBankAssessmentTest.class
    │           ├── ItemBankAssessmentTestData.csv
    │           ├── StudentPDF.pdf
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── ItemBankAssessment.java
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
# Scenario 1 - Adding new question - Then in ItemBankAssessmentTestData.csv file - set both DeleteQuestion, DeleteAddQuestion to OFF
# Scenario 2 - Removing First question - Then in ItemBankAssessmentTestData.csv file - set DeleteQuestion to ON, DeleteAddQuestion to OFF, PositionToDeleteQuestion to 1
# Scenario 3 - Removing Middle question - Then in ItemBankAssessmentTestData.csv file - set DeleteQuestion to ON, DeleteAddQuestion to OFF, PositionToDeleteQuestion to 2
# Scenario 4 - Removing Last question - Then in ItemBankAssessmentTestData.csv file - set DeleteQuestion to ON, DeleteAddQuestion to OFF, PositionToDeleteQuestion to 3
# Scenario 5 - Removing Last question - Then in ItemBankAssessmentTestData.csv file - set DeleteQuestion to OFF, DeleteAddQuestion to ON, PositionToDeleteQuestion to 3