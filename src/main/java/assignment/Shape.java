package assignment;

public enum Shape {
    CANVAS('C'),
    LINE('L'),
    BUCKETFILL('B'),
    RECTANGLE('R'),
    NO_SHAPE('N');

    private char name;

    Shape(char name) {
        this.name = name;
    }

    public static Shape getGeometryTypeForName(final char name) {
        for (Shape type : Shape.values())
            if (type.name == name)
                return type;

        return Shape.NO_SHAPE;
    }
}
