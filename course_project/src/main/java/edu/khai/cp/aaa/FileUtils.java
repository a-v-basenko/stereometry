package edu.khai.cp.aaa;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    private static final String number = "[-]?[0-9]+";
    private static final String point = String.format("Point\\(%s,\\s*%s,\\s*%s\\)", number, number, number);
    private static final String vectorOnPoints = String.format("Vector\\(%s,\\s*%s\\)", point, point);
    private static final String vectorOnValues = String.format("Vector\\(%s,\\s*%s,\\s*%s\\)", number, number, number);

    public static List<Body> fileContentProcessing(List<String> content) {
        List<Body> bodies = new ArrayList<>();
        for (String body: content) {
            if (body.matches("Ball\\(.*\\)") && matchesToVector(body)) { //!!!!!!!!!!!!!!!!!!!!!!!!!!!
                List <Vector> vectors = vectorsParser(body);
                if (vectors.size() != 1) {
                    throw new IllegalArgumentException("Wrong body format: " + body);
                }
                bodies.add(new Ball(vectors.get(0)));
            } else if (body.matches("Cone\\(.*\\)") && matchesToVector(body)) {
                List <Vector> vectors = vectorsParser(body);
                if (vectors.size() != 2) {
                    throw new IllegalArgumentException("Wrong body format: " + body);
                }
                bodies.add(new Cone(vectors.get(0), vectors.get(1)));
            } else if (body.matches("Parallelepiped\\(.*\\)") && matchesToVector(body)) {
                List <Vector> vectors = vectorsParser(body);
                if (vectors.size() != 3) {
                    throw new IllegalArgumentException("Wrong body format: " + body);
                }
                bodies.add(new Parallelepiped(vectors.get(0), vectors.get(1), vectors.get(2)));
            } else {
                throw new IllegalArgumentException("Wrong body format: " + body);
            }
        }
        return bodies;
    }

    private static boolean matchesToVector(String str) {
        return str.matches(".*" + vectorOnValues + ".*") || str.matches(".*" + vectorOnPoints + ".*");
    }

    private static Point pointParser(String str) {
        Pattern pattern = Pattern.compile(number);
        Matcher matcher = pattern.matcher(str);
        List<Integer> numbers = new ArrayList<>();
        while(matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("Wrong point format: " + str);
        }
        return new Point(numbers.get(0), numbers.get(1), numbers.get(2));
    }

    private static Vector vectorParserOnPoints(String vector) {
        Pattern pattern = Pattern.compile(point);
        Matcher matcher = pattern.matcher(vector);
        List<Point> points = new ArrayList<>();
        while(matcher.find()) {
            points.add(pointParser(matcher.group()));
        }
        if (points.size() != 2) {
            throw new IllegalArgumentException("Wrong vector format: " + vector);
        }
        return new Vector(points.get(0), points.get(1));
    }

    private static Vector vectorParserOnValues(String vector) {
        Pattern pattern = Pattern.compile(number);
        Matcher matcher = pattern.matcher(vector);
        List<Integer> numbers = new ArrayList<>();
        while(matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("Wrong vector format: " + vector);
        }
        return new Vector(numbers.get(0), numbers.get(1), numbers.get(2));
    }

    private static List<Vector> vectorsParser(String vectorStr) {
        Map<Integer, Vector> mapOfVectors = new HashMap<>();
        Pattern pattern = Pattern.compile(vectorOnValues);
        Matcher matcher = pattern.matcher(vectorStr);
        while(matcher.find()) {
            mapOfVectors.put(matcher.start(), vectorParserOnValues(matcher.group()));
        }
        pattern = Pattern.compile(vectorOnPoints);
        matcher = pattern.matcher(vectorStr);
        while (matcher.find()) {
            mapOfVectors.put(matcher.start(), vectorParserOnPoints(matcher.group()));
        }
        List<Integer> vectorsOrder = new ArrayList<>(mapOfVectors.keySet());
        Collections.sort(vectorsOrder);
        List<Vector> vectors = new ArrayList<>();
        for (Integer key : vectorsOrder) {
            vectors.add(mapOfVectors.get(key));
        }

        return vectors;
    }
}
