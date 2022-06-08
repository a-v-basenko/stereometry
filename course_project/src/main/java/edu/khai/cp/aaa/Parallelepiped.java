package edu.khai.cp.aaa;

public class Parallelepiped extends Body{
    private final double height;
    private final double width;
    private final double depth;

    public Parallelepiped(Vector heightVector, Vector widthVector, Vector depthVector) {
        if (heightVector == null || widthVector == null || depthVector == null) throw new IllegalArgumentException("Generating vector(s) cannot be null!");
        if (heightVector.isZero() || widthVector.isZero() || depthVector.isZero()) throw new IllegalArgumentException("Generating vector(s) must be non-zero!");
        if (!heightVector.isPerpendicular(widthVector)
                || !widthVector.isPerpendicular(depthVector)
                || !depthVector.isPerpendicular(heightVector)
        ) throw new IllegalArgumentException("Generating vectors must be mutually perpendicular!");
        height = heightVector.length();
        width = widthVector.length();
        depth = depthVector.length();
    }

    @Override
    public double area() {
        return 2 * (height * width + width * depth + depth * height);
    }

    @Override
    public double volume() {
        return height * width * depth;
    }

    @Override
    public String toString() {
        return "Parallelepiped{" +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                '}';
    }
}
