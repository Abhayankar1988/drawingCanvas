*** The Problem ***

__Description__

You're given the task of writing a simple console version of a drawing program. 
At this time, the functionality of the program is quire limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit


Command 		Description
C w h           Should create a new canvas of width w and height h.
L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                horizontal or vertical lines are supported. Horizontal and vertical lines
                will be drawn using the 'x' character.
R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                using the 'x' character.
B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                behaviour of this is the same as that of the "bucket fill" tool in paint
                programs.
Q               Should quit the program.

Please refer "task.txt" for more details on sample i/p and o/p

#Please run below command to execute application

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
