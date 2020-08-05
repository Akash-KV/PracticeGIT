# Dna_ManualAssessment_Weights
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
├── Dna_ManualAssessment_Weights.iml
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
│		│		 │	├── CreateAssessmentModal.java
│		│		 │	├── Dashboard.java
│		│		 │	├── ManualAssessmentOverviewPage.java
│		│		 │	├── ManualAssessmentPage.java
│		│		 │	├── OnlineTestingAdministrationPage.java
│       │        │
│       │        ├── Config.java
│       │        ├── CreateManualAssessmentTest.java
│       │        ├── DataReader.java
│       │        └── Helper.java
│       └── resources
│           └── org
│               └── graphwalker
│                   ├── CreateManualAssessment.graphml
│                   └── data.csv
│
└── target
    ├── classes
    │   └── org
	│        └── PageObjectModels
    │        │     ├── AssessmentsNavbar.class
	│	     │     ├── CreateAssessmentModal.class
	│        │     ├── Dashboard.class
	│        │     ├── ManualAssessmentOverviewPage.class
	│        │     ├── ManualAssessmentPage.class
	│        │     ├── OnlineTestingAdministrationPage.class
	│        │        
    │        ├── Config.class
    │        ├── CreateManualAssessmentTest.class
    │        ├── CreateManualAssessment.graphml
    │        ├── CreateManualAssessmentTest.class
    │        └── Helper.class
	│
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── org
    │           └── graphwalker
    │               └── CreateManualAssessment.graphml
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