package edu.khai.cp.aaa;

import static java.lang.Math.*;

public class Vector {
    private final Point vectorCoordinates;

    public Vector(int x, int y, int z) {
        vectorCoordinates = new Point(x, y, z);
    }

    public Vector(Point start, Point end) {
        if (start == null || end == null) throw new IllegalArgumentException();
        vectorCoordinates = new Point(end.getX() - start.getX(), end.getY() - start.getY(), end.getZ() - start.getZ());
    }

    public double length() {
        return sqrt(pow(vectorCoordinates.getX(), 2) + pow(vectorCoordinates.getY(), 2) + pow(vectorCoordinates.getZ(), 2));
    }

    public boolean isPerpendicular(Vector other) {
        if (other == null) throw new IllegalArgumentException();
        if (isZero() || other.isZero()) throw new IllegalArgumentException();
        return (vectorCoordinates.getX() * other.vectorCoordinates.getX() + vectorCoordinates.getY() * other.vectorCoordinates.getY() + vectorCoordinates.getZ() * other.vectorCoordinates.getZ()) == 0;
    }

    public boolean isZero() {
        return vectorCoordinates.getX() == 0 && vectorCoordinates.getY() == 0 && vectorCoordinates.getZ() == 0;
    }
}
