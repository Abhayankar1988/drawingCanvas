package assignment.canvas.commands;

import assignment.Point;
import assignment.canvas.Canvas;

import java.util.stream.IntStream;

import static assignment.CanvasConstants.INCORRECT_DIMENSIONS;
import static assignment.validation.CanvasValidation.validateCanvas;
import static assignment.validation.CanvasValidation.validatePoints;

public class DrawRectangleCommand implements DrawCommand {
    Character toDraw;
    private Point startPoint;
    private Point endPoint;

    public DrawRectangleCommand(Point startPoint, Point endPoint) {
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
        drawLineForRectangle(startPoint, new Point(endPoint.getX(), startPoint.getY()), canvasArray);
        drawLineForRectangle(startPoint, new Point(startPoint.getX(), endPoint.getY()), canvasArray);
        drawLineForRectangle(new Point(endPoint.getX(), startPoint.getY()), endPoint, canvasArray);
        drawLineForRectangle(new Point(startPoint.getX(), endPoint.getY()), endPoint, canvasArray);

        return canvas;
    }

    private void drawLineForRectangle(Point startPoint, Point endPoint, char[][] canvasArray) {
        IntStream.rangeClosed(startPoint.getY(), endPoint.getY())
                .forEach(i -> IntStream
                        .rangeClosed(startPoint.getX(), endPoint.getX())
                        .forEach(j -> canvasArray[i][j] = toDraw));
    }
}
