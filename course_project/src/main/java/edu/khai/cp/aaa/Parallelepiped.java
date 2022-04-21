package edu.khai.cp.aaa;

public class Parallelepiped extends Body{
    private final double height;
    private final double width;
    private final double length;

    public Parallelepiped(Vector heightVector, Vector widthVector, Vector lengthVector) {
        if (!heightVector.isPerpendicular(widthVector)
                || !widthVector.isPerpendicular(lengthVector)
                || !lengthVector.isPerpendicular(heightVector)
        ) throw new IllegalArgumentException();
        height = heightVector.length();
        width = widthVector.length();
        length = lengthVector.length();
    }

    @Override
    public double area() {
        return 2 * (height * width + width * length + length * height);
    }

    @Override
    public double volume() {
        return height * width * length;
    }
}