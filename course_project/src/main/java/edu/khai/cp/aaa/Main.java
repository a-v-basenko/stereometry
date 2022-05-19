package edu.khai.cp.aaa;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Series series = new Series();
        boolean loop = true;
        while (loop) {
            System.out.println("""
                1. Add body to the list
                2. Remove body from the list
                3. Clear the list
                4. Get body from the list
                5. Calculate average values
                6. Find the body that has the min values
                7. Find the body that has the max values
                8. Review the list
                0. Exit""");
            System.out.print("Enter action: ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("""
                        1. Ball
                        2. Cone
                        3. Parallelepiped""");
                    System.out.print("Enter body: ");
                    switch (scanner.nextInt()) {
                        case 1 -> series.add(new Ball(createVector()));
                        case 2 -> series.add(new Cone(createVector(), createVector()));
                        case 3 -> series.add(new Parallelepiped(createVector(), createVector(), createVector()));
                    }
                }
                case 2 -> {
                    System.out.print("Enter index to remove body: ");
                    try {
                        series.remove(scanner.nextInt());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 3 -> series.clear();
                case 4 -> {
                    Body body;
                    boolean loop4 = true;
                    System.out.print("Enter index to get body: ");
                    try {
                        body = series.get(scanner.nextInt());
                        while (loop4) {
                            System.out.println("""
                            1. Calculate area
                            2. Calculate volume
                            3. Review
                            0. Back""");
                            System.out.print("Enter action: ");
                            switch (scanner.nextInt()) {
                                case 1 -> System.out.println("Area = " + body.area());
                                case 2 -> System.out.println("Volume = " + body.volume());
                                case 3 -> System.out.println(body.toString());
                                case 0 -> loop4 = false;
                            }
                            System.out.print("Enter '0' to exit");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("""
                        1. Calculate average area
                        2. Calculate average volume""");
                    System.out.print("Enter action: ");
                    switch (scanner.nextInt()) {
                        case 1 -> System.out.println(series.averageArea());
                        case 2 -> System.out.println(series.averageVolume());
                    }
                }
                case 6 -> {
                    System.out.println("""
                        1. Find the body that has the min area
                        2. Find the body that has the min volume""");
                    System.out.print("Enter action: ");
                    try {
                        switch (scanner.nextInt()) {
                            case 1 -> System.out.println(series.minByArea().toString());
                            case 2 -> System.out.println(series.minByVolume().toString());
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 7 -> {
                    System.out.println("""
                        1. Find the body that has the max area
                        2. Find the body that has the max volume""");
                    System.out.print("Enter action: ");
                    try {
                        switch (scanner.nextInt()) {
                            case 1 -> System.out.println(series.maxByArea().toString());
                            case 2 -> System.out.println(series.maxByVolume().toString());
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 8 -> System.out.println(series);
                case 0 -> loop = false;
            }
        }
    }

    private static Vector createVector() {
        System.out.println("""
                1. Set vector coordinates
                2. Set point coordinates""");
        while (true) {
            System.out.print("Enter way to create vector: ");
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Enter vector coordinates: ");
                    return new Vector(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                }
                case 2 -> {
                    Point start, end;
                    System.out.print("Enter start point coordinates: ");
                    start = new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    System.out.print("Enter end point coordinates: ");
                    end = new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    return new Vector(start, end);
                }
            }
        }
    }
}
