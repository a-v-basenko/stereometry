package edu.khai.cp.aaa;

import java.util.ArrayList;
import java.util.List;

public class Series {
    private final List<Body> bodies;

    public Series() {
        bodies = new ArrayList<>();
    }

    public void add(Body body) {
        bodies.add(body);
    }

    public void remove(int idx) {
        if (idx < 0 || idx >= bodies.size()) throw new IllegalArgumentException();
        bodies.remove(idx);
    }

    public void clear() {
        bodies.clear();
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
