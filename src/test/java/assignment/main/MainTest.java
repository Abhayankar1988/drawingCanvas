package assignment.main;

import assignment.canvas.Canvas;
import org.junit.jupiter.api.Test;

import static assignment.main.Main.getCanvasFromCommand;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private Canvas canvas;

    @Test
    void testDrawBlankCanvas() {
        String command = "C 20 4";
        canvas = getCanvasFromCommand(command);
        assertEquals("----------------------\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------", Main.render(canvas));
    }

    @Test
    void testDrawLine() {
        String command = "C 20 4";
        canvas = getCanvasFromCommand(command);

        command = "L 1 2 6 2";
        canvas = getCanvasFromCommand(command);
        assertEquals("----------------------\n" +
                "|                    |\n" +
                "|XXXXXX              |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "----------------------", Main.render(canvas));
    }

    @Test
    void testDrawRectangle() {
        String command = "C 20 4";
        canvas = getCanvasFromCommand(command);

        command = "L 1 2 6 2";
        canvas = getCanvasFromCommand(command);

        command = "L 6 3 6 4";
        canvas = getCanvasFromCommand(command);

        command = "R 14 1 18 3";
        canvas = getCanvasFromCommand(command);

        assertEquals("----------------------\n" +
                "|             XXXXX  |\n" +
                "|XXXXXX       X   X  |\n" +
                "|     X       XXXXX  |\n" +
                "|     X              |\n" +
                "----------------------", Main.render(canvas));
    }

    @Test
    void testBucketFill() {
        String command = "C 20 4";
        canvas = getCanvasFromCommand(command);

        command = "L 1 2 6 2";
        canvas = getCanvasFromCommand(command);

        command = "L 6 3 6 4";
        canvas = getCanvasFromCommand(command);

        command = "R 14 1 18 3";
        canvas = getCanvasFromCommand(command);

        command = "B 10 3 o";
        canvas = getCanvasFromCommand(command);

        assertEquals("----------------------\n" +
                "|oooooooooooooXXXXXoo|\n" +
                "|XXXXXXoooooooX   Xoo|\n" +
                "|     XoooooooXXXXXoo|\n" +
                "|     Xoooooooooooooo|\n" +
                "----------------------", Main.render(canvas));
    }

    @Test
    void testDrawLineForNegativePointAndIncorrectCommand() {

        String command = "l 1 2 6 2";
        canvas = getCanvasFromCommand(command);
        assertEquals(null, canvas);

        command = "L 1 2 -6 2";
        canvas = getCanvasFromCommand(command);
        assertEquals(null, canvas);
    }


    @Test
    void testBucketFillForNegativePointAndIncorrectCommand() {
        String command = "B -10 3 o";
        canvas = getCanvasFromCommand(command);
        assertEquals(null, canvas);

        command = "b 10 3 o";
        canvas = getCanvasFromCommand(command);
        assertEquals(null, canvas);

    }
}