package assignment.canvas.commands;

import assignment.canvas.Canvas;
import assignment.canvas.CanvasImpl;

public class DrawBlankCanvasCommand implements DrawCommand {

    private Integer height;
    private Integer width;

    public DrawBlankCanvasCommand(Integer width, int height) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Canvas execute(Canvas canvas) {
        return new CanvasImpl(width, height);
    }

}
