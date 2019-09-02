package assignment.canvas;

import assignment.Point;
import assignment.canvas.commands.DrawCommand;

import java.util.stream.IntStream;

public class CanvasImpl implements Canvas {

    private Integer width;
    private Integer height;
    private char[][] canvasArea;
    private Boolean isCanvasValid;

    public CanvasImpl(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        drawCanvasObject();
        isCanvasValid = true;

    }

    @Override
    public void setCanvasValid(Boolean canvasValid) {
        isCanvasValid = canvasValid;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public Boolean isCanvasValid() {
        return isCanvasValid;
    }


    public char[][] getCanvasArea() {
        return canvasArea;
    }

    private void drawCanvasObject() {
        height += 2;
        width += 2;
        this.canvasArea = new char[height][width];

        drawCanvas(new Point(0, 0), new Point(width - 1, 0), '-');
        drawCanvas(new Point(0, height - 1), new Point(width - 1, height - 1), '-');
        drawCanvas(new Point(0, 1), new Point(0, height - 2), '|');
        drawCanvas(new Point(width - 1, 1), new Point(width - 1, height - 2), '|');
    }

    @Override
    public void draw(DrawCommand command) {
        command.execute(this);
    }

    public void drawCanvas(Point startPoint, Point endPoint, char value) {
        IntStream.rangeClosed(startPoint.getY(), endPoint.getY())
                .forEach(i -> IntStream.rangeClosed(startPoint.getX(), endPoint.getX())
                        .forEach(j -> canvasArea[i][j] = value));
    }
}
