package edu.khai.cp.aaa;

import static java.lang.Math.*;

public class Cone extends Body{
    private final double height;
    private final double radius;

    public Cone(Vector heightVector, Vector radiusVector) {
        if (heightVector == null || radiusVector == null) throw new IllegalArgumentException("Generating vector(s) cannot be null!");
        if (heightVector.isZero() || radiusVector.isZero()) throw new IllegalArgumentException("Generating vector(s) must be non-zero!");
        if (!heightVector.isPerpendicular(radiusVector)) throw new IllegalArgumentException("Generating vectors must be mutually perpendicular!");
        height = heightVector.length();
        radius = radiusVector.length();
    }

    @Override
    public double area() {
        double generatrix = sqrt(pow(height, 2) + pow(radius, 2));
        return PI * radius * (generatrix + radius);
    }

    @Override
    public double volume() {
        return PI * pow(radius, 2) * height / 3;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "height=" + height +
                ", radius=" + radius +
                '}';
    }
}
