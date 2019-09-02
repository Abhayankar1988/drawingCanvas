package assignment.canvas.commands;

import assignment.Point;
import assignment.canvas.Canvas;

import static assignment.CanvasConstants.INCORRECT_DIMENSIONS;
import static assignment.validation.CanvasValidation.validateCanvas;
import static assignment.validation.CanvasValidation.validatePoints;

public class DrawBucketFillCommand implements DrawCommand {
    private Point point;
    private Character toDraw;

    public DrawBucketFillCommand(Point point, char c) {
        this.point = point;
        this.toDraw = c;
    }

    @Override
    public Canvas execute(Canvas canvas) {
        canvas.setCanvasValid(true);
        validateCanvas(canvas);
        validatePoints(point, point, canvas);

        if (!canvas.isCanvasValid()) {
            System.out.println(INCORRECT_DIMENSIONS);
            return canvas;
        }

        fillBucket(point, canvas);
        return canvas;
    }


    public void fillBucket(Point point, Canvas canvas) {


        char canvasArea[][] = canvas.getCanvasArea();
        int x = point.getX();
        int y = point.getY();

        if ((int) canvasArea[y][x] != 0) {
            return;
        }
        if (x > 0 || x < canvas.getHeight() || y > 0 || y < canvas.getWidth()) {
            if ((int) canvasArea[y][x] == 0)
                canvasArea[y][x] = toDraw;

            fillBucket(new Point(x + 1, y), canvas);

            fillBucket(new Point(x - 1, y), canvas);

            fillBucket(new Point(x, y - 1), canvas);

            fillBucket(new Point(x, y + 1), canvas);

        }
    }
}
