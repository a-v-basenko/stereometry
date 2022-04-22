package edu.khai.cp.aaa;

import static java.lang.Math.*;

public class Cone extends Body{
    private final double height;
    private final double radius;

    public Cone(Vector heightVector, Vector radiusVector) {
        if (!heightVector.isPerpendicular(radiusVector)) throw new IllegalArgumentException();
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
}
