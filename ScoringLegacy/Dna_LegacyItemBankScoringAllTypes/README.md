# Dna_LegacyItemBankScoringAllTypes
Version: 1.1 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 09/07/20 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── Dna_LegacyItemBankScoringAllTypes.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └──
│       │      ├── Controllers.DashBoardController.java
│       │      ├── Controllers.ItemBankAssessmentController.java
│       │      ├── Controllers.LoginController.java
│       │      ├── Controllers.OnlineTestingAdministrationController.java
│       │      ├── DataWriter.CSVDataWriterScoringEvent.java
│       │      ├── DataReaders.CSVDataReaderItemBankAssessment.java
│       │      ├── DataReaders.CSVDataReaderScoring.java
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
│       │      ├── DashBoardTest.java
│       │      ├── ItemBankAssessmentTest.java
│       │      ├── LoginPageTest.java
│       └── resources
│           └──
│              └── DashBoardPage.graphml
│              └── ItemBankAssessmentTestData.csv
│              └── LoginPageModel.graphml
│              └──ScoringEventData.csv
│              └──ScoringItemBankLegacy.graphml
│              └── StudentPDF.pdf
└── target
    ├── classes
    │   └── org
    │       └── graphwalker
    │           ├── Controllers.DashBoardController.class
    │           ├── Controllers.ItemBankAssessmentController.class
	|           ├── Controllers.LoginController.class
	│           ├──Controllers.OnlineTestingAdministrationController.class
	│           ├── DataWriter.CSVDataWriterScoringEvent.class
    │           ├── DataReaders.CSVDataReaderItemBankAssessment.class
	│           ├── DataReaders.CSVDataReaderScoring.class
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
    │           ├── DashBoardTest.class
	│           ├── ItemBankAssessmentTest.class
    │           ├── LoginPageTest.class
    │           ├── ItemBankAssessmentTestData.csv
	│           ├── ScoringEventData.csv
    │           ├── StudentPDF.pdf
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── LoginPageModel
	│       └── DahBoardPage
	│       └──ScoringItemBankLeagcy
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