package assignment.canvas;

import assignment.canvas.commands.DrawCommand;

public interface Canvas {
    void draw(DrawCommand command);

    char[][] getCanvasArea();

    Integer getWidth();

    Integer getHeight();

    Boolean isCanvasValid();

    void setCanvasValid(Boolean isCanvasValid);
}
