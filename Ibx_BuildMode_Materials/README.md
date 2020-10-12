# Ibx_BuildMode_Materials
Version: 3.0 <br />
Coverage: All Paths <br />
Last Updated: 03/08/2020 - IST Format <br />
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
├── Ibx_BuildMode_Materials.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── Controllers
│       │   │    ├── BecomeAnotherUserController.java
│       │   │    ├── BrowseModeController.java
│       │   │    ├── BuildModeController.java
│       │   │    ├── DashboardController.java
│       │   │    └── LoginController.java
│       │   │   
│       │   └── DataReaders
│		│	│    └── CSVDataReaderBuildMaterials.java
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
│		│	│    ├── BecomeAnotherUserPage.java
│       │   │    ├── BrowseModePage.java
│       │   │    ├── BuildModePage.java
│       │   │    ├── DashboardPage.java
│       │   │    └── LoginPage.java
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── ConsoleLogger.java
│       │   │    ├── Dynamic.java
│       │   │    ├── LoggerUtility.java
│       │   │    ├── Secure.java
│       │   │    └── Static.java
│       │   │     
│       │   ├── BuildModeMaterialsMainTest.java
│       │   ├── LoginPageTest.java
│       │   └── UserSwitchModelTest.java
│       │
│       └── resources
│           ├── BuildModeMaterials.csv
│           ├── BuildModeMaterials.graphml
│           ├── data.csv
│           ├── LoginPage.graphml
│           ├── upload_doc.doc
│           ├── upload_pdf.pdf
│           ├── upload_ppt.pptx
│           └── UserSwitchModel.graphml
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├── BecomeAnotherUserController.class
    │   │     ├── BrowseModeController.class
    │   │     ├── BuildModeController.class
    │   │     ├── DashboardController.class
    │   │     └── LoginController.class
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
    │	│     ├── BecomeAnotherUserPage.class
    │   │     ├── BrowseModePage.class
    │   │     ├── BuildModePage.class
	│   │     ├── DashboardPage.class
    │   │     └── LoginPage.class
	│   │
	│   └── Utils
    │   │     ├── Colors.class
    │   │     ├── ConsoleLogger.class
    │   │     ├── Dynamic.class
	│   │     ├── LoggerUtility.class
	│	│	  ├── Secure.class
    │   │     └── Static.class
	│   │
	│   ├── BuildModeMaterials.class 
    │   ├── BuildModeMaterials.csv
	│   ├── BuildModeMaterials.graphml 
    │   ├── BuildModeMaterialsMainTest.class
	│   ├── data.csv
	│   ├── LoginPage.class
	│   ├── LoginPage.graphml
	│   ├── LoginPageTest.class
	│   ├── upload_doc.doc
	│   ├── upload_pdf.pdf
    │   ├── upload_ppt.pptx
	│	├── UserSwitchModel.class
	│	├── UserSwitchModel.graphml
	│	└── UserSwitchModelTest.class
    │
    │           
    ├── generated-sources
    │   └── graphwalker
    │       ├── BuildModeMaterials
    │       ├── cache.json
	│       ├── LoginPage
    │       └── UserSwitchModel
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