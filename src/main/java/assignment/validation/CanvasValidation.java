package assignment.validation;

import assignment.Point;
import assignment.Shape;
import assignment.canvas.Canvas;

import java.util.*;
import java.util.stream.Collectors;


public class CanvasValidation {
    static Map<Shape, Integer> shapeValueMap = null;

    static {
        shapeValueMap = new HashMap<>();
        shapeValueMap.put(Shape.CANVAS, 3);
        shapeValueMap.put(Shape.LINE, 5);
        shapeValueMap.put(Shape.RECTANGLE, 5);
        shapeValueMap.put(Shape.BUCKETFILL, 4);
        shapeValueMap.put(Shape.NO_SHAPE, -1);
    }

    public static boolean checkPointValues(String[] point) {
        Shape shape = Shape.getGeometryTypeForName(point[0].charAt(0));
        List<String> linkedList = new LinkedList<>();
        linkedList.addAll(Arrays.asList(point));
        linkedList.remove(0);
        List<String> pointList = linkedList
                .stream()
                .filter(p -> Integer.parseInt(p) < 0)
                .collect(Collectors.toList());
        if (!pointList.isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean checkPointValuesForBucketFill(String[] point) {
        List<String> linkedList = new LinkedList<>();
        linkedList.addAll(Arrays.asList(point));
        linkedList.remove(0);
        linkedList.remove(linkedList.size() - 1);
        List<String> pointList = linkedList
                .stream()
                .filter(p -> Integer.parseInt(p) < 0)
                .collect(Collectors.toList());
        if (!pointList.isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean validateForProperCommand(String command) {
        Shape shape = Shape.getGeometryTypeForName(command.charAt(0));

        if (shapeValueMap.get(shape) != command.split(" ").length) {
            return false;
        }
        if (shape.name().equals("NO_SHAPE")) {
            return false;
        }
        return true;
    }

    public static void validateCanvas(Canvas canvas) {
        if (canvas.getCanvasArea() == null) {
            canvas.setCanvasValid(false);
        }
    }

    public static void validatePoints(Point startPoint, Point endPoint, Canvas canvas) {
        if ((startPoint.getX() + 2) > canvas.getWidth() || (startPoint.getY() + 2) > canvas.getHeight()
                || (endPoint.getX() + 2) > canvas.getWidth() || (endPoint.getY() + 2) > canvas.getHeight()) {
            canvas.setCanvasValid(false);
        }
    }


}
