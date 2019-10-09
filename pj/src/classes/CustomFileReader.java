package classes;

import java.io.*;

public class CustomFileReader {

    public final BufferedReader br;

    private CustomFileReader(BufferedReader br) {
        this.br = br;
    }

    public static CustomFileReader create(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            return new CustomFileReader(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getLine() {
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public void close() {
        try {
            this.br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
