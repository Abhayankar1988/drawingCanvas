package com.credit.assignment.command;

import assignment.Point;
import assignment.canvas.commands.CommandInterpreter;
import assignment.canvas.commands.DrawCommand;
import assignment.canvas.commands.DrawRectangleCommand;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DrawRectangleCommandTest {

    String command = null;
    Optional<DrawCommand> drawCommand = null;

    @Test
    void execute() {
        command = new String("R 14 1 18 3");
        drawCommand = CommandInterpreter.getCommand(command);
        assertTrue(EqualsBuilder.reflectionEquals(new DrawRectangleCommand(new Point(14,1), new Point(18,3)),drawCommand.get()));

    }
}