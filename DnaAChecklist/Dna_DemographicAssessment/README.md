# Dna_DemographicAssessment
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
├── Dna_DemographicAssessment.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── org
│       │        └── PageObjectModels
│       │        │  ├── AssessmentsNavbar.java
│		│		 │	├── AssessmentViewPage.java
│		│		 │	├── Dashboard.java
│		│		 │	├── ItembankAssessment.java
│       │        │  └── ViewAssessmentsPage.java
│       │        │
│       │        ├── Config.java
│       │        ├── CreateNewDemographicTest.java
│       │        ├── DataReader.java
│       │        └── Helper.java
│       │
│       └── resources
│           └── org
│               └── graphwalker
│                   ├── CreateNewDemographic.graphml
│                   └── data.csv
│
└── target
    ├── classes
    │   └── org
	│        └── PageObjectModels
    │        │     ├── AssessmentsNavbar.class
	│	     │     ├── AssessmentViewPage.class
	│        │     ├── Dashboard.class
	│        │     ├── ItembankAssessment.class
	│        │     └── ViewAssessmentsPage.class
	│        │        
    │        ├── Config.class
    │        ├── CreateNewDemographic.class
    │        ├── CreateNewDemographic.graphml
    │        ├── CreateNewDemographicTest.class
    │        └── Helper.class
	│
    ├── generated-sources
    │   ├── annotations
    │   └── graphwalker
    │       ├── cache.json
    │       └── org
    │           └── graphwalker
    │               └── CreateNewDemographic.java
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