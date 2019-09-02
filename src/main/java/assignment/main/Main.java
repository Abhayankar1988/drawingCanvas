package assignment.main;

import assignment.Shape;
import assignment.canvas.Canvas;
import assignment.canvas.commands.CommandInterpreter;
import assignment.canvas.commands.DrawCommand;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.Scanner;

import static assignment.CanvasConstants.*;
import static assignment.validation.CanvasValidation.validateCanvas;
import static assignment.validation.CanvasValidation.validateForProperCommand;

public class Main {

    private static Canvas canvas = null;

    private static boolean showCanvas = false;

    public static void main(String args[]) {
        //Scanner scan = null;
        try (Scanner scan = new Scanner(System.in)){
         //   scan = new Scanner(System.in);
            String command = new String();

            while (true) {
                System.out.println("\nEnter command to draw:");
                command = scan.nextLine();

                if (!StringUtils.isEmpty(command) && command.contains("Q")) {
                    break;
                }

                Canvas canvas = getCanvasFromCommand(command);

                if (canvas != null && showCanvas && canvas.isCanvasValid()) {
                    System.out.println(render(canvas));
                }
            }

            System.out.println(PROGRAM_DONE);
        }

    }

    public static String render(Canvas canvas) {
        char canvasArray[][] = canvas.getCanvasArea();
        validateCanvas(canvas);
        StringBuilder canvasBuilder = new StringBuilder();
        for (int i = 0; i < canvas.getHeight(); i++) {
            for (int j = 0; j < canvas.getWidth(); j++) {
                canvasBuilder.append(canvasArray[i][j] == DELIMITER ? EMPTY : canvasArray[i][j]);
            }
            canvasBuilder.append("\n");
        }
        return canvasBuilder.toString().trim();
    }

    public static Canvas getCanvasFromCommand(String command) {

      //  CommandInterpreter commandInterpreter = new CommandInterpreter();

        if (!StringUtils.isEmpty(command) && validateForProperCommand(command)) {

            Shape shape = Shape.getGeometryTypeForName(command.charAt(0));
            if (!shape.name().equals("CANVAS") && canvas == null) {
                System.out.println(CANVAS_NOT_INITIALIZE);
                return null;
            }

            Optional<DrawCommand> drawCommand = CommandInterpreter.getCommand(command);

            if (drawCommand.isPresent()) {
                //handle creation of canvas
                showCanvas = true;
                canvas = drawCommand.get().execute(canvas);
            } else {
                showCanvas = false;
                System.out.println(POSITIVE_VALUES);
            }
        } else {
            showCanvas = false;
            System.out.println(EMPTY_OR_INCORRECT_COMMANDS);
        }

        return canvas;
    }


}
