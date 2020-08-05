# Dna_SurveyAssessment
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
├── Dna_SurveyAssessment.iml
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
│		│		 │	├── ItembankAssessment.java
│		│		 │	├── PageObjectModelBase.java
│       │        │
│       │        ├── Config.java
│       │        ├── CreateSurveyAssessmentTest.java
│       │        ├── DataReader.java
│       │        └── Helper.java
│       └── resources
│           └── org
│               └── graphwalker
│                   ├── CreateSurveyAssessment.graphml
│                   └── data.csv
│
└── target
    ├── classes
    │   └── org
	│        └── PageObjectModels
    │        │     ├── AssessmentsNavbar.class
	│	     │     ├── CreateAssessmentModal.class
	│        │     ├── Dashboard.class
	│        │     ├── ItembankAssessment.class
	│        │     ├── PageObjectModelBase.class
	│        │        
    │        ├── Config.class
    │        ├── CreateSurveyAssessmentTest.class
    │        ├── CreateSurveyAssessment.graphml
    │        ├── CreateSurveyAssessmentTest.class
    │        └── Helper.class
	│
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── org
    │           └── graphwalker
    │               └── CreateSurveyAssessment.graphml
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