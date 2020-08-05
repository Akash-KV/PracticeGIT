# Dna_ItembankAssessment_QuickMode
Version: 2.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 05/11/2020 <br />
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
├── Dna_ItembankAssessment_QuickMode.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── org
│       │        └── PageObjectModels
│       │        │  ├── AssessmentsNavbar.java
│		│		 │	├── Dashboard.java
│		│		 │	├── FlexAnswerKeyPage.java
│		│		 │	├── ItembankAssessment.java
│		│		 │	├── PageObjectModelBase.java
│       │        │
│       │        ├── Config.java
│       │        ├── CreateNewAssessmentViewTest.java
│       │        ├── DataReader.java
│       │        └── Helper.java
│       └── resources
│           └── org
│               └── graphwalker
│                   ├── CreateNewAssessmentView.graphml
│                   └── data.csv
│
└── target
    ├── classes
    │   └── org
	│        └── PageObjectModels
    │        │     ├── AssessmentsNavbar.class
	│	     │     ├── CreateAssessmentModal.class
	│        │     ├── Dashboard.class
	│        │     ├── FlexAnswerKeyPage.class
	│        │     ├── ItembankAssessment.class
	│        │     ├── PageObjectModelBase.class
	│        │        
    │        ├── Config.class
    │        ├── CreateNewAssessmentViewTest.class
    │        ├── CreateNewAssessmentView.graphml
    │        ├── CreateNewAssessmentViewTest.class
    │        └── Helper.class
	│
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── org
    │           └── graphwalker
    │               └── CreateNewAssessmentView.graphml
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
```