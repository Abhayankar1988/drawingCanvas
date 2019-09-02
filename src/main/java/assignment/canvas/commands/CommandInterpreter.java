package assignment.canvas.commands;

import assignment.Point;
import assignment.Shape;

import java.util.Optional;

import static assignment.validation.CanvasValidation.checkPointValues;
import static assignment.validation.CanvasValidation.checkPointValuesForBucketFill;

public class CommandInterpreter {

    public static Optional<DrawCommand> getCommand(String command) {
        char commandForShape = command.charAt(0);
        String[] dimensions = command.split(" ");

        switch (Shape.getGeometryTypeForName(commandForShape)) {
            case CANVAS:
                if (checkPointValues(dimensions)) return Optional.empty();
                return Optional.of(new DrawBlankCanvasCommand(Integer.parseInt(dimensions[1]),
                        Integer.parseInt(dimensions[2])));

            case LINE:
                if (checkPointValues(dimensions)) return Optional.empty();
                return Optional.of(new DrawLineCommand(new Point(Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2])),
                        new Point(Integer.parseInt(dimensions[3]), Integer.parseInt(dimensions[4]))));

            case RECTANGLE:
                if (checkPointValues(dimensions)) return Optional.empty();
                return Optional.of(new DrawRectangleCommand(new Point(Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2])),
                        new Point(Integer.parseInt(dimensions[3]), Integer.parseInt(dimensions[4]))));

            case BUCKETFILL:
                if (checkPointValuesForBucketFill(dimensions)) return Optional.empty();
                return Optional.of(new DrawBucketFillCommand(new Point(Integer.parseInt(dimensions[1]), Integer.parseInt(dimensions[2])),
                        dimensions[3].charAt(0)));

            case NO_SHAPE:
                return Optional.empty();

            default:
                return Optional.empty();
        }

    }


}

