package assignment.canvas.commands;

import assignment.Point;
import assignment.canvas.Canvas;

import java.util.stream.IntStream;

import static assignment.CanvasConstants.INCORRECT_DIMENSIONS;
import static assignment.validation.CanvasValidation.validateCanvas;
import static assignment.validation.CanvasValidation.validatePoints;

public class DrawLineCommand implements DrawCommand {

    Character toDraw;
    private Point startPoint;
    private Point endPoint;


    public DrawLineCommand(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.toDraw = 'X';
    }

    @Override
    public Canvas execute(Canvas canvas) {
        canvas.setCanvasValid(true);
        validateCanvas(canvas);
        validatePoints(startPoint, endPoint, canvas);

        if (!canvas.isCanvasValid()) {
            System.out.println(INCORRECT_DIMENSIONS);
            return canvas;
        }

        char canvasArray[][] = canvas.getCanvasArea();
        IntStream.rangeClosed(startPoint.getY(), endPoint.getY())
                .forEach(i -> IntStream
                        .rangeClosed(startPoint.getX(), endPoint.getX())
                        .forEach(j -> canvasArray[i][j] = toDraw));

        return canvas;
    }

}
