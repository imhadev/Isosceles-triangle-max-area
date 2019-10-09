package tests;

import classes.CustomFileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomFileReaderTest {
    @Test
    public void testCreate() {
        assertNotNull(CustomFileReader.create("test.txt"));
        assertNull(CustomFileReader.create("something.txt"));
    }

    @Test
    public void testGetLine() {
        String[] expected = new String[3];
        expected[0] = "0 0 1 0 0 1";
        expected[1] = "-1 -1 10 -1 -1 10";
        expected[2] = null;

        String[] result = new String[3];
        CustomFileReader customFileReader = CustomFileReader.create("test.txt");
        if (customFileReader == null) {
            return;
        }
        result[0] = customFileReader.getLine();
        result[1] = customFileReader.getLine();
        result[2] = customFileReader.getLine();

        assertArrayEquals(expected, result);
    }
}
