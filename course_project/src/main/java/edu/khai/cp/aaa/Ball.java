package edu.khai.cp.aaa;

import static java.lang.Math.*;

public class Ball extends Body {
    private final double radius;

    public Ball(Vector radiusVector) {
        if (radiusVector == null) throw new IllegalArgumentException("Generating vector(s) cannot be null!");
        if (radiusVector.isZero()) throw new IllegalArgumentException("Generating vector(s) must be non-zero!");
        radius = radiusVector.length();
    }

    @Override
    public double area() {
        return 4 * PI * pow(radius, 2);
    }

    @Override
    public double volume() {
        return 4 * PI * pow(radius, 3) / 3;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "radius=" + radius +
                '}';
    }
}
