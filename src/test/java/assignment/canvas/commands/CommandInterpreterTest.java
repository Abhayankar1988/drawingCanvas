package assignment.canvas.commands;

import assignment.Point;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandInterpreterTest {

    private String command = null;
    private Optional<DrawCommand> drawCommand = null;

    @Test
    void testDrawBlankCanvasCommand() {
        command = new String("C 20 30");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(new DrawBlankCanvasCommand(20, 30), drawCommand.get()));
    }

    @Test
    void testDrawLineCommand() {
        command = new String("L 1 2 6 2");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(new DrawLineCommand(new Point(1,2), new Point(6,2))
                , drawCommand.get()));

    }

    @Test
    void testDrawRectangleCommand() {
        command = new String("R 14 1 18 3");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(new DrawRectangleCommand(new Point(14,1), new Point(18,3)),drawCommand.get()));
    }

    @Test
    void testDrawBucketFillCommand() {
        command = new String("B 10 3 o");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(new DrawBucketFillCommand(new Point(10, 3), 'o'), drawCommand.get()));
    }

    @Test
    void testDrawBlankCanvasCommandForInValidInputs() {
        command = new String("C -20 30");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(Optional.empty(), drawCommand));
    }

    @Test
    void testDrawLineCommandForInValidInputs() {
        command = new String("L 1 -2 6 -2");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(Optional.empty(), drawCommand));

    }

    @Test
    void testDrawRectangleCommandForInValidInputs() {
        command = new String("R 14 -1 18 3");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(Optional.empty(), drawCommand));
    }

    @Test
    void testDrawBucketFillCommandForInValidInputs() {
        command = new String("B -10 3 o");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(Optional.empty(), drawCommand));
    }
}