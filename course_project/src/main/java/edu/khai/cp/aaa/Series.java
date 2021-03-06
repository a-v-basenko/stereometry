package edu.khai.cp.aaa;

import java.util.ArrayList;
import java.util.List;

public class Series {
    private final List<Body> bodies;

    public Series() {
        bodies = new ArrayList<>();
    }

    public void add(Body body) {
        if (body == null) throw new IllegalArgumentException("Body cannot be null!");
        bodies.add(body);
    }

    public void remove(int idx) {
        if (idx < 0 || idx >= bodies.size()) throw new IllegalArgumentException("Index out of range!");
        bodies.remove(idx);
    }

    public void clear() {
        bodies.clear();
    }

    public Body get(int idx) {
        if (idx < 0 || idx >= bodies.size()) throw new IllegalArgumentException("Index out of range!");
        return bodies.get(idx);
    }

    public double averageArea() {
        if (bodies.isEmpty()) return 0;
        double result = 0;
        for (Body body: bodies) {
            result += body.area();
        }
        return result / bodies.size();
    }

    public double averageVolume() {
        if (bodies.isEmpty()) return 0;
        double result = 0;
        for (Body body: bodies) {
            result += body.volume();
        }
        return result / bodies.size();
    }

    public Body minByArea() {
        if (bodies.isEmpty()) throw new IllegalStateException("List is empty!");
        Body minBodyByArea = bodies.get(0);
        for (Body body: bodies) {
            if (body.area() < minBodyByArea.area()) {
                minBodyByArea = body;
            }
        }
        return minBodyByArea;
    }

    public Body maxByArea() {
        if (bodies.isEmpty()) throw new IllegalStateException("List is empty!");
        Body maxBodyByArea = bodies.get(0);
        for (Body body: bodies) {
            if (body.area() > maxBodyByArea.area()) {
                maxBodyByArea = body;
            }
        }
        return maxBodyByArea;
    }

    public Body minByVolume() {
        if (bodies.isEmpty()) throw new IllegalStateException("List is empty!");
        Body minBodyByVolume = bodies.get(0);
        for (Body body: bodies) {
            if (body.volume() < minBodyByVolume.volume()) {
                minBodyByVolume = body;
            }
        }
        return minBodyByVolume;
    }

    public Body maxByVolume() {
        if (bodies.isEmpty()) throw new IllegalStateException("List is empty!");
        Body maxBodyByVolume = bodies.get(0);
        for (Body body: bodies) {
            if (body.volume() > maxBodyByVolume.volume()) {
                maxBodyByVolume = body;
            }
        }
        return maxBodyByVolume;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Body body: bodies) {
            result.append("\n\t").append(body.toString());
        }
        return "Series{" + result + "\n}";
    }
}
