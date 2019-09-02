package assignment.canvas.commands;

import assignment.canvas.Canvas;

public interface DrawCommand {
	Canvas execute(Canvas canvas);
}
