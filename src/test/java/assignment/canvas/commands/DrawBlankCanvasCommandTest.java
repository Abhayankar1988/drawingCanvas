package assignment.canvas.commands;

import assignment.canvas.Canvas;
import assignment.canvas.CanvasImpl;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawBlankCanvasCommandTest {

    @Test
    void testExecute() {
        DrawCommand drawCommand = new DrawBlankCanvasCommand(10,40);
        Canvas canvas = new CanvasImpl(10,40);
        assertTrue(EqualsBuilder.reflectionEquals(new CanvasImpl(10,40),  drawCommand.execute(canvas)));
    }
}