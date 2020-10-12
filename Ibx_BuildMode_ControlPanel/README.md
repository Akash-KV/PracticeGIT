# Ibx_BuildMode_ControlPanel
Version: 3.0 <br />
ID: A-5 <br />
Coverage: All Paths <br />
Last Updated: 03/08/20 <br />

###Run the test using Maven

```
mvn graphwalker:test
```


### Directory Schema

```jshelllanguage
.
├── Ibx_BuildMode_ControlPanel.iml
├── README.md
├── _classpath.xml
├── _project.xml
├── jmeter.log
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── Controllers
│       │   │    ├──DashboardController.java
│       │   │    ├── ControlPanelController.java
│       │   │    └── LoginController.java                          
│       │   │      
│       │   └── Helpers
│       │   │    ├── BrowserInitHelper.java
│       │   │    ├── DriverHelper.java
│       │   │    ├── JavascriptHelper.java
│       │   │    ├── LoggerHelper.java
│       │   │    └── ScreenshotHelper.java
│       │   │   
│       │   └── Pom
│		│	│    ├── HelpCenterPage.java
│       │   │    ├── ControlPanel.java
│       │   │    ├── Dashboard.java
│       │   │    ├── LoginPage.java
│       │   │    ├--PrivacyPolicyPage.java
│       │   │    ├── Notification.java  
│       │   │
│       │   └── Utils
│       │   │    ├── Colors.java
│       │   │    ├── ConsoleLogger.java
│       │   │    ├── Dynamic.java
│       │   │    ├── LoggerUtility.java
│       │   │    ├── Secure.java
│       │   │    └── Static.java
│       │   │    └── DataReader.java
│       │   │     
│       │   ├── LoginPageTest.java
│       │   └── ControlPanelTest.java
│       │
│       └── resources
│             └── org.graphwalker			 
│                ├── ControlPanel.graphml
│                └──  LoginPage.graphml
│                
│
│
└── target
    ├── classes
    │   └── Controllers
    │   │     ├──DashboardController.class
	│   │     ├── ControlPanelController.class
	│   │     └── LoginController.class
	│   │      
	│   └── Helpers
    │   │     ├── BrowserInitHelper.class
    │   │     ├── DriverHelper.class
    │   │     ├── JavascriptHelper.class
    │   │     ├── LoggerHelper.class
    │   │     └── ScreenshotHelper.class
	│   │
	│   └── Pom
    │	│     ├── HelpCenterPage.class
	│   │     ├── ControlPanel.class
    │   │     ├── Dashboard.class
    │   │     ├── LoginPage.class
    │   │     ├── PrivacyPolicyPage.class
    │   │     ├── Notification.class
	│   │
    │   └── Utils
    │   │   ├── Colors.class
    │   │   ├── ConsoleLogger.class
    │   │   ├── Dynamic.class
    │   │   ├── LoggerUtility.class
    │   │   ├── Secure.class
    │   │   └── Static.class
	│   │   └──  DataReader.class
    │   │     
	│   │    
    │   ├── ControlPanel.class     
    │   └── ControlPanel.graphml 
    │   ├── ControlPanelTest.class     
    │   └── LoginPage.class    
    │   ├── LoginPage.graphml     
    │   └── LoginPageTest.class    	
    │          
    │           
    ├── generated-sources
    │   └── graphwalker
    │       └── org.graphwalker
	│       │    ├── ControlPanel
    │       │    └── LoginPage
    │       │
    │       └──	cache.json
    │    
    ├── generated-test-sources
    │   └── graphwalker
    │       └── cache.json
	│       
    ├── graphwalker-reports
	├── maven-archiver
	│   └── pom.properties
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