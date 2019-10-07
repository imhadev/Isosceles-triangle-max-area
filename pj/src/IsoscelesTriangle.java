import java.io.*;

public class IsoscelesTriangle {
    public static void main(String[] args) {
        double maxSquare = -1;
        double curS;
        String[] maxValues = new String[6];

        BufferedReader br = null;
        PrintWriter writer = null;
        try {
            if (args.length == 0) {
                br = new BufferedReader(new FileReader("in.txt"));
                writer = new PrintWriter("out.txt");
            }
            else {
                br = new BufferedReader(new FileReader(args[0]));
                writer = new PrintWriter(args[1]);
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                curS = CheckIsoscelesMax(values);

                if (curS > maxSquare) {
                    maxSquare = curS;
                    for (int i = 0; i < values.length; i++) {
                        maxValues[i] = values[i];
                    }
                }
            }

            if (maxSquare != -1) {
                writer.print(String.join(" ", maxValues));
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

    public static double CheckIsoscelesMax(String[] values) {
        if (values.length != 6) {
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
                return -1;
            }

            if ((a == b) || (a == c) || (b == c)) {
                p = (a + b + c) / 2;
                s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

                return s;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
