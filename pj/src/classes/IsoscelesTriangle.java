package classes;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IsoscelesTriangle {

    private static final Logger logger = Logger.getLogger(IsoscelesTriangle.class.getName());

    public static void main(String[] args) {
        if (args.length != 2) {
            logger.log(Level.SEVERE, "Wrong arguments");
            System.exit(1);
        }

        double maxArea = -1;
        String maxAreaValues = null;
        double curArea;

        String input = args[0];
        String output = args[1];

        CustomFileReader customFileReader = CustomFileReader.create(input);

        if (customFileReader == null) {
            return;
        }

        String line;
        while ((line = customFileReader.getLine()) != null) {
            int[] values = checkValues(line);
            if (values == null) {
                continue;
            }

            curArea = calculateIsoscelesTriangleArea(values);
            if (curArea > maxArea) {
                maxArea = curArea;
                maxAreaValues = line;
            }
        }

        try (PrintWriter writer = new PrintWriter(output)) {
            if (maxArea != -1) {
                writer.print(maxAreaValues);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        customFileReader.close();
    }

    public static int[] checkValues(String line) {
        String[] values = line.split(" ");
        if (values.length != 6) {
            logger.log(Level.INFO, line + " incorrect number of values");
        }
        else {
            int[] valuesInt = new int[6];

            try {
                valuesInt[0] = Integer.parseInt(values[0]);
                valuesInt[1] = Integer.parseInt(values[1]);
                valuesInt[2] = Integer.parseInt(values[2]);
                valuesInt[3] = Integer.parseInt(values[3]);
                valuesInt[4] = Integer.parseInt(values[4]);
                valuesInt[5] = Integer.parseInt(values[5]);

                return valuesInt;
            } catch (NumberFormatException e) {
                logger.log(Level.INFO, line + " error doing parseInt");
            }
        }

        return null;
    }

    public static double calculateIsoscelesTriangleArea(int[] values) {
        double a, b, c;

        a = Math.hypot(values[0] - values[2], values[1] - values[3]);
        b = Math.hypot(values[0] - values[4], values[1] - values[5]);
        c = Math.hypot(values[2] - values[4], values[3] - values[5]);

        if (!isTriangle(a, b, c)) {
            logger.log(Level.INFO, Arrays.toString(values) + " not a triangle");
            return -1;
        }

        if (!isIsoscelesTriangle(a, b, c)) {
            logger.log(Level.INFO, Arrays.toString(values) + " not an isosceles triangle");
            return -1;
        }

        return calculateTriangleArea(a, b, c);
    }

    private static boolean isTriangle(double a, double b, double c) {
        return (((a + b) > c) && ((a + c) > b) && ((b + c) > a));
    }

    private static boolean isIsoscelesTriangle(double a, double b, double c) {
        return ((a == b) || (a == c) || (b == c));
    }

    private static double calculateTriangleArea(double a, double b, double c) {
        double s, p;
        p = (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return s;
    }
}
