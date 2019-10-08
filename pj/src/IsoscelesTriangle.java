import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IsoscelesTriangle {

    private static final Logger logger = Logger.getLogger(IsoscelesTriangle.class.getName());

    public static void main(String[] args) {
        double maxSquare = -1;
        double curS;
        String maxValues = null;

        BufferedReader br = null;
        PrintWriter writer = null;
        try {
            if (args.length == 2) {
                br = new BufferedReader(new FileReader(args[0]));
                writer = new PrintWriter(args[1]);
            }
            else {
                br = new BufferedReader(new FileReader("in.txt"));
                writer = new PrintWriter("out.txt");
            }

            String line;
            while ((line = br.readLine()) != null) {
                curS = CheckIsoscelesMax(line);

                if (curS > maxSquare) {
                    maxSquare = curS;
                    maxValues = line;
                }
            }

            if (maxSquare != -1) {
                writer.print(maxValues);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.close();
        }
    }

    public static double CheckIsoscelesMax(String line) {
        String[] values = line.split(" ");
        if (values.length != 6) {
            logger.log(Level.INFO, "Incorrect number of values");
            return -1;
        }

        double a, b, c;
        int x1, x2, y1, y2, z1, z2;
        double s, p;

        try {
            x1 = Integer.parseInt(values[0]);
            x2 = Integer.parseInt(values[1]);
            y1 = Integer.parseInt(values[2]);
            y2 = Integer.parseInt(values[3]);
            z1 = Integer.parseInt(values[4]);
            z2 = Integer.parseInt(values[5]);

            a = Math.sqrt((x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2));
            b = Math.sqrt((x1 - z1) * (x1 - z1) + (x2 - z2) * (x2 - z2));
            c = Math.sqrt((y1 - z1) * (y1 - z1) + (y2 - z2) * (y2 - z2));

            if (((a + b) == c) || ((a + c) == b) || ((b + c == a))) {
                logger.log(Level.INFO, "Not a triangle");
                return -1;
            }

            if ((a == b) || (a == c) || (b == c)) {
                p = (a + b + c) / 2;
                s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

                return s;
            }
            else {
                logger.log(Level.INFO, "Not a isosceles triangle");
                return -1;
            }
        } catch (NumberFormatException e) {
            logger.log(Level.INFO, "Error doing parseInt");
            return -1;
        }
    }
}
