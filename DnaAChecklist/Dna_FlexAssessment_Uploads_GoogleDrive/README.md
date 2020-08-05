# Dna_FlexAssessment_Uploads_GoogleDrive
Version: 2.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 05/09/2020 <br />
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
├── Dna_FlexAssessment_Uploads_GoogleDrive.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
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
│       │    └── org
│       │           └── PageObjectModels
│       │           │      ├── AnswerKey.java
│       │           │      ├── AssessmentPanelPage.java
│       │           │      ├── AssessmentsNavbar.java
│		│		    │	   ├── Dashboard.java
│       │           │      ├── FlexAnswerKeyPage.java
│		│		    │	   ├── ItembankAssessment.java
│       │           │      ├── OnlineTestingAdministrationPage.java
│		│			│	   ├── PageObjectModelBase.java
│       │           │   
│       │           │
│       │           │
│       │           ├── Config.java
│       │           ├── CreateFlexAssessmentAllTestCasesTest.java
│       │           ├── DataReader.java
│       │           └── Helper.java
│       │
│       └── resources
│           └── org
│               └── graphwalker
│                   ├── CreateFlexAssessmentAllTestCases.graphml
│       │           ├── data.csv
│       │           ├── Upload_doc.doc
│       │           ├── Upload_pdf.pdf
│       │           └── Upload_ppt.pptx
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
    │    └── org
    │         └── graphwalker
	│           │   └── PageObjectModels
    │           │      ├── AnswerKey.class
    │           │      ├── AssessmentsNavbar.class
	│		    │	   ├── Dashboard.class
    │           │      ├── FlexAnswerKeyPage.cache
	│		    │	   ├── ItembankAssessment.class
    │           │      ├── OnlineTestingAdministrationPage.class
	│			│	   ├── PageObjectModelBase.class
    │           │     
    │           │
    │           ├── Config.class
    │           ├── CreateFlexAssessmentAllTestCasesTest.class
    │           ├── CreateFlexAssessmentAllTestCasesTest.graphml
    │           ├── CreateFlexAssessmentAllTestCasesTest.class
    │           ├── data.csv
    │           ├── DataReader.class
    │           ├──  Helper.class
    │           ├──Upload_doc.doc
    │           ├──Upload_pdf.pdf
    │           ├── Upload_ppt.pptx
    │           
	│
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── org
    │           └── graphwalker
    │               └── CreateFlexAssessmentAllTestCasesTest.java
    ├── generated-test-sources
    │   └── graphwalker
    │       └── cache.json
    ├── graphwalker-reports
    └── maven-status
        └── maven-compiler-plugin
            ├── compile
            │   └── default-compile
            │       ├── createdFiles.lst
            │       └── inputFiles.lst
            └── testCompile
                └── default-testCompile
                    └── inputFiles.lst
