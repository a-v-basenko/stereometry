package edu.khai.cp.aaa;

import static java.lang.Math.*;

public class Vector {
    private final Point vectorCoordinates;

    public Vector(int x, int y, int z) {
        vectorCoordinates = new Point(x, y, z);
    }

    public Vector(Point start, Point end) {
        vectorCoordinates = new Point(end.getX() - start.getX(), end.getY() - start.getY(), end.getZ() - start.getZ());
    }

    public double length() {
        return sqrt(pow(vectorCoordinates.getX(), 2) + pow(vectorCoordinates.getY(), 2) + pow(vectorCoordinates.getZ(), 2));
    }

    public boolean isPerpendicular(Vector other) {
        return (vectorCoordinates.getX() * other.vectorCoordinates.getX() + vectorCoordinates.getY() * other.vectorCoordinates.getY() + vectorCoordinates.getZ() * other.vectorCoordinates.getZ()) == 0;
    }
}
