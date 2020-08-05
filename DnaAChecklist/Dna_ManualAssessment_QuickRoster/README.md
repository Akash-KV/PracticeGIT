Illuminate Template by Francisco Quezada
References: Kristian Karl

Title: Multiple Assessment Importer
Type: Base Case
ID: A-7
Last Updated: 05/31/18

******Preconditions - Changes Required before Running:******

1. Change ~./template/src/main/java/org/graphwalker/TemplatesTest.java
    a. Rename by refactoring

2. Change ~./template/src/main/resources/org/graphwalker/Temmplate.graphml
    a. Rename by refactoring

3. Remove:
    a. ~./template/target/classes/org/graphwalker/Template.class
    b. ~./template/target/classes/org/graphwalker/Template.graphml
    c. ~./template/target/classes/org/graphwalker/TemplateTest.class
    d. ~./template/target/generated-sources/graphwalker/org/graphwalker/Template.java

4. Change ~./template/src/main/java/org/graphwalker/TemplatesTest.java (not actual java class name since you changed it earlier)
    a. " public class TemplateTest extends ExecutionContext implements Template { --> public class [Name of file: NewName]Test extends ExecutionContext implements [Graphml: NewName] { "

5. Change ~./template/pom.xmltst
    a. <artifactId>template</artifactId> Line 38
    b. <name>Template</name> Line 39

6. Change ~./template/template.iml
    a. Rename template.iml

******Run the test using maven:******

```
mvn graphwalker:test
```