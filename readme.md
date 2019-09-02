Please run below command to execute application

mvn compile exec:java -Dexec.mainClass="assignment.main.Main"
mvn test

Assumptions:
1. Line , Rectangle cant be drawn if dimensions are more than width and height of canvas

Validations:
1. If canvas is not created program would ask us to do so.
2. If Command is improper (parameters, small case command ) it would ask to put proper commands
for eg : c 20 30 -> c is small
3. Validation exists for negative points
4. Points are limited to Integer