package assignment.canvas.commands;

import assignment.Point;
import assignment.canvas.Canvas;
import assignment.canvas.CanvasImpl;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawBucketFillCommandTest {

    @Test
    void testExecute() {
        Point point = new Point(10,20);
        DrawCommand drawCommand = new DrawBucketFillCommand(point, 'o');
        Canvas canvas = new CanvasImpl(10,40);
        canvas = drawCommand.execute(canvas);
        assertTrue(EqualsBuilder.reflectionEquals(canvas,  drawCommand.execute(canvas)));
    }
}